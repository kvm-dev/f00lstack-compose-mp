package ru.kvmsoft.features.language.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.language.imp.data.datasource.LocaleHelper

actual val languagePlatformModule = module {
    single<LocaleHelper> { LocaleHelper() }
}