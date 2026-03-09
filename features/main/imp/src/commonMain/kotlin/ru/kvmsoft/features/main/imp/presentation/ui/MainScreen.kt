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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
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
import ru.kvmsoft.base.utils.model.BaseErrors
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit, onclickEvents: ()->Unit, navController: NavController, eventDestination: String) {

    val state by viewModel.collectAsState()

    var isRefreshing by remember { mutableStateOf(false) }
    val pullToRefreshState = rememberPullToRefreshState()
    val scrollState = rememberScrollState()
    val eventId  = remember { mutableIntStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            // fetch something
            delay(2000)
            viewModel.intentHandler(MainScreenIntents.InitViewModelIntent)
            isRefreshing = false
        }
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            MainScreenSideEffects.NAVIGATE_TO_AUTHORIZATION_ZONE -> {
                viewModel.intentHandler(MainScreenIntents.GoToAuthorizationIntent)
                onNavigationAuthorization()
            }

            MainScreenSideEffects.NAVIGATE_TO_EVENT_INNER_SCREEN -> {
                val route = "$eventDestination/{eventId}"
                navController.navigate(
                    route.replace(
                        oldValue = "{eventId}",
                        newValue =  eventId.intValue.toString()
                    )
                )
            }
        }
    }

    when (state) {
        is MainScreenViewState.ErrorState -> {
            val error = (state as MainScreenViewState.ErrorState).error
            when(error){
                BaseErrors.UNAUTHORIZED-> viewModel.intentHandler(MainScreenIntents.GoToAuthorizationIntent)
                else-> {
                //todo something
                }
            }
        }
        MainScreenViewState.LoadingState -> {
            val lang = viewModel.currentLangState.value
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
            viewModel.intentHandler(MainScreenIntents.InitViewModelIntent)
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
                onRefresh = onRefresh) {
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
                        MainScreenSubNavigationBlock(onClickBooks = {}, onClickStudy = {}, onClickEvents = onclickEvents, lang = (successState.lang))
                    }
                }
            }
        }
    }
}



//fun MainScreen(viewModel: MainScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit, onclickEvents: ()->Unit, navController: NavController, eventDestination: String) {
//    val viewModelState by viewModel.progressState.collectAsState()
//    var isRefreshing by remember { mutableStateOf(false) }
//    val state = rememberPullToRefreshState()
//    val scrollState = rememberScrollState()
//    val scaleFraction = {
//        if (isRefreshing) 1f
//        else LinearOutSlowInEasing.transform(state.distanceFraction).coerceIn(0f, 1f)
//    }
//    val coroutineScope = rememberCoroutineScope()
//    val onRefresh: () -> Unit = {
//        isRefreshing = true
//        coroutineScope.launch {
//            // fetch something
//            delay(2000)
//            viewModel.refresh()
//            isRefreshing = false
//        }
//    }
//
//    when (viewModelState) {
//        ProgressState.IDLE -> {
//            viewModel.initViewModel()
//        }
//        ProgressState.LOADING -> {
//            val lang = viewModel.getCurrentLang()
//            isRefreshing = false
//            Column(modifier = Modifier
//                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
//            ) {
//                MainScreenHeader(
//                    onClickUser = {},
//                    onClickSettings = {},
//                    onClickConnectionNotFound = {},
//                    userIcon = "",
//                    userName = getLoadingText(lang),
//                    lang = viewModel.getCurrentLang(),
//                    isConnectionAvailable = true
//                )
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ) {
//                    StartTitle(getEventsMainScreenTitle(lang), modifier = Modifier
//                        .padding(top = 24.dp, bottom = 18.dp))
//
//                    MainScreenEventsSlider(
//                        sliderState = UiState.Loading,
//                        lang = CurrentLanguageDomain.EN,
//                        selectId = mutableStateOf(0),
//                        onClickEvent = {},
//                        isAsActive = false,
//                        isKnowHowToUseSlider = true,
//                        onSwipeEvent = { viewModel.updateEventsSliderHintState() }
//                    )
//                }
//            }
//            isRefreshing = false
//        }
//        ProgressState.COMPLETED -> {
//            isRefreshing = false
//            val eventId  = remember { mutableIntStateOf(0) }
//            val uiState by viewModel.uiState.collectAsState()
//            when(uiState){
//                is MainScreenViewState.ErrorState-> {
//
//                }
//                is MainScreenViewState.SuccessState-> {
//                    val successState = uiState as MainScreenViewState.SuccessState
//                    isRefreshing = false
//                    val isShowAchievementDialog  = remember { mutableStateOf(false) }
//                    val selectedAchievement  = remember { mutableIntStateOf(0) }
//                    PullToRefreshBox(
//                        modifier = Modifier
//                            .padding(top = 40.dp)
//                            .zIndex(1F),
//                        indicator = {
//                            Box(
//                                modifier = Modifier
//                                    .align(Alignment.TopCenter)
//                                    .graphicsLayer {
//                                        translationY = state.distanceFraction * 50.dp.toPx()
//                                        alpha = state.distanceFraction.coerceIn(0f, 1f)
//                                    }
//                                    .background(Color.Transparent, CircleShape)
//
//                                .padding(8.dp)
//                            ) {
//                                if (isRefreshing) {
//                                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
//                                } else {
//                                    LogoIcon(modifier = Modifier.size(48.dp).rotate(state.distanceFraction * 360f))
//                                }
//                            }
//                        },
//                        state = state,
//                        isRefreshing = isRefreshing,
//                        onRefresh = onRefresh) {
//                        Column(modifier = Modifier
//                        .fillMaxSize()
//                        .verticalScroll(scrollState)
//                        .padding(top = 20.dp, bottom = 48.dp)) {
//                        MainScreenHeader(
//                            onClickUser = {},
//                            onClickSettings = {},
//                            onClickConnectionNotFound = {},
//                            userIcon = "",
//                            userName = successState.userName,
//                            lang = CurrentLanguageDomain.EN,
//                            isConnectionAvailable = true
//                        )
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(16.dp)
//                        ) {
//                            StartTitle(getEventsMainScreenTitle(successState.lang), modifier = Modifier
//                                .padding(top = 24.dp, bottom = 18.dp))
//
//                            MainScreenEventsSlider(
//                                sliderState = successState.eventsState,
//                                lang = successState.lang,
//                                selectId = eventId,
//                                onClickEvent = {
//                                    viewModel.navigateToEvent(
//                                        navController = navController,
//                                        eventId = eventId.intValue,
//                                        eventDestination = eventDestination
//                                    )
//                                },
//                                isAsActive = successState.isAsModeEnabled,
//                                isKnowHowToUseSlider = successState.isKnowHowToUseSlider,
//                                onSwipeEvent = { viewModel.updateEventsSliderHintState() }
//                            )
//                            StartTitle(getAchievementsMainScreenTitle(successState.lang), modifier = Modifier
//                                .padding(top = 30.dp, bottom = 16.dp))
//                            MainScreenAchievementsSlider(
//                                lang = successState.lang,
//                                achievementsState = successState.achievements,
//                                selectId = selectedAchievement,
//                                isShowDialog = isShowAchievementDialog
//                            )
//                            MainScreenSubNavigationBlock(onClickBooks = {}, onClickStudy = {}, onClickEvents = onclickEvents, lang = (uiState as MainScreenViewState.SuccessState).lang)
//                        }
//                        }
//                    }
//                }
//            }
//        }
//        ProgressState.UNAUTHORIZED -> {
//            viewModel.goToAuthorize()
//            onNavigationAuthorization()
//        }
//    }
//}

