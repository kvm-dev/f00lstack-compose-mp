package ru.kvmsoft.base.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations(val labelRus: String, val labelEng: String, val route: String){
    @Serializable
    class Splash: AppDestinations(labelRus = "Splash", labelEng = "Splash", route = "splash")
    @Serializable
    class Authorization: AppDestinations(labelRus = "Authorization", labelEng = "Authorization", route =  "authorization")
    @Serializable
    class Main: AppDestinations(labelRus = "Главная", labelEng = "Main", route =  "main")
    @Serializable
    class BooksList: AppDestinations(labelRus = "BooksList", labelEng = "BooksList", route = "booksList")
    @Serializable
    class BooksInner: AppDestinations(labelRus = "BooksInner", labelEng = "BooksInner", route = "booksInner")
    @Serializable
    class EventsList: AppDestinations(labelRus = "EventsList", labelEng = "EventsList", route = "eventsList")
    @Serializable
    class EventsInner: AppDestinations(labelRus = "EventsInner", labelEng = "EventsInner", route = "eventsInner")
    @Serializable
    class InterviewList: AppDestinations(labelRus = "Интервью", labelEng = "Interview", route = "interviewList")
    @Serializable
    class InterviewInner: AppDestinations(labelRus = "InterviewInner", labelEng = "InterviewInner", route = "interviewInner")
    @Serializable
    class NewsList: AppDestinations(labelRus = "Новости", labelEng = "News", route = "newsList")
    @Serializable
    class NewsInner: AppDestinations(labelRus = "NewsInner", labelEng = "NewsInner", route = "newsInner")
    @Serializable
    class Professions: AppDestinations(labelRus = "Professions", labelEng = "Professions", route = "professions")
    @Serializable
    class Profile: AppDestinations(labelRus = "Profile", labelEng = "Profile", route = "profile")
    @Serializable
    class Settings: AppDestinations(labelRus = "Settings", labelEng = "Settings", route = "settings")
    @Serializable
    class StudyList: AppDestinations(labelRus = "StudyList", labelEng = "StudyList", route = "studyList")
    @Serializable
    class TestsList: AppDestinations(labelRus = "Тесты", labelEng = "Tests", route = "testsList")
    @Serializable
    class TestsInner: AppDestinations(labelRus = "TestsInner", labelEng = "TestsInner", route = "testsInner")
}

fun getDestinationsList() = listOf(
    AppDestinations.Splash(),
    AppDestinations.Authorization(),
    AppDestinations.Main(),
    AppDestinations.BooksList(),
    AppDestinations.BooksInner(),
    AppDestinations.EventsList(),
    AppDestinations.EventsInner(),
    AppDestinations.InterviewList(),
    AppDestinations.InterviewInner(),
    AppDestinations.NewsList(),
    AppDestinations.NewsInner(),
    AppDestinations.Professions(),
    AppDestinations.Profile(),
    AppDestinations.Settings(),
    AppDestinations.StudyList(),
    AppDestinations.TestsList(),
    AppDestinations.TestsInner()
)