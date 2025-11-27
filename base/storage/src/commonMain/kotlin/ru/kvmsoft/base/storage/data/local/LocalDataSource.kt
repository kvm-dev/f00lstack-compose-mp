package ru.kvmsoft.base.storage.data.local

import io.ktor.http.content.MultiPartData
import ru.kvmsoft.base.storage.AppDatabase
import ru.kvmsoft.base.storage.data.drivers.DatabaseDriverFactory
import ru.kvmsoft.base.storage.mapper.Mapper
import ru.kvmsoft.base.storage.model.Book
import ru.kvmsoft.base.storage.model.Books
import ru.kvmsoft.base.storage.model.Events
import ru.kvmsoft.base.storage.model.Material
import ru.kvmsoft.base.storage.model.Materials
import ru.kvmsoft.base.storage.model.News
import ru.kvmsoft.base.storage.model.OfflineAuthData
import ru.kvmsoft.base.storage.model.OfflineComment
import ru.kvmsoft.base.storage.model.OfflineTestResult
import ru.kvmsoft.base.storage.model.PassedTest
import ru.kvmsoft.base.storage.model.PassedTests
import ru.kvmsoft.base.storage.model.ProfessionListItem
import ru.kvmsoft.base.storage.model.Professions
import ru.kvmsoft.base.storage.model.Profile
import ru.kvmsoft.base.storage.model.Question
import ru.kvmsoft.base.storage.model.Studies
import ru.kvmsoft.base.storage.model.Study
import ru.kvmsoft.base.storage.model.Test
import ru.kvmsoft.base.storage.model.Tests

class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase.Companion(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getProfile(): Profile {
        val profile = dbQuery.selectProfile().executeAsOne()
        val achievements = dbQuery.selectAchievments().executeAsList()
        val purchasedProfessions = dbQuery.selectPurchasedProfessions().executeAsList()
        return Profile(
            userId = profile.userId.toInt(),
            userName = profile.userName,
            userType = profile.userType,
            userStatus = profile.userStatus.toInt(),
            userEmail = profile.userEmail,
            userAchievements = Mapper.mapAchievement(achievements),
            userPhotoBase64 = profile.userPhotoBase64,
            userPurchasedProfessions = Mapper.mapPurchasedProfessions(purchasedProfessions)
        )
    }

    internal fun clearAndSaveProfile(profile: Profile){
        dbQuery.clearAllProfiles()
        dbQuery.clearAllAchievments()
        dbQuery.clearAllPurchasedProfessions()
        dbQuery.insertProfile(
            userId = profile.userId.toLong(),
            userName = profile.userName,
            userType = profile.userType,
            userStatus = profile.userStatus.toLong(),
            userEmail = profile.userEmail,
            userPhotoBase64 = profile.userPhotoBase64
        )
        profile.userAchievements.forEach { achievement->
            dbQuery.insertAchievment(
                achievementId = achievement.achievementId.toLong(),
                userId = achievement.userId.toLong(),
                achievementName = achievement.achievementName,
                achievementDescription = achievement.achievementDescription,
                achievementLevel = achievement.achievementLevel.toLong()
            )
        }
        profile.userPurchasedProfessions.forEach { professionId->
            dbQuery.insertPurchasedProfession(
                userId = profile.userId.toLong(),
                professionId = professionId.toLong()
            )
        }
    }

    internal fun clearProfileAndPassedTests(){
        dbQuery.clearAllProfiles()
        dbQuery.clearAllAchievments()
        dbQuery.clearAllPurchasedProfessions()
        dbQuery.clearAllPassedTests()
    }

    internal fun getMaterials(): Materials {
        val materials = ArrayList<Material>()
        dbQuery.selectMaterials().executeAsList().forEach {material ->
            val knowledgeAreas =  Mapper.mapKnowledgeAreas(
                dbQuery.selectMaterialsKnowledgeAreas(materialId = material.materialId)
                    .executeAsList())
            val subProfessions = Mapper.mapMaterialSubProfessions(
                dbQuery.selectMaterialSubProfessions(materialId = material.materialId)
                    .executeAsList())

            materials.add(Material(
                materialId = material.materialId.toInt(),
                materialName = material.materialName,
                materialText = material.materialText,
                materialPriority = material.materialPriority.toInt(),
                knowledgeAreas = knowledgeAreas,
                subProfessions = subProfessions
            ))
        }
        return Materials(
            materials = materials
        )
    }

    internal fun clearAndSaveMaterials(materials: Materials){
        dbQuery.clearAllMaterials()
        dbQuery.clearAllMaterialsKnowledgeAreas()
        dbQuery.clearAllMaterialSubProfessions()
        materials.materials.forEach { material->
            dbQuery.insertMaterial(
                materialId = material.materialId.toLong(),
                materialName = material.materialName,
                materialText = material.materialText,
                materialPriority = material.materialPriority.toLong()
            )
            material.knowledgeAreas.forEach {knowledgeArea->
                dbQuery.insertMaterialsKnowledgeArea(
                    materialId = material.materialId.toLong(),
                    knowledgeAreaId = knowledgeArea.areaId.toLong(),
                    knowledgeAreaName = knowledgeArea.areaName
                )
            }
            material.subProfessions.forEach { subProfession->
                dbQuery.insertMaterialSubProfession(
                    materialId = material.materialId.toLong(),
                    materialSubProfessionId = subProfession.professionId.toLong(),
                    materialSubProfessionName = subProfession.professionName
                )
            }
        }
    }

    internal fun getTests(): Tests {
        val tests = ArrayList<Test>()
        dbQuery.selectTests().executeAsList().forEach {test ->
            val professions =  Mapper.mapTestProfessions(
                dbQuery.selectTestProfessions(testId = test.testId)
                    .executeAsList())
            val questions = ArrayList<Question>()
            dbQuery.selectTestQuestions(testId = test.testId).executeAsList().forEach { question->
                val variants = Mapper.mapQuestionVariants(dbQuery.selectTestQuestionVariant(
                    questionId = question.questionId)
                    .executeAsList())
                questions.add(
                    Question(
                        questionId = question.questionId.toInt(),
                        questionText = question.questionText,
                        variants = variants
                    )
                )
            }

            tests.add(Test(
                testId = test.testId.toInt(),
                testName = test.testName,
                testLevel = test.testLevel.toInt(),
                testTimeLimit = test.testTimeLimit.toInt(),
                questions = questions,
                professions = professions
            ))
        }
        return Tests(
            tests = tests
        )
    }

    internal fun clearAndSaveTests(tests: Tests){
        dbQuery.clearAllTests()
        dbQuery.clearAllTestProfessions()
        dbQuery.clearAllTestQuestions()
        dbQuery.clearAllTestQuestionVariant()
        tests.tests.forEach { test->
            dbQuery.insertTests(
                testId = test.testId.toLong(),
                testName = test.testName,
                testLevel = test.testLevel.toLong(),
                testTimeLimit = test.testTimeLimit.toLong()
            )
            test.professions.forEach { profession->
                dbQuery.insertTestProfessions(
                    professionId = profession.professionId.toLong(),
                    professionName = profession.professionName,
                    testId = test.testId.toLong()
                )
            }
            test.questions.forEach { question->
                dbQuery.insertTestQuestion(
                    testId = test.testId.toLong(),
                    questionId = question.questionId.toLong(),
                    questionText = question.questionText
                )
                question.variants.forEach { variant->
                    val isRight = if(variant.isRight){
                        1
                    } else{
                        0
                    }
                    dbQuery.insertTestQuestionVariant(
                        questionId = question.questionId.toLong(),
                        variantId = variant.variantId.toLong(),
                        variantText = variant.variantText,
                        isRight = isRight.toLong()
                    )
                }
            }
        }
    }

    internal fun getPassedTests(): PassedTests {
        return Mapper.mapPassedTests(dbQuery.selectPassedTests().executeAsList())
    }

    internal fun clearAndSavePassedTests(passedTests: PassedTests){
        dbQuery.clearAllPassedTests()
        passedTests.passedTests.forEach { passedTest->
            dbQuery.insertPassedTest(
                testId = passedTest.testId.toLong(),
                testResult = passedTest.testResult.toLong(),
                finishTestTime = passedTest.finishTestTime
            )
        }
    }

    internal fun addPassedTest(passedTest: PassedTest){
        dbQuery.insertPassedTest(
            testId = passedTest.testId.toLong(),
            testResult = passedTest.testResult.toLong(),
            finishTestTime = passedTest.finishTestTime
        )
    }


    internal fun getProfessions(): Professions {
        return Mapper.mapProfessions(dbQuery.selectProfessions().executeAsList())
    }

    internal fun clearAndSaveProfessions(professions: Professions){
        dbQuery.clearAllProfessions()
        for(i in professions.professions.indices){
            dbQuery.insertProfession(professionId = professions.professions[i].professionId.toLong(),
                professionType = professions.professions[i].professionType.toLong(),
                professionName = professions.professions[i].professionName,
                professionParent = professions.professions[i].professionParent.toLong(),
                professionPriority = professions.professions[i].professionPriority.toLong(),
                professionImageBase64 = professions.professions[i].professionImageBase64)
            for(a in professions.professions[i].subProfessions.indices){
                dbQuery.insertProfession(professionId = professions.professions[i].subProfessions[a].professionId.toLong(),
                    professionType = professions.professions[i].subProfessions[a].professionType.toLong(),
                    professionName = professions.professions[i].subProfessions[a].professionName,
                    professionParent = professions.professions[i].subProfessions[a].professionParent.toLong(),
                    professionPriority = professions.professions[i].subProfessions[a].professionPriority.toLong(),
                    professionImageBase64 = professions.professions[i].subProfessions[a].professionImageBase64)
                for(b in professions.professions[i].subProfessions[a].subProfessions.indices){
                    dbQuery.insertProfession(professionId = professions.professions[i].subProfessions[a].subProfessions[b].professionId.toLong(),
                        professionType = professions.professions[i].subProfessions[a].subProfessions[b].professionType.toLong(),
                        professionName = professions.professions[i].subProfessions[a].subProfessions[b].professionName,
                        professionParent = professions.professions[i].subProfessions[a].subProfessions[b].professionParent.toLong(),
                        professionPriority = professions.professions[i].subProfessions[a].subProfessions[b].professionPriority.toLong(),
                        professionImageBase64 = professions.professions[i].subProfessions[a].subProfessions[b].professionImageBase64)
                    for(c in professions.professions[i].subProfessions[a].subProfessions[b].subProfessions.indices){
                        dbQuery.insertProfession(professionId = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionId.toLong(),
                            professionType = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionType.toLong(),
                            professionName = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionName,
                            professionParent = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionParent.toLong(),
                            professionPriority = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionPriority.toLong(),
                            professionImageBase64 = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].professionImageBase64)
                        for(d in professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions.indices){
                            dbQuery.insertProfession(professionId = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionId.toLong(),
                                professionType = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionType.toLong(),
                                professionName = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionName,
                                professionParent = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionParent.toLong(),
                                professionPriority = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionPriority.toLong(),
                                professionImageBase64 = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].professionImageBase64)
                            for(e in professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions.indices){
                                dbQuery.insertProfession(professionId = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionId.toLong(),
                                    professionType = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionType.toLong(),
                                    professionName = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionName,
                                    professionParent = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionParent.toLong(),
                                    professionPriority = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionPriority.toLong(),
                                    professionImageBase64 = professions.professions[i].subProfessions[a].subProfessions[b].subProfessions[c].subProfessions[d].subProfessions[e].professionImageBase64)
                            }
                        }
                    }
                }
            }
        }
    }

    internal fun getCurrentProfession(): Int {
        val profession = dbQuery.selectCurrentProfession().executeAsList()
        if (profession.isNotEmpty()){
            return profession.first().toInt()
        }
        else{
            return 0
        }
    }

    internal fun updateCurrentProfession(professionId: Int) {
        val profession = dbQuery.selectCurrentProfession().executeAsList()
        if (profession.isNotEmpty()){
            dbQuery.clearCurrentProfession()
            dbQuery.insertCurrentProfession(professionId.toLong())
        }
        else{
            dbQuery.insertCurrentProfession(professionId.toLong())
        }
    }



    internal fun getEvents(): Events {
        val events = dbQuery.selectEvents().executeAsList()
        val eventsSubs = dbQuery.selectAllEventSubs().executeAsList()

        return Mapper.mapEvents(events = events, eventsSubs = eventsSubs)
    }

    internal fun clearAndSaveEvents(events: Events){
        dbQuery.clearAllEvents()
        dbQuery.clearAllEventSubs()
        events.events.forEach {event->
            dbQuery.insertEvents(
                eventId = event.eventId.toLong(),
                eventName = event.eventName,
                eventDescription = event.eventDescription,
                eventCost = event.eventCost.toLong(),
                eventDateStart = event.eventDateStart,
                eventRefLink = event.eventRefLink,
                eventImageBase64 = event.eventImageBase64
            )
            event.eventSubs.forEach {eventSub->
                dbQuery.insertEventSubs(eventId = event.eventId.toLong(),
                    eventSubId = eventSub.subId.toLong(),
                    eventSubName = eventSub.subName)
            }
        }
    }

    internal fun getEventsVersion(): Int {
        val versions = dbQuery.selectEventsVersions().executeAsList()
        return if(versions.isNotEmpty()){
            versions.first().toInt()
        } else{
            0
        }
    }

    internal fun updateEventsVersion(version: Int) {
        val versions = dbQuery.selectEventsVersions().executeAsList()
        if (versions.isNotEmpty()){
            dbQuery.clearAllEventsVersions()
            dbQuery.insertEventsVersions(version.toLong())
        }
        else{
            dbQuery.insertEventsVersions(version.toLong())
        }
    }

    internal fun getNews(): News {
        return Mapper.mapNews(dbQuery.selectNews().executeAsList())
    }

    internal fun clearAndSaveNews(news: News){
        dbQuery.clearAllNews()
        news.news.forEach {new->
            dbQuery.insertNews(
                newsId = new.newsId.toLong(),
                newsName = new.newsName,
                newsText = new.newsText,
                newsDate = new.newsDate,
                newsImageBase64 = new.newsImageBase64,
                newsLink = new.newsLink
            )
        }
    }

    internal fun getNewsVersion(): Int {
        val versions = dbQuery.selectNewsVersions().executeAsList()
        return if(versions.isNotEmpty()){
            versions.first().toInt()
        } else{
            0
        }
    }

    internal fun updateNewsVersion(version: Int) {
        val versions = dbQuery.selectNewsVersions().executeAsList()
        if (versions.isNotEmpty()){
            dbQuery.clearAllNewsVersions()
            dbQuery.insertNewsVersions(version.toLong())
        }
        else{
            dbQuery.insertNewsVersions(version.toLong())
        }
    }

    internal fun getBooks(): Books {
        val booksPr = dbQuery.selectBooksPr().executeAsList().first()
        val booksLocal = dbQuery.selectBooks().executeAsList()
        val booksList = ArrayList<Book>()
        booksLocal.forEach { book->
            val professionsList = ArrayList<ProfessionListItem>()
            dbQuery.selectBookProfessions().executeAsList().filter { it.bookId == book.bookId }.forEach {
                professionsList.add(ProfessionListItem(
                    professionId = it.professionId.toInt(),
                    professionName = it.professionName
                ))
            }
            booksList.add(Mapper.mapBook(
                book = book, professions = professionsList))
        }
        return Books(
            books = booksList,
            maxSalePercent = booksPr.maxSalePercent.toInt(),
            prText = booksPr.prText,
            subscribeMinCost = booksPr.subscribeMinCost.toInt(),
            subscribeText = booksPr.subscribeText,
            subscribeLink = booksPr.subscribeLink,
            errorMsg = ""
        )
    }

    internal fun clearAndSaveBooks(books: Books){
        dbQuery.clearAllBooks()
        dbQuery.clearAllBookPr()
        dbQuery.clearAllBookProfessions()
        dbQuery.insertBooksPr(
            bookPrId = 0L,
            maxSalePercent = books.maxSalePercent.toLong(),
            prText = books.prText,
            subscribeText = books.subscribeText,
            subscribeMinCost = books.subscribeMinCost.toLong(),
            subscribeLink = books.subscribeLink
        )
        books.books.forEach { book->
            val booksProfessions = book.professions
            dbQuery.insertBooks(
                bookId = book.bookId.toLong(),
                bookName = book.bookName,
                bookDescription = book.bookDescription,
                bookImageBase64 = book.bookImageBase64,
                bookRefLink = book.bookRefLink,
                bookCostWithoutSale = book.bookCostWithoutSale.toLong(),
                bookCostWithSale = book.bookCostWithSale.toLong()
            )
            booksProfessions.forEach { profession->
                dbQuery.insertBookProfessions(
                    bookId = book.bookId.toLong(),
                    professionId = profession.professionId.toLong(),
                    professionName = profession.professionName
                )
            }
        }
    }

    internal fun getBooksVersion(): Int {
        val versions = dbQuery.selectBooksVersions().executeAsList()
        return if(versions.isNotEmpty()){
            versions.first().toInt()
        } else{
            0
        }
    }

    internal fun updateBooksVersion(version: Int) {
        val versions = dbQuery.selectBooksVersions().executeAsList()
        if (versions.isNotEmpty()){
            dbQuery.clearAllBooksVersions()
            dbQuery.insertBooksVersions(version.toLong())
        }
        else{
            dbQuery.insertBooksVersions(version.toLong())
        }
    }

    internal fun getStudies(): Studies {
        val studiesPr = dbQuery.selectStudiesPr().executeAsList().first()
        val studiesLocal = dbQuery.selectStudies().executeAsList()
        val studiesList = ArrayList<Study>()
        studiesLocal.forEach { study->
            val professionsList = ArrayList<ProfessionListItem>()
            dbQuery.selectStudyProfessions().executeAsList().filter { it.studyId == study.studyId }.forEach {
                professionsList.add(ProfessionListItem(
                    professionId = it.professionId.toInt(),
                    professionName = it.professionName
                ))
            }
            studiesList.add(Mapper.mapStudy(
                study = study, professions = professionsList))
        }
        return Studies(
            studies = studiesList,
            prText = studiesPr.prText,
            errorMsg = ""
        )
    }

    internal fun clearAndSavStudies(studies: Studies){
        dbQuery.clearAllStudies()
        dbQuery.clearAllStudiesPR()
        dbQuery.clearAllStudyProfessions()
        dbQuery.insertStudiesPr(
            studiesPrId = 0L,
            prText = studies.prText
        )
        studies.studies.forEach { study->
            val studiesProfessions = study.professions
            dbQuery.insertStudy(
                studyId = study.studyId.toLong(),
                studyName = study.studyName,
                studyCost = study.studyCost.toLong(),
                studyImageBase64 = study.studyImageBase64,
                studyRefLink = study.studyRefLink,
                studySalePercent = study.studySalePercent.toLong(),
                studyLength = study.studyLength.toLong(),
                studyLengthType = study.studyLengthType.toLong(),
                studyOwner = study.studyOwner,
                studyAdditionalText = study.studyAdditionalText
            )
            studiesProfessions.forEach { profession->
                dbQuery.insertStudyProfessions(
                    professionId = profession.professionId.toLong(),
                    professionName = profession.professionName,
                    studyId = study.studyId.toLong()
                )
            }
        }
    }

    internal fun getOfflineAuthData(): List<OfflineAuthData> {
        val authList = ArrayList<OfflineAuthData>()
        dbQuery.selectAuthOfflineData().executeAsList().forEach { authData ->
            authList.add(Mapper.mapOfflineAuthData(authData))
        }
        return authList
    }

    internal fun addOfflineAuthData(authData: OfflineAuthData) {
        dbQuery.insertAuthOfflineData(timeStamp = authData.timeStamp)
    }

    internal fun clearOfflineAuthData() {
        dbQuery.clearAuthOfflineData()
    }



    internal fun getOfflineTestResults(): List<OfflineTestResult> {
        val testsList = ArrayList<OfflineTestResult>()
        dbQuery.selectOfflineTestResult().executeAsList().forEach { test ->
            testsList.add(Mapper.mapOfflineTestResult(test))
        }
        return testsList
    }

    internal fun addOfflineTestResult(testResult: OfflineTestResult) {
        dbQuery.insertOfflineTestResult(
            testId = testResult.testId.toLong(),
            testResult = testResult.testResult.toLong(),
            timeStamp = testResult.timeStamp)
    }

    internal fun clearOfflineTestResult() {
        dbQuery.clearOfflineTestResult()
    }

    internal fun getOfflineComments(): List<OfflineComment> {
        val commentsList = ArrayList<OfflineComment>()
        dbQuery.selectOfflineMaterialComment().executeAsList().forEach {comment ->
            commentsList.add(Mapper.mapOfflineComment(comment))
        }
        return commentsList
    }

    internal fun addOfflineComment(comment: OfflineComment) {
        dbQuery.insertOfflineComment(
            materialId = comment.materialId.toLong(),
            commentText = comment.commentText,
        )
    }

    internal fun clearOfflineComments() {
        dbQuery.clearOfflineComment()
    }
}