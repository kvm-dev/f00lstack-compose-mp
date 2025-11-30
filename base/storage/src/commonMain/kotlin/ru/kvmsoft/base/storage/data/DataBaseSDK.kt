package ru.kvmsoft.base.storage.data

import ru.kvmsoft.base.storage.data.local.LocalDataSource
import ru.kvmsoft.base.storage.model.Books
import ru.kvmsoft.base.storage.model.Events
import ru.kvmsoft.base.storage.model.Materials
import ru.kvmsoft.base.storage.model.News
import ru.kvmsoft.base.storage.model.OfflineAuthData
import ru.kvmsoft.base.storage.model.OfflineComment
import ru.kvmsoft.base.storage.model.OfflineTestResult
import ru.kvmsoft.base.storage.model.PassedTest
import ru.kvmsoft.base.storage.model.PassedTests
import ru.kvmsoft.base.storage.model.Professions
import ru.kvmsoft.base.storage.model.Profile
import ru.kvmsoft.base.storage.model.Studies
import ru.kvmsoft.base.storage.model.Tests

class DataBaseSDK(private val dataSource: LocalDataSource) {

    suspend fun getProfile(): Profile = dataSource.getProfile()
    suspend fun saveProfile(profile: Profile) = dataSource.clearAndSaveProfile(profile)

    suspend fun getMaterials(): Materials = dataSource.getMaterials()

    suspend fun saveMaterials(materials: Materials) = dataSource.clearAndSaveMaterials(materials)

    suspend fun getTests(): Tests = dataSource.getTests()

    suspend fun saveTests(tests:Tests) = dataSource.clearAndSaveTests(tests)

    suspend fun getPassedTests(): PassedTests = dataSource.getPassedTests()

    suspend fun savePassedTests(passedTests:PassedTests) = dataSource.clearAndSavePassedTests(passedTests)

    suspend fun savePassedTest(passedTest: PassedTest) = dataSource.addPassedTest(passedTest)

    suspend fun getEvents() =  dataSource.getEvents()

    suspend fun saveEvents(events: Events) = dataSource.clearAndSaveEvents(events)

    suspend fun getEventsVersion() =  dataSource.getEventsVersion()

    suspend fun updateEventsVersion(eventVersion: Int) = dataSource.updateEventsVersion(eventVersion)

    suspend fun getNews(): News = dataSource.getNews()

    suspend fun saveNews(news: News) =  dataSource.clearAndSaveNews(news)

    suspend fun getNewsVersion() =  dataSource.getNewsVersion()

    suspend fun updateNewsVersion(newsVersion: Int) = dataSource.updateNewsVersion(newsVersion)

    suspend fun getBooks() = dataSource.getBooks()

    suspend fun saveBooks(books: Books) = dataSource.clearAndSaveBooks(books)

    suspend fun getBooksVersion() =  dataSource.getBooksVersion()

    suspend fun updateBooksVersion(eventVersion: Int) = dataSource.updateBooksVersion(eventVersion)

    suspend fun getStudies() = dataSource.getStudies()

    suspend fun saveStudies(studies: Studies) = dataSource.clearAndSavStudies(studies)

    suspend fun getStudiesVersion() =  dataSource.getStudiesVersion()

    suspend fun updateStudiesVersion(studiesVersion: Int) = dataSource.updateStudiesVersion(studiesVersion)

    suspend fun getProfessions() = dataSource.getProfessions()

    suspend fun saveProfessions(professions: Professions) = dataSource.clearAndSaveProfessions(professions)

    suspend fun getCurrentProfession() = dataSource.getCurrentProfession()

    suspend fun updateCurrentProfession(professionId: Int) = dataSource.updateCurrentProfession(professionId)

    suspend fun clearProfileAndPassedTests() = dataSource.clearProfileAndPassedTests()

    suspend fun getOfflineAuthData() = dataSource.getOfflineAuthData()

    suspend fun saveOfflineAuthData(authData: OfflineAuthData) = dataSource.addOfflineAuthData(authData)

    suspend fun clearOfflineAuthData() = dataSource.clearOfflineAuthData()

    suspend fun getOfflineTestResults() = dataSource.getOfflineTestResults()

    suspend fun saveOfflineTestResult(testResult: OfflineTestResult) = dataSource.addOfflineTestResult(testResult)

    suspend fun clearOfflineTestResults() = dataSource.clearOfflineTestResult()

    suspend fun getOfflineComments() = dataSource.getOfflineComments()

    suspend fun saveOfflineComment(comment: OfflineComment) = dataSource.addOfflineComment(comment)

    suspend fun clearOfflineComments() = dataSource.clearOfflineComments()
}