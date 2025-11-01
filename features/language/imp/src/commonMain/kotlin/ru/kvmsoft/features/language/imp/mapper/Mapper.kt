package ru.kvmsoft.features.language.imp.mapper

import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

object Mapper {

    fun mapStringToCurrentLanguage(local: String): CurrentLanguageDomain {
        return if(local.lowercase().contains("ru")){
            CurrentLanguageDomain.RU
        }else{
            CurrentLanguageDomain.EN
        }
    }
}