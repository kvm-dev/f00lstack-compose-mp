package ru.kvmsoft.features.authorization.imp.presentation.res.strings

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

fun getAppName() = "foolStack"
fun getAuthorizationPreviewTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Поможем найти работу"
        CurrentLanguageDomain.EN -> "We'll help you find a job"
    }
}

fun getAuthorizationPreviewDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Техническое собеседование или скрининг с HR?\n - Поможем подготовиться.\n\nНе хватает практики?\n - Проверь себя в тестовых заданиях,\nполучи обратную связь."
        CurrentLanguageDomain.EN -> "Technical interview or HR screening?\n- We'll help you prepare.\n\nLack practice?\n- Test yourself with test questions,\nget feedback."
    }
}

fun getAuthorizationEmailTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Электронная почта"
        CurrentLanguageDomain.EN -> "Email"
    }
}

fun getAuthorizationEmailDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Мы отправим на указанный адрес\nэлектронной почты письмо с кодом авторизации.\n\nЕсли у нас нет пользователя с\nтаким адресом электронной почты, мы тебя зарегистрируем."
        CurrentLanguageDomain.EN -> "We'll send an email with an authorization code\nto this email address.\n\nIf we don't have a user\nwith that email address, we'll register you."
    }
}

fun getAuthorizationEmailButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Войти"
        CurrentLanguageDomain.EN -> "Join"
    }
}

fun getAuthorizationOtpTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Подтверждение"
        CurrentLanguageDomain.EN -> "Confirmation"
    }
}

fun getAuthorizationOtpDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "На твой email отправлен код подтверждения.\n\nПроверь папку \"Спам\" и введи полученный код."
        CurrentLanguageDomain.EN -> "We'll send a verification code on your email.\n\nCheck \"Spam\" directory."
    }
}

fun getAuthorizationOtpMainButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Подтвердить"
        CurrentLanguageDomain.EN -> "Confirm"
    }
}

fun getAuthorizationOtpTryAgainButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Отправить код заново"
        CurrentLanguageDomain.EN -> "Send code again"
    }
}

fun getAuthorizationEmailPlaceholder() = "Email"

    fun getAuthorizationPreviewButton(lang: CurrentLanguageDomain): String {
        return when (lang) {
            CurrentLanguageDomain.RU -> "Войти в Айти"
            CurrentLanguageDomain.EN -> "Join to IT"
        }
    }

//errors
fun getAuthorizationErrorEmailIncorrect(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Некорректный адрес электронной почты"
        CurrentLanguageDomain.EN -> "Email is incorrect"
    }
}

fun getAuthorizationErrorEmailEmpty(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Поле Email не должно быть пустым"
        CurrentLanguageDomain.EN -> "The Email field is empty"
    }
}

fun getAuthorizationErrorEmailEmptyOrIncorrect(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Email пуст или указан некорректно"
        CurrentLanguageDomain.EN -> "The Email field is empty or incorrect"
    }
}

fun getAuthorizationErrorOtpAlreadySent(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Код подтверждения уже отправлен"
        CurrentLanguageDomain.EN -> "The confirm code is already sent"
    }
}

fun getAuthorizationErrorOtpCodeIsEmptyOrIncorrect(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Код подтверждения пуст или указан некорректно"
        CurrentLanguageDomain.EN -> "The confirm code is empty or incorrect"
    }
}

fun getAuthorizationErrorOtpCodeIsExpiredOrIncorrect(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Код подтверждения истек или указан некорректно"
        CurrentLanguageDomain.EN -> "The confirm code is expired or incorrect"
    }
}

fun getAuthorizationErrorUserNotFoundOrAlreadyConfirmedOrInvalidCode(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Код подтверждения указан неверно, пользователь подтвержден или не найден"
        CurrentLanguageDomain.EN -> "User not found or confirm code is incorrect or user already confirmed"
    }
}

fun getAuthorizationErrorUserIsAlreadyExist(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Пользователь уже зарегистрирован"
        CurrentLanguageDomain.EN -> "User is already registered"
    }
}

fun getAuthorizationErrorUserNotFound(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Пользователь не найден"
        CurrentLanguageDomain.EN -> "User not found"
    }
}

fun getAuthorizationErrorUserAreNotConfirmed(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Пользователь не подтвержден"
        CurrentLanguageDomain.EN -> "User are not confirmed"
    }
}

fun getAuthorizationErrorConnectionNotFoundTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Отсутствует соединение"
        CurrentLanguageDomain.EN -> "Connection is unavailable"
    }
}

fun getAuthorizationErrorConnectionNotFoundDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Проверь подключение к сети интернет и перезапусти приложение"
        CurrentLanguageDomain.EN -> "Check internet connection and restart application"
    }
}




