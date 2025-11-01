package ru.kvmsoft.base.ui.res.strings

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

//errors
fun getErrorEndpointNotFound(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "На сервере произошла ошибка, зайди попозже"
        CurrentLanguageDomain.EN -> "Internal server error, try again later"
    }
}

fun getErrorConnectionNotFoundTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Отсутствует соединение"
        CurrentLanguageDomain.EN -> "Connection is unavailable"
    }
}

fun getErrorConnectionNotFoundDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Проверьте подключение к сети интернет и повторите попытку"
        CurrentLanguageDomain.EN -> "Check your internet connection and try again later"
    }
}

//information
fun getConnectionNotFoundOfflineDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Приложение работает в оффлайн режиме"
        CurrentLanguageDomain.EN -> "Application work in offline mode"
    }
}

fun getUpdateDialogTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "У нас вышло обновление"
        CurrentLanguageDomain.EN -> "We have released an update"
    }
}

fun getUpdateDialogDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Обнови приложение и оцени новые возможности"
        CurrentLanguageDomain.EN -> "Update app and check new features"
    }
}

fun getUpdateDialogMainButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Обновить приложение"
        CurrentLanguageDomain.EN -> "Update"
    }
}

fun getUpdateDialogSecondaryButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Не хочу обновлять"
        CurrentLanguageDomain.EN -> "I don't want to update"
    }
}

fun getBackButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Назад"
        CurrentLanguageDomain.EN -> "Go back"
    }
}

fun getExitDialogTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Ты точно хочешь уйти?"
        CurrentLanguageDomain.EN -> "Do you really want to leave?"
    }
}

fun getExitDialogYesButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Да, хочу уйти"
        CurrentLanguageDomain.EN -> "Yeah, i want to leave"
    }
}

fun getExitDialogNoButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Нет, пока останусь"
        CurrentLanguageDomain.EN -> "Nope, I'll stay for now"
    }
}

fun getOkButton() = "Ok"




