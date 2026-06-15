package ru.kvmsoft.features.study.imp.domain

import ru.kvmsoft.base.ui.model.StudiesItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getChatLink
import ru.kvmsoft.base.utils.BrowserUtils
import ru.kvmsoft.base.utils.errorsMsgHandler
import ru.kvmsoft.features.asmode.api.domain.usecase.GetAsModeUseCase
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.networkconnection.api.domain.usecase.GetNetworkStateUseCase
import ru.kvmsoft.features.study.api.domain.usecase.GetStudiesUseCase
import ru.kvmsoft.features.study.imp.mapper.Mapper.mapToStudiesItems
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreenViewState

class StudyListScreenInteractor(
    private val getStudiesUseCase: GetStudiesUseCase,
    private val networkStateUseCase: GetNetworkStateUseCase,
    private val getAsModeUseCase: GetAsModeUseCase,
    private val browserUtils: BrowserUtils,
    private val getCurrentLanguageUseCase: GetCurrentLanguageUseCase
) {
    val langState = getCurrentLanguageUseCase.langState

    fun getCurrentLang() = getCurrentLanguageUseCase.getLang()
    suspend fun isAsModeIsEnabled(isConnectionAvailable: Boolean) = getAsModeUseCase.isAsModeEnabled(isConnectionAvailable)

    private suspend fun getStudies(fromLocal: Boolean = false) = getStudiesUseCase.getStudies(fromLocal)

    suspend fun isNetworkAvailable()  = networkStateUseCase.isNetworkAvailable()

    suspend fun checkState(lang: CurrentLanguageDomain): StudyListScreenViewState{
        val connectionState = isNetworkAvailable()
        val isAsModeEnabled = isAsModeIsEnabled(connectionState).isAsModeActive
        if(isNetworkAvailable()){
            val studiesResult = getStudies()
            if(studiesResult.errorMsg.isEmpty()){
                val filtersList = HashSet<String>()
                studiesResult.studies.forEach { study->
                    study.professions.forEach { sub->
                        println("курс ${study.studyName} ${sub.professionName}")
                        filtersList.add(sub.professionName)
                    }
                }
                return StudyListScreenViewState.SuccessState(
                    isNetworkAvailable = true,
                    lang = lang,
                    studiesState = UiState.Success(data = StudiesItemState(studies = studiesResult.studies.mapToStudiesItems())),
                    isAsModeEnabled = isAsModeEnabled,
                    selectedFilters = filtersList.toList()
                )
            }
            else{
                return StudyListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(studiesResult.errorMsg))
            }
        }
        else{
            val studiesResult = getStudies(fromLocal = true)
            if(studiesResult.errorMsg.isEmpty()){
                val filtersList = HashSet<String>()
                studiesResult.studies.forEach { study->
                    study.professions.forEach { sub->
                        filtersList.add(sub.professionName)
                    }
                }
                return StudyListScreenViewState.SuccessState(
                    isNetworkAvailable = false,
                    lang = lang,
                    studiesState = UiState.Success(data = StudiesItemState(studies = studiesResult.studies.mapToStudiesItems())),
                    isAsModeEnabled = isAsModeEnabled,
                    selectedFilters = filtersList.toList()
                )
            }
            else{
                return StudyListScreenViewState.ErrorState(lang = lang, error = errorsMsgHandler(studiesResult.errorMsg))
            }
        }
    }

    fun openBrowserOrChat(isChat: Boolean = false, url: String = ""){
        if(isChat && url.isEmpty()){
            browserUtils.openInBrowser(getChatLink())
        }
        else{
            browserUtils.openInBrowser(url)
        }
    }
}