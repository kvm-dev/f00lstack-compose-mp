package ru.kvmsoft.base.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations(val labelRus: String, val labelEng: String, val route: String){
    @Serializable
    class Splash: AppDestinations(labelRus = "Splash", labelEng = "Splash", route = getRoute())
    {
        companion object{
            fun getRoute() = "splash"
        }
    }
    @Serializable
    class Authorization: AppDestinations(labelRus = "Authorization", labelEng = "Authorization", route =  getRoute())
    {
        companion object{
            fun getRoute() = "authorization"
        }
    }
    @Serializable
    class Main: AppDestinations(labelRus = "Главная", labelEng = "Main", route =  getRoute())
    {
        companion object{
            fun getRoute() = "main"
        }
    }
    @Serializable
    class BooksList: AppDestinations(labelRus = "BooksList", labelEng = "BooksList", route = getRoute())
    {
        companion object{
            fun getRoute() = "booksList"
        }
    }
    @Serializable
    class BooksInner: AppDestinations(labelRus = "BooksInner", labelEng = "BooksInner", route = getRoute())
    {
        companion object{
            fun getRoute() = "booksInner"
        }
    }
    @Serializable
    class EventsList: AppDestinations(labelRus = "EventsList", labelEng = "EventsList", route = getRoute())
    {
        companion object{
            fun getRoute() = "eventsList"
        }
    }
    @Serializable
    class EventsInner: AppDestinations(labelRus = "EventsInner", labelEng = "EventsInner", route = getRoute())
    {
        companion object{
            fun getRoute() = "eventsInner"
        }
    }
    @Serializable
    class InterviewList: AppDestinations(labelRus = "Интервью", labelEng = "Interview", route = getRoute())
    {
        companion object{
            fun getRoute() = "interviewList"
        }
    }
    @Serializable
    class InterviewInner: AppDestinations(labelRus = "InterviewInner", labelEng = "InterviewInner", route = getRoute())
    {
        companion object{
            fun getRoute() = "interviewInner"
        }
    }
    @Serializable
    class NewsList: AppDestinations(labelRus = "Новости", labelEng = "News", route = getRoute()){
        companion object{
            fun getRoute() = "newsList"
        }
    }
    @Serializable
    class NewsInner: AppDestinations(labelRus = "NewsInner", labelEng = "NewsInner", route = getRoute())
    {
        companion object{
            fun getRoute() = "newsInner"
        }
    }
    @Serializable
    class Professions: AppDestinations(labelRus = "Professions", labelEng = "Professions", route = getRoute())
    {
        companion object{
            fun getRoute() = "professions"
        }
    }
    @Serializable
    class Profile: AppDestinations(labelRus = "Profile", labelEng = "Profile", route = getRoute())
    {
        companion object{
            fun getRoute() = "profile"
        }
    }
    @Serializable
    class Settings: AppDestinations(labelRus = "Settings", labelEng = "Settings", route = getRoute())
    {
        companion object{
            fun getRoute() = "settings"
        }
    }
    @Serializable
    class StudyList: AppDestinations(labelRus = "StudyList", labelEng = "StudyList", route = getRoute())
    {
        companion object{
            fun getRoute() = "studyList"
        }
    }
    @Serializable
    class TestsList: AppDestinations(labelRus = "Тесты", labelEng = "Tests", route = getRoute())
    {
        companion object{
            fun getRoute() = "testsList"
        }
    }
    @Serializable
    class TestsInner: AppDestinations(labelRus = "TestsInner", labelEng = "TestsInner", route = getRoute())
    {
        companion object{
            fun getRoute() = "testsInner"
        }
    }
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