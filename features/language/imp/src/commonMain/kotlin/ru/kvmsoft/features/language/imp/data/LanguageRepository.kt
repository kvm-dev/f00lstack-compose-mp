package ru.kvmsoft.features.language.imp.data

import ru.kvmsoft.features.language.imp.data.datasource.DataSource

class LanguageRepository(private val dataSource: DataSource) {

    fun getLanguage(): String {
        return dataSource.getLang()
    }
}