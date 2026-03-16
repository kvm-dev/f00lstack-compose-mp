package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
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
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.components.EventsVerticalSlider
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.utils.navigationScreens.AppDestinations
import ru.kvmsoft.features.events.imp.mapper.Mapper
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsListScreenViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EventsListScreen(viewModel: EventsListScreenViewModel = koinViewModel(), navController: NavController, eventDestination: AppDestinations.EventsInner, onClickBack: () -> Unit) {
    val state by viewModel.collectAsState()

    val eventId = remember { mutableIntStateOf(0) }
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(2000)
            viewModel.intentHandler(EventsListScreenIntents.InitViewModelIntent)
            isRefreshing = false
        }
    }

    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            EventsListScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN -> {
                val route = eventDestination.copy(eventId = eventId.intValue)
                navController.navigate(route)
            }
        }
    }

    when (state) {
        EventsListScreenViewState.LoadingState -> {
            isRefreshing = false
            EventsVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = false,
                lang = CurrentLanguageDomain.EN,
                eventsState = UiState.Loading,
                chips = listOf(),
                selectedChips = listOf(),
                onclickChip = {
                    viewModel.intentHandler(
                        EventsListScreenIntents.UpdateFiltersIntent(
                            ""
                        )
                    )
                },
                onclickBackToHomeScreen = onClickBack,
                onClickEvent = {
                    viewModel.intentHandler(EventsListScreenIntents.NavigateToEventDetailsIntent)
                },
                selectId = mutableStateOf(0),
                selectedChip = mutableStateOf(""),
                isRefreshing = isRefreshing,
                isConnectionAvailable = true,
                onRefresh = {}
            )
            viewModel.intentHandler(EventsListScreenIntents.InitViewModelIntent)
        }

        is EventsListScreenViewState.SuccessState -> {
            val state = (state as EventsListScreenViewState.SuccessState)
            val selectedFilter = remember { mutableStateOf("") }
            isRefreshing = false
            val isShowAchievementDialog = remember { mutableStateOf(false) }
            EventsVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = state.isAsModeEnabled,
                lang = state.lang,
                eventsState = state.eventsState,
                chips = Mapper.mapToChips(
                    eventsState = state.eventsState,
                    isAsMode = state.isAsModeEnabled
                ),
                selectedChips = state.selectedFilters,
                onclickChip = { viewModel.intentHandler(EventsListScreenIntents.UpdateFiltersIntent(selectedFilter.value)) },
                onclickBackToHomeScreen = onClickBack,
                onClickEvent = {
                    viewModel.intentHandler(EventsListScreenIntents.NavigateToEventDetailsIntent)
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