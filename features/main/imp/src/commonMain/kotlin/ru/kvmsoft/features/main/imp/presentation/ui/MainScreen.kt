package ru.kvmsoft.features.main.imp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.ExitBottomSheet
import ru.kvmsoft.base.ui.components.MainScreenAchievementsSlider
import ru.kvmsoft.base.ui.components.MainScreenEventsSlider
import ru.kvmsoft.base.ui.components.MainScreenHeader
import ru.kvmsoft.base.ui.components.MainScreenSubNavigationBlock
import ru.kvmsoft.base.ui.components.StartTitle
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getAchievementsMainScreenTitle
import ru.kvmsoft.base.ui.res.strings.getEventsMainScreenTitle
import ru.kvmsoft.base.ui.res.strings.getLoadingText
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.base.utils.navigationScreens.AppDestinations
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel, onNavigationAuthorization: ()->Unit, onClickEvents: ()->Unit, onClickBooks: ()->Unit, onClickStudy: ()->Unit,  navController: NavController, eventDestination: AppDestinations.EventsInner) {

    val state by viewModel.collectAsState()

    var showExitBottomSheet by remember { mutableStateOf(false) }

    BackHandler(enabled = true) {
        showExitBottomSheet = true
    }

    var isRefreshing by remember { mutableStateOf(false) }
    val pullToRefreshState = rememberPullToRefreshState()
    val scrollState = rememberScrollState()
    val eventId  = remember { mutableIntStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(1000)
            isRefreshing = false
        }
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            MainScreenSideEffects.NAVIGATE_TO_AUTHORIZATION_ZONE -> {
                onNavigationAuthorization()
            }
            MainScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN -> {
                navController.navigate(eventDestination.copy(eventId = eventId.intValue))
            }
            MainScreenSideEffects.NAVIGATE_TO_EVENTS_LIST_SCREEN -> {
                onClickEvents()
            }
            MainScreenSideEffects.NAVIGATE_TO_BOOKS_LIST_SCREEN -> {
                onClickBooks()
            }
            MainScreenSideEffects.NAVIGATE_TO_STUDY_LIST_SCREEN -> {
                onClickStudy()
            }
            MainScreenSideEffects.REFRESH_SCREEN -> {
                onRefresh()
            }
            MainScreenSideEffects.CLOSE_APP -> {
                closeApp()
            }
            MainScreenSideEffects.OPEN_CHAT -> {
                viewModel.openChat()
            }
        }
    }

    when (state) {
        is MainScreenViewState.ErrorState -> {
            when((state as MainScreenViewState.ErrorState).error){
                BaseErrors.UNAUTHORIZED-> viewModel.intentHandler(MainScreenIntents.GoToAuthorizationIntent)
                else-> {
                    BaseErrorBottomSheet(
                        title = getUnknownErrorTitle(lang = viewModel.getLang()),
                        description = getUnknownErrorDescription(lang = viewModel.getLang()),
                        mainButtonText = getUnknownErrorMainButton(lang = viewModel.getLang()),
                        secondButtonText = getUnknownErrorSecondButton(lang = viewModel.getLang()),
                        actionMain = { viewModel.intentHandler(MainScreenIntents.CloseApplication) },
                        actionSecond = { viewModel.intentHandler(MainScreenIntents.OpenChatIntent) },
                        onDismiss = { viewModel.intentHandler(MainScreenIntents.CloseApplication) })
                }
            }
        }
        MainScreenViewState.LoadingState -> {
            val lang = viewModel.getLang()
            isRefreshing = false
            Column(modifier = Modifier
                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
            ) {
                MainScreenHeader(
                    onClickUser = {},
                    onClickSettings = {},
                    onClickConnectionNotFound = {},
                    userIcon = "",
                    userName = getLoadingText(lang),
                    lang = lang,
                    isConnectionAvailable = true
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    StartTitle(getEventsMainScreenTitle(lang), modifier = Modifier
                        .padding(top = 24.dp, bottom = 18.dp))

                    MainScreenEventsSlider(
                        sliderState = UiState.Loading,
                        lang = CurrentLanguageDomain.EN,
                        selectId = mutableStateOf(0),
                        onClickEvent = {},
                        isAsActive = false,
                        isKnowHowToUseSlider = true,
                        onSwipeEvent = { viewModel.intentHandler(MainScreenIntents.UpdateEventsSliderHintStateIntent) }
                    )
                }
            }
            isRefreshing = false
            if (showExitBottomSheet) {
                ExitBottomSheet(
                    lang = viewModel.getLang(), onDismissRequest = {
                        showExitBottomSheet = false
                    })
            }
        }
        is MainScreenViewState.SuccessState-> {
            val successState = state as MainScreenViewState.SuccessState
            isRefreshing = false
            val isShowAchievementDialog  = remember { mutableStateOf(false) }
            val selectedAchievement  = remember { mutableIntStateOf(0) }
            PullToRefreshBox(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .zIndex(1F),
                indicator = {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .graphicsLayer {
                                translationY = pullToRefreshState.distanceFraction * 50.dp.toPx()
                                alpha = pullToRefreshState.distanceFraction.coerceIn(0f, 1f)
                            }
                            .background(Color.Transparent, CircleShape)

                            .padding(8.dp)
                    ) {
                        if (isRefreshing) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        } else {
                            LogoIcon(modifier = Modifier.size(48.dp).rotate(pullToRefreshState.distanceFraction * 360f))
                        }
                    }
                },
                state = pullToRefreshState,
                isRefreshing = isRefreshing,
                onRefresh = { viewModel.intentHandler(MainScreenIntents.RefreshIntent)  }) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(top = 20.dp, bottom = 48.dp)) {
                    MainScreenHeader(
                        onClickUser = {},
                        onClickSettings = {},
                        onClickConnectionNotFound = {},
                        userIcon = "",
                        userName = successState.userName,
                        lang = CurrentLanguageDomain.EN,
                        isConnectionAvailable = true
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        StartTitle(getEventsMainScreenTitle(successState.lang), modifier = Modifier
                            .padding(top = 24.dp, bottom = 18.dp))

                        MainScreenEventsSlider(
                            sliderState = successState.eventsState,
                            lang = successState.lang,
                            selectId = eventId,
                            onClickEvent = {
                                viewModel.intentHandler(MainScreenIntents.NavigateToEventDetailsIntent)
                            },
                            isAsActive = successState.isAsModeEnabled,
                            isKnowHowToUseSlider = successState.isKnowHowToUseSlider,
                            onSwipeEvent = { viewModel.intentHandler(MainScreenIntents.UpdateEventsSliderHintStateIntent) }
                        )
                        StartTitle(getAchievementsMainScreenTitle(successState.lang), modifier = Modifier
                            .padding(top = 30.dp, bottom = 16.dp))
                        MainScreenAchievementsSlider(
                            lang = successState.lang,
                            achievementsState = successState.achievements,
                            selectId = selectedAchievement,
                            isShowDialog = isShowAchievementDialog
                        )
                        MainScreenSubNavigationBlock(
                            onClickBooks = { viewModel.intentHandler(MainScreenIntents.NavigateToBooksList) },
                            onClickStudy = { viewModel.intentHandler(MainScreenIntents.NavigateToStudyList) },
                            onClickEvents = { viewModel.intentHandler(MainScreenIntents.NavigateToEventsList) },
                            lang = (successState.lang))
                    }
                }
            }
            if (showExitBottomSheet) {
                ExitBottomSheet(
                    lang = successState.lang, onDismissRequest = {
                        showExitBottomSheet = false
                    }
                )
            }
        }
    }
}

