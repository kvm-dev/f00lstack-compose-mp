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

fun getUnknownErrorTitle(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Похоже, что-то сломалось..."
        CurrentLanguageDomain.EN -> "Something seems wrong..."
    }
}

fun getUnknownErrorDescription(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Пам пам парам парам пам пам...\n\nПопробуй перезапустить приложение или переустановить.\n\nПерезагрузи роутер (шутка) или напиши нам в чат"
        CurrentLanguageDomain.EN -> "Pam pam param param pam pam...\n\nTry restart or reinstall application.\n\nReboot your router (joke) or write to us in chat"
    }
}

fun getUnknownErrorMainButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Ок, закрыть приложение"
        CurrentLanguageDomain.EN -> "Ok, close app"
    }
}

fun getUnknownErrorSecondButton(lang: CurrentLanguageDomain): String {
    return when (lang) {
        CurrentLanguageDomain.RU -> "Схожу в чат"
        CurrentLanguageDomain.EN -> "Join to chat"
    }
}

//errorTexts
fun getErrorTextCodeIsAlreadySent() = "Code Is Already Sent"
fun getErrorTextUserIsUnconfirmed() = "User Is Unconfirmed"
fun getErrorTextUserIsNotFound() = "User Is Not Found"
fun getErrorTextUserIsAlreadyConfirmed() = "Email Is Not Found, Invalid Verification Code Or User Is Already Confirmed"
fun getErrorTextCodeIsIncorrect() = "Code Is Empty Or Incorrect"
fun getErrorTextCodeIsWrongOrExpired() = "Code Is Wrong Or Expired"
fun hardCreateUnknownError() = "Unknown"

//links
fun getChatLink() = "https://t.me/+r9DlqNi2Ymk0OGNi"

//other
fun getOkButton() = "Ok"



