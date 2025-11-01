package ru.kvmsoft.features.language.imp.data.datasource

class DataSource(private val helper: LocaleHelper) {
    fun getLang(): String {
        return helper.getCurrentLocale()
    }
}