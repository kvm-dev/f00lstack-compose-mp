package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.ui.components.EventsVerticalSlider
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.events.imp.mapper.Mapper
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsListScreenViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EventsListScreen(viewModel: EventsListScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit, navController: NavController, eventDestination: String, onClickBack: ()->Unit) {
    val viewModelState by viewModel.progressState.collectAsState()
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            // fetch something
            delay(2000)
            viewModel.refresh()
            isRefreshing = false
        }
    }

    BackHandler(enabled = true) {
        onClickBack()
    }

    when (viewModelState) {
        ProgressState.IDLE -> {
            isRefreshing = false
            EventsVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = false,
                lang = CurrentLanguageDomain.EN,
                eventsState = UiState.Loading,
                chips = listOf(),
                selectedChips = listOf(),
                onclickChip = { viewModel.updateFilters("") },
                onclickBackToHomeScreen = onClickBack,
                onClickEvent = {
                    viewModel.navigateToEvent(
                        navController = navController,
                        eventId = 0,
                        eventDestination = eventDestination
                    )
                },
                selectId = mutableStateOf(0),
                selectedChip = mutableStateOf(""),
                isRefreshing = isRefreshing,
                isConnectionAvailable = true,
                onRefresh = {}
            )
            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {
            EventsVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = false,
                lang = CurrentLanguageDomain.EN,
                eventsState = UiState.Loading,
                chips = listOf(),
                selectedChips = listOf(),
                onclickChip = { viewModel.updateFilters("") },
                onclickBackToHomeScreen = onClickBack,
                onClickEvent = {
                    viewModel.navigateToEvent(
                        navController = navController,
                        eventId = 0,
                        eventDestination = eventDestination
                    )
                },
                selectId = mutableStateOf(0),
                selectedChip = mutableStateOf(""),
                isRefreshing = isRefreshing,
                isConnectionAvailable = true,
                onRefresh = {}
            )
            isRefreshing = false
        }
        ProgressState.COMPLETED -> {
            val eventId  = remember { mutableIntStateOf(0) }
            val uiState by viewModel.uiState.collectAsState()
            when(uiState){
                is EventsListScreenViewState.LoadingState-> {
                    val state = (uiState as EventsListScreenViewState.LoadingState)
                    EventsVerticalSlider(
                        modifier = Modifier.fillMaxSize(),
                        isAsActive = false,
                        lang = state.lang,
                        eventsState = UiState.Loading,
                        chips = listOf(),
                        selectedChips = listOf(),
                        onclickChip = { viewModel.updateFilters("") },
                        onclickBackToHomeScreen = onClickBack,
                        onClickEvent = {
                            viewModel.navigateToEvent(
                                navController = navController,
                                eventId = eventId.intValue,
                                eventDestination = eventDestination
                            )
                        },
                        selectId = eventId,
                        selectedChip = mutableStateOf(""),
                        isRefreshing = isRefreshing,
                        isConnectionAvailable = true,
                        onRefresh = {}
                    )
                }
                is EventsListScreenViewState.ErrorState-> {

                }
                is EventsListScreenViewState.SuccessState-> {
                    val state = (uiState as EventsListScreenViewState.SuccessState)
                    val selectedFilter  = remember { mutableStateOf("") }
                    val eventId  = remember { mutableIntStateOf(0) }
                    isRefreshing = false
                    val isShowAchievementDialog  = remember { mutableStateOf(false) }
                        EventsVerticalSlider(
                            modifier = Modifier.fillMaxSize(),
                            isAsActive = state.isAsModeEnabled,
                            lang = state.lang,
                            eventsState = state.eventsState,
                            chips = Mapper.mapToChips(eventsState = state.eventsState, isAsMode = state.isAsModeEnabled),
                            selectedChips = state.selectedFilters,
                            onclickChip = { viewModel.updateFilters(selectedFilter.value) },
                            onclickBackToHomeScreen = onClickBack,
                            onClickEvent = {
                                viewModel.navigateToEvent(
                                    navController = navController,
                                    eventId = eventId.intValue,
                                    eventDestination = eventDestination
                                )
                            },
                            selectId = eventId,
                            selectedChip = selectedFilter,
                            isRefreshing = isRefreshing,
                            isConnectionAvailable = state.isNetworkAvailable,
                            onRefresh = {
                                onRefresh()
                            }
                        )
                }
            }
        }
        ProgressState.UNAUTHORIZED -> {
            viewModel.goToAuthorize()
            onNavigationAuthorization()
        }
    }
}