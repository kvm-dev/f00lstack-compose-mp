package ru.kvmsoft.features.language.imp.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.language.imp.data.LanguageRepository
import ru.kvmsoft.features.language.imp.mapper.Mapper

class GetCurrentLanguageUseCaseImp(private val repository: LanguageRepository):
    GetCurrentLanguageUseCase {

    private val _langState = MutableStateFlow<ResultState<CurrentLanguageDomain>>(
        ResultState.Idle
    )
    override val langState = _langState.asStateFlow()

    override fun getLang() {
        _langState.tryEmit(ResultState.Loading)
        val state = Mapper.mapStringToCurrentLanguage(repository.getLanguage())
        _langState.tryEmit(ResultState.Success(state))
    }
}