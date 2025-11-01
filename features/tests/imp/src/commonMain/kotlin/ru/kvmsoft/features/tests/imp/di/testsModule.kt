package ru.kvmsoft.features.tests.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.tests.imp.domain.TestInnerScreenInteractor
import ru.kvmsoft.features.tests.imp.domain.TestsListScreenInteractor
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestInnerScreenViewModel
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestsListScreenViewModel

val testsModule = module {
    single<TestsListScreenInteractor> { TestsListScreenInteractor() }
    single<TestInnerScreenInteractor> { TestInnerScreenInteractor() }
    viewModelOf(::TestsListScreenViewModel)
    viewModelOf(::TestInnerScreenViewModel)
}