package ru.kvmsoft.base.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations(val label: String, val route: String){
    @Serializable
    class Splash: AppDestinations("Splash", "splash")
    @Serializable
    class Authorization: AppDestinations("Authorization", "authorization")
    @Serializable
    class Main: AppDestinations("Главная", "main")
    @Serializable
    class BooksList: AppDestinations("BooksList", "booksList")
    @Serializable
    class BooksInner: AppDestinations("BooksInner", "booksInner")
    @Serializable
    class EventsList: AppDestinations("EventsList", "eventsList")
    @Serializable
    class EventsInner: AppDestinations("EventsInner", "eventsInner")
    @Serializable
    class InterviewList: AppDestinations("Интервью", "interviewList")
    @Serializable
    class InterviewInner: AppDestinations("InterviewInner", "interviewInner")
    @Serializable
    class NewsList: AppDestinations("Новости", "newsList")
    @Serializable
    class NewsInner: AppDestinations("NewsInner", "newsInner")
    @Serializable
    class Professions: AppDestinations("Professions", "professions")
    @Serializable
    class Profile: AppDestinations("Profile", "profile")
    @Serializable
    class Settings: AppDestinations("Settings", "settings")
    @Serializable
    class StudyList: AppDestinations("StudyList", "studyList")
    @Serializable
    class TestsList: AppDestinations("Тесты", "testsList")
    @Serializable
    class TestsInner: AppDestinations("TestsInner", "testsInner")
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