package ru.kvmsoft.base.storage.data.local

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
import ru.kvmsoft.base.utils.res.strings.getLocalDataBaseError

class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase.Companion(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getProfile(): Profile {
        try {
            val profile = dbQuery.selectProfile().executeAsOne()
            val achievements = dbQuery.selectAchievements().executeAsList()
            val purchasedProfessions = dbQuery.selectPurchasedProfessions().executeAsList()
            return Profile(
                userId = profile.userId.toInt(),
                userName = profile.userName,
                userType = profile.userType,
                userStatus = profile.userStatus.toInt(),
                userEmail = profile.userEmail,
                userAchievements = Mapper.mapAchievement(achievements),
                userPhotoBase64 = profile.userPhotoBase64,
                userPurchasedProfessions = Mapper.mapPurchasedProfessions(purchasedProfessions),
                errorMsg = ""
            )
        }
        catch (_: Exception) {
            return Profile(
                userName = "",
                userId = 0,
                userType = "client",
                userEmail = "",
                userStatus = 0,
                userAchievements = listOf(),
                userPurchasedProfessions = listOf(),
                userPhotoBase64 = "",
                errorMsg = getLocalDataBaseError()
            )
        }
    }

    internal fun clearAndSaveProfile(profile: Profile){
        try {
            dbQuery.clearAllProfiles()
            dbQuery.clearAllAchievements()
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
                dbQuery.insertAchievement(
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
        catch (e: Exception) {
            throw e
        }
    }

    internal fun clearProfileAndPassedTests(){
        try{
            dbQuery.clearAllProfiles()
            dbQuery.clearAllAchievements()
            dbQuery.clearAllPurchasedProfessions()
            dbQuery.clearAllPassedTests()
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getMaterials(): Materials {
        try {
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
                materials = materials,
                errorMsg = ""
            )
        }
        catch (_: Exception) {
            return Materials(
                materials = listOf(),
                errorMsg = getLocalDataBaseError()
            )
        }

    }

    internal fun clearAndSaveMaterials(materials: Materials){
        try {
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
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getTests(): Tests {
        try {
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
                tests = tests,
                errorMsg = ""
            )
        }
        catch (_: Exception) {
            return Tests(
                tests = listOf(),
                errorMsg = getLocalDataBaseError()
            )
        }
    }

    internal fun clearAndSaveTests(tests: Tests){
        try {
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
        catch (e: Exception) {
            throw e
        }

    }

    internal fun getPassedTests(): PassedTests {
        return try {
            Mapper.mapPassedTests(dbQuery.selectPassedTests().executeAsList())
        } catch (_: Exception) {
            Mapper.mapPassedTests(dbQuery.selectPassedTests().executeAsList(), withError = true)
        }
    }

    internal fun clearAndSavePassedTests(passedTests: PassedTests){
        try {
            dbQuery.clearAllPassedTests()
            passedTests.passedTests.forEach { passedTest->
                dbQuery.insertPassedTest(
                    testId = passedTest.testId.toLong(),
                    testResult = passedTest.testResult.toLong(),
                    finishTestTime = passedTest.finishTestTime
                )
            }
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun addPassedTest(passedTest: PassedTest){
        try {
            dbQuery.insertPassedTest(
                testId = passedTest.testId.toLong(),
                testResult = passedTest.testResult.toLong(),
                finishTestTime = passedTest.finishTestTime
            )
        }
        catch (e: Exception) {
            throw e
        }
    }


    internal fun getProfessions(): Professions {
        return try {
            Mapper.mapProfessions(dbQuery.selectProfessions().executeAsList())
        } catch (_: Exception) {
            Mapper.mapProfessions(dbQuery.selectProfessions().executeAsList(), withError = true)
        }
    }

    internal fun clearAndSaveProfessions(professions: Professions){
        try {
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
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getCurrentProfession(): Int {
        try {
            val profession = dbQuery.selectCurrentProfession().executeAsList()
            return if (profession.isNotEmpty()){
                profession.first().toInt()
            } else{
                0
            }
        }
        catch (_: Exception) {
          return 0
        }
    }

    internal fun updateCurrentProfession(professionId: Int) {
        try {
            val profession = dbQuery.selectCurrentProfession().executeAsList()
            if (profession.isNotEmpty()){
                dbQuery.clearCurrentProfession()
                dbQuery.insertCurrentProfession(professionId.toLong())
            }
            else{
                dbQuery.insertCurrentProfession(professionId.toLong())
            }
        }
        catch (e: Exception) {
            throw e
        }
    }



    internal fun getEvents(): Events {
        try {
            val events = dbQuery.selectEvents().executeAsList()
            val eventsSubs = dbQuery.selectAllEventSubs().executeAsList()

            return Mapper.mapEvents(events = events, eventsSubs = eventsSubs)
        }
        catch (_: Exception) {
            return Mapper.mapEvents(events = listOf(), eventsSubs = listOf(), withError = true)
        }
    }

    internal fun clearAndSaveEvents(events: Events){
        try {
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
        catch (e: Exception) {
            throw e
        }

    }

    internal fun getEventsVersion(): Int {
        try {
            val versions = dbQuery.selectEventsVersions().executeAsList()
            return if(versions.isNotEmpty()){
                versions.first().toInt()
            } else{
                0
            }
        }
        catch (_: Exception) {
            return 0
        }
    }

    internal fun updateEventsVersion(version: Int) {
        try {
            val versions = dbQuery.selectEventsVersions().executeAsList()
            if (versions.isNotEmpty()){
                dbQuery.clearAllEventsVersions()
                dbQuery.insertEventsVersions(version.toLong())
            }
            else{
                dbQuery.insertEventsVersions(version.toLong())
            }
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getNews(): News {
        return try {
            Mapper.mapNews(dbQuery.selectNews().executeAsList())
        } catch (_: Exception) {
            Mapper.mapNews(dbQuery.selectNews().executeAsList(), withError = true)
        }
    }

    internal fun clearAndSaveNews(news: News){
        try{
            dbQuery.clearAllNews()
            news.news.forEach { new->
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
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getNewsVersion(): Int {
        try {
            val versions = dbQuery.selectNewsVersions().executeAsList()
            return if(versions.isNotEmpty()){
                versions.first().toInt()
            } else{
                0
            }
        }
        catch (_: Exception) {
            return 0
        }
    }

    internal fun updateNewsVersion(version: Int) {
        try {
            val versions = dbQuery.selectNewsVersions().executeAsList()
            if (versions.isNotEmpty()){
                dbQuery.clearAllNewsVersions()
                dbQuery.insertNewsVersions(version.toLong())
            }
            else{
                dbQuery.insertNewsVersions(version.toLong())
            }
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getBooks(): Books {
        try {
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
        catch (_: Exception) {
            return Books(
                books = listOf(),
                maxSalePercent = 0,
                prText = "",
                subscribeMinCost = 0,
                subscribeText = "",
                subscribeLink = "",
                errorMsg = getLocalDataBaseError()
            )
        }
    }

    internal fun clearAndSaveBooks(books: Books){
        try {
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
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getBooksVersion(): Int {
        try {
            val versions = dbQuery.selectBooksVersions().executeAsList()
            return if(versions.isNotEmpty()){
                versions.first().toInt()
            } else{
                0
            }
        }
        catch (_: Exception) {
            return 0
        }
    }

    internal fun updateBooksVersion(version: Int) {
        try {
            val versions = dbQuery.selectBooksVersions().executeAsList()
            if (versions.isNotEmpty()){
                dbQuery.clearAllBooksVersions()
                dbQuery.insertBooksVersions(version.toLong())
            }
            else{
                dbQuery.insertBooksVersions(version.toLong())
            }
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getStudies(): Studies {
        try {
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
        catch (_: Exception) {
            return Studies(
                studies = listOf(),
                prText = "",
                errorMsg = getLocalDataBaseError()
            )
        }
    }

    internal fun clearAndSavStudies(studies: Studies){
        try {
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
        catch (e: Exception) {
         throw e
        }
    }

    internal fun getStudiesVersion(): Int {
        try {
            val versions = dbQuery.selectStudiesVersions().executeAsList()
            return if(versions.isNotEmpty()){
                versions.first().toInt()
            } else{
                0
            }
        }
        catch (_: Exception) {
            return 0
        }
    }

    internal fun updateStudiesVersion(version: Int) {
        try {
            val versions = dbQuery.selectStudiesVersions().executeAsList()
            if (versions.isNotEmpty()){
                dbQuery.clearAllStudiesVersions()
                dbQuery.insertStudiesVersions(version.toLong())
            }
            else{
                dbQuery.insertStudiesVersions(version.toLong())
            }
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun getOfflineAuthData(): List<OfflineAuthData> {
        val authList = ArrayList<OfflineAuthData>()
        try {
            dbQuery.selectAuthOfflineData().executeAsList().forEach { authData ->
                authList.add(Mapper.mapOfflineAuthData(authData))
            }
        }
        catch (_: Exception) { }
        return authList
    }

    internal fun addOfflineAuthData(authData: OfflineAuthData) {
        try {
            dbQuery.insertAuthOfflineData(timeStamp = authData.timeStamp)
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun clearOfflineAuthData() {
        try {
            dbQuery.clearAuthOfflineData()
        }
        catch (e: Exception) {
            throw e
        }
    }



    internal fun getOfflineTestResults(): List<OfflineTestResult> {
        val testsList = ArrayList<OfflineTestResult>()
        try {
            dbQuery.selectOfflineTestResult().executeAsList().forEach { test ->
                testsList.add(Mapper.mapOfflineTestResult(test))
            }
        }
        catch (_: Exception) { }
        return testsList
    }

    internal fun addOfflineTestResult(testResult: OfflineTestResult) {
        try {
            dbQuery.insertOfflineTestResult(
                testId = testResult.testId.toLong(),
                testResult = testResult.testResult.toLong(),
                finishTestTime = testResult.timeStamp)
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun clearOfflineTestResult() {
        try {
            dbQuery.clearOfflineTestResult()
        }
        catch (e: Exception){
            throw e
        }
    }

    internal fun getOfflineComments(): List<OfflineComment> {
        val commentsList = ArrayList<OfflineComment>()
        try {
            dbQuery.selectOfflineMaterialComment().executeAsList().forEach {comment ->
                commentsList.add(Mapper.mapOfflineComment(comment))
            }
        }
        catch (_: Exception) { }
        return commentsList
    }

    internal fun addOfflineComment(comment: OfflineComment) {
        try {
            dbQuery.insertOfflineComment(
                materialId = comment.materialId.toLong(),
                commentText = comment.commentText,
            )
        }
        catch (e: Exception) {
            throw e
        }
    }

    internal fun clearOfflineComments() {
        try {
            dbQuery.clearOfflineComment()
        }
        catch (e: Exception) {
            throw e
        }
    }
}