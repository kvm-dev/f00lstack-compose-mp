package ru.kvmsoft.features.language.api.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

interface GetCurrentLanguageUseCase {

    val langState: StateFlow<ResultState<CurrentLanguageDomain>>
    fun getLang()
}