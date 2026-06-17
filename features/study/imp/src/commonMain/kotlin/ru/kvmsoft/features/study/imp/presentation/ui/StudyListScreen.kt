package ru.kvmsoft.features.study.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.StudiesVerticalSlider
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.features.study.imp.mapper.Mapper
import ru.kvmsoft.features.study.imp.presentation.viewmodel.StudyListViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun StudyListScreen(viewModel: StudyListViewModel = koinViewModel(), onClickBack: () -> Unit) {

    val state by viewModel.collectAsState()

    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(1000)
            viewModel.intentHandler(StudyListScreenIntents.InitViewModelIntent)
            isRefreshing = false
        }
    }

    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            StudyListScreenSideEffects.OnClickBack -> {
                onClickBack()
            }
            StudyListScreenSideEffects.OpenChat -> {
                viewModel.openBrowserOrChat(isChat = true)
            }
            is StudyListScreenSideEffects.OpenWebPartnersLink -> {
                viewModel.openBrowserOrChat(url = sideEffect.url)
            }
            StudyListScreenSideEffects.CloseApp -> {
                closeApp()
            }
            StudyListScreenSideEffects.RefreshScreen -> {
                onRefresh()
            }
        }
    }
    when (state) {
        StudyListScreenViewState.LoadingState -> {
            isRefreshing = false
            StudiesVerticalSlider(
                modifier = Modifier,
                lang = viewModel.getLang(),
                studiesState = UiState.Loading,
                chips = listOf(),
                selectedChips = listOf(),
                onClickStudy = {},
                selectedChip = mutableStateOf(""),
                onclickChip = {},
                isRefreshing = isRefreshing,
                isConnectionAvailable = true,
                onRefresh = {},
                onClickBack = { viewModel.intentHandler(StudyListScreenIntents.OnClickBack) }
            )

            viewModel.intentHandler(StudyListScreenIntents.InitViewModelIntent)
        }
        is StudyListScreenViewState.ErrorState -> {
            val errorState = (state as StudyListScreenViewState.ErrorState)
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { viewModel.intentHandler(StudyListScreenIntents.CloseApplication) },
                actionSecond = { viewModel.intentHandler(StudyListScreenIntents.OpenChatIntent) },
                onDismiss = { viewModel.intentHandler(StudyListScreenIntents.CloseApplication) })
        }

        is StudyListScreenViewState.SuccessState -> {
            val successState = (state as StudyListScreenViewState.SuccessState)
            val selectedFilter = remember { mutableStateOf("") }
            isRefreshing = false
            StudiesVerticalSlider(
                modifier = Modifier,
                lang = successState.lang,
                studiesState = if(!successState.isAsModeEnabled) successState.studiesState else UiState.Empty,
                chips = Mapper.mapToChips(studiesState = successState.studiesState, isAsMode = successState.isAsModeEnabled),
                selectedChips = successState.selectedFilters,
                onClickStudy = {
                    viewModel.intentHandler(StudyListScreenIntents.NavigateToPartnersWebIntent(it))
                },
                selectedChip = selectedFilter,
                onclickChip = { viewModel.intentHandler(StudyListScreenIntents.UpdateFiltersIntent(selectedFilter.value)) },
                isRefreshing = isRefreshing,
                isConnectionAvailable = successState.isNetworkAvailable,
                onRefresh = { viewModel.intentHandler(StudyListScreenIntents.RefreshIntent) },
                onClickBack = { viewModel.intentHandler(StudyListScreenIntents.OnClickBack) }
            )
        }
    }
}

