package ru.kvmsoft.base.viewmodel.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.base.viewmodel.BaseViewModel

val baseViewModelModule = module {
    viewModelOf(::BaseViewModel)
}