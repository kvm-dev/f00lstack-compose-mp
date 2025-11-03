package ru.kvmsoft.base.storage.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Profile(
    @SerialName("userId") val userId: Int,
    @SerialName("userName") val userName: String,
    @SerialName("userType") val userType: String,
    @SerialName("userStatus") val userStatus: Int,
    @SerialName("userEmail") val userEmail: String,
    @SerialName("userPhotoBase64") val userPhotoBase64: String,
    @SerialName("userAchievements") val userAchievements: List<UserAchievement>,
    @SerialName("userPurchasedProfessions") val userPurchasedProfessions: List<Int>
)
@kotlinx.serialization.Serializable
data class UserAchievement(
    @SerialName("achievementId") val achievementId: Int,
    @SerialName("userId") val userId: Int,
    @SerialName("achievementName") val achievementName: String,
    @SerialName("achievementDescription") val achievementDescription: String,
    @SerialName("achievementLevel") val achievementLevel: Int
)

@kotlinx.serialization.Serializable
data class Materials(
    @SerialName("materials") val materials: List<Material>,
)

@kotlinx.serialization.Serializable
data class Material(
    @SerialName("materialId") val materialId: Int,
    @SerialName("materialName") val materialName: String,
    @SerialName("materialText") val materialText: String,
    @SerialName("materialPriority") val materialPriority: Int,
    @SerialName("knowledgeAreas") val knowledgeAreas: List<KnowledgeArea>,
    @SerialName("subProfessions") val subProfessions: List<ProfessionListItem>
)

@kotlinx.serialization.Serializable
data class KnowledgeArea(
    @SerialName("areaId") val areaId: Int,
    @SerialName("areaName") val areaName: String
)

@kotlinx.serialization.Serializable
data class ProfessionListItem(
    @SerialName("professionId") val professionId: Int,
    @SerialName("professionName") val professionName: String
)

@kotlinx.serialization.Serializable
data class Tests(
    @SerialName("tests") val tests: List<Test>
)

@kotlinx.serialization.Serializable
data class Test(
    @SerialName("testId") val testId: Int,
    @SerialName("testName") val testName: String,
    @SerialName("testLevel") val testLevel: Int,
    @SerialName("testTimeLimit") val testTimeLimit: Int,
    @SerialName("questions") val questions: List<Question>,
    @SerialName("professions") val professions: List<ProfessionListItem>
)

@kotlinx.serialization.Serializable
data class Question(
    @SerialName("questionId") val questionId: Int,
    @SerialName("questionText") val questionText: String,
    @SerialName("variants") val variants: List<Variant>
)

@kotlinx.serialization.Serializable
data class Variant(
    @SerialName("variantId") val variantId: Int,
    @SerialName("variantText") val variantText: String,
    @SerialName("isRight") val isRight: Boolean
)

@kotlinx.serialization.Serializable
data class PassedTests(
    @SerialName("passedTests") val passedTests: List<PassedTest>
)

@kotlinx.serialization.Serializable
data class PassedTest(
    @SerialName("testId") val testId: Int,
    @SerialName("testResult") val testResult: Int,
    @SerialName("finishTestTime") val finishTestTime: Long
)

@kotlinx.serialization.Serializable
data class Events(
    @SerialName("events") val events: List<Event>,
    @SerialName("errorMsg") val errorMsg: String
)

@kotlinx.serialization.Serializable
data class Event(
    @SerialName("eventId") val eventId: Int,
    @SerialName("eventName") val eventName: String,
    @SerialName("eventDescription") val eventDescription: String,
    @SerialName("eventRefLink") val eventRefLink: String,
    @SerialName("eventDateStart") val eventDateStart: Long,
    @SerialName("eventCost") val eventCost: Int,
    @SerialName("eventImageBase64") val eventImageBase64: String,
    @SerialName("eventSubs") val eventSubs: List<EventSub>
)

@kotlinx.serialization.Serializable
data class EventSub(
    @SerialName("subId") val subId: Int,
    @SerialName("subName") val subName: String
)

@kotlinx.serialization.Serializable
data class News(
    @SerialName("news") val news: List<New>,
    @SerialName("errorMsg") val errorMsg: String
)

@kotlinx.serialization.Serializable
data class New(
    @SerialName("newsId") val newsId: Int,
    @SerialName("newsName") val newsName: String,
    @SerialName("newsText") val newsText: String,
    @SerialName("newsDate") val newsDate: Long,
    @SerialName("newsImageBase64") val newsImageBase64: String,
    @SerialName("newsLink") val newsLink: String
)

@kotlinx.serialization.Serializable
data class Books(
    @SerialName("books") val books: List<Book>,
    @SerialName("maxSalePercent") val maxSalePercent: Int,
    @SerialName("prText") val prText: String,
    @SerialName("subscribeText") val subscribeText: String,
    @SerialName("subscribeMinCost") val subscribeMinCost: Int,
    @SerialName("subscribeLink") val subscribeLink: String,
    @SerialName("errorMsg") val errorMsg: String
)

@kotlinx.serialization.Serializable
data class Book(
    @SerialName("bookId") val bookId: Int,
    @SerialName("bookName") val bookName: String,
    @SerialName("bookDescription") val bookDescription: String,
    @SerialName("bookImageBase64") val bookImageBase64: String,
    @SerialName("bookRefLink") val bookRefLink: String,
    @SerialName("bookCostWithSale") val bookCostWithSale: Int,
    @SerialName("bookCostWithoutSale") val bookCostWithoutSale: Int,
    @SerialName("professions") val professions: List<ProfessionListItem>
)

@kotlinx.serialization.Serializable
data class Professions(
    @SerialName("professions") var professions: List<Profession>,
    @SerialName("errorMsg") val errorMsg: String
)

@kotlinx.serialization.Serializable
data class Profession(
    @SerialName("professionId") val professionId: Int,
    @SerialName("professionName") val professionName: String,
    @SerialName("professionImageBase64") val professionImageBase64: String,
    @SerialName("professionType") val professionType: Int,
    @SerialName("professionParent") val professionParent: Int,
    @SerialName("professionPriority") val professionPriority: Int,
    @SerialName("subProfessions") var subProfessions: List<Profession> = listOf()
)

@kotlinx.serialization.Serializable
data class Studies(
    @SerialName("studies") val studies: List<Study>,
    @SerialName("prText") val prText: String,
    @SerialName("errorMsg") val errorMsg: String
)

@kotlinx.serialization.Serializable
data class Study(
    @SerialName("studyId") val studyId: Int,
    @SerialName("studyName") val studyName: String,
    @SerialName("studyCost") val studyCost: Int,
    @SerialName("studyImageBase64") val studyImageBase64: String,
    @SerialName("studyRefLink") val studyRefLink: String,
    @SerialName("studySalePercent") val studySalePercent: Int,
    @SerialName("studyLength") val studyLength: Int,
    @SerialName("studyLengthType") val studyLengthType: Int,
    @SerialName("professions") val professions: List<ProfessionListItem>,
    @SerialName("studyOwner") val studyOwner: String,
    @SerialName("studyAdditionalText")  val studyAdditionalText: String
)

@kotlinx.serialization.Serializable
data class OfflineComment(
    @SerialName("materialId") val materialId: Int,
    @SerialName("commentText") val commentText: String
)

@kotlinx.serialization.Serializable
data class OfflineTestResult(
    @SerialName("testId") val testId: Int,
    @SerialName("testResult") val testResult: Int,
    @SerialName("timeStamp") val timeStamp: Long
)

@kotlinx.serialization.Serializable
data class OfflineAuthData(
    @SerialName("timeStamp") val timeStamp: Long
)
