package ru.kvmsoft.features.news.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.NewsVerticalSlider
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.utils.navigationScreens.AppDestinations
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsListScreenViewModel

@Composable
fun NewsListScreen(
    viewModel: NewsListScreenViewModel,
    navController: NavController,
    newsDestination: AppDestinations.NewsInner,
    modifier: Modifier
) {
    val state by viewModel.collectAsState()
    val newsId = remember { mutableIntStateOf(0) }
    var isRefreshing by remember { mutableStateOf(false) }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            NewsListScreenSideEffects.NAVIGATE_TO_NEWS_INNER_SCREEN -> {
                val route = newsDestination.copy(newsId = newsId.intValue)
                navController.navigate(route)
            }
            NewsListScreenSideEffects.REFRESH_SCREEN -> {
                isRefreshing = true
            }
            NewsListScreenSideEffects.CLOSE_APP -> {
                closeApp()
            }
            NewsListScreenSideEffects.OPEN_CHAT -> {
                viewModel.openChat()
            }
        }
    }

    when (state) {
        NewsListScreenViewState.LoadingState -> {
            NewsVerticalSlider(
                modifier = modifier,
                lang = viewModel.getLang(),
                newsState = UiState.Loading,
                onClickNews = {},
                selectId = remember { mutableStateOf(0) },
                isRefreshing = isRefreshing,
                onRefresh = {},
                isConnectionAvailable = true
            )
        }

        is NewsListScreenViewState.ErrorState -> {
            isRefreshing = false
            val errorState = (state as NewsListScreenViewState.ErrorState)
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { viewModel.intentHandler(NewsListScreenIntents.CloseApplication) },
                actionSecond = { viewModel.intentHandler(NewsListScreenIntents.OpenChatIntent) },
                onDismiss = { viewModel.intentHandler(NewsListScreenIntents.CloseApplication) }
            )
        }

        is NewsListScreenViewState.SuccessState -> {
            isRefreshing = false
            val successState = (state as NewsListScreenViewState.SuccessState)
            NewsVerticalSlider(
                modifier = modifier,
                lang = successState.lang,
                newsState = successState.newsState,
                onClickNews = { viewModel.intentHandler(NewsListScreenIntents.NavigateToNewsDetailsIntent) },
                selectId = newsId,
                isRefreshing = isRefreshing,
                isConnectionAvailable = successState.isNetworkAvailable,
                onRefresh = { viewModel.intentHandler(NewsListScreenIntents.RefreshIntent) }
            )
        }
    }
}