package ru.kvmsoft.features.splash.imp.presentation.res.strings

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

fun getSplashTitle() = "foolStack"

fun getSplashDescription(lang: CurrentLanguageDomain): String{
    return when(lang){
        CurrentLanguageDomain.RU -> "Поможем найти работу\nв сфере IT"
        CurrentLanguageDomain.EN -> "We'll help you \nfind a job in IT"

    }
}