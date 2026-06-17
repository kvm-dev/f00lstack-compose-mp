package ru.kvmsoft.features.books.imp.presentation.ui

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
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.BooksVerticalSlider
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.utils.navigationScreens.AppDestinations
import ru.kvmsoft.features.books.imp.mapper.Mapper
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksListScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BooksListScreen(viewModel: BooksListScreenViewModel = koinViewModel(), navController: NavController, bookDestination: AppDestinations.BooksInner, onClickBack: () -> Unit) {
    val state by viewModel.collectAsState()

    val bookId = remember { mutableIntStateOf(0) }
    val currentBookLink = remember { mutableStateOf("") }
    val subscribeLink = remember { mutableStateOf("") }
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(1000)
            viewModel.intentHandler(BooksListScreenIntents.InitViewModelIntent)
            isRefreshing = false
        }
    }

    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            BooksListScreenSideEffects.NAVIGATE_TO_BOOK_INNER_SCREEN -> {
                val route = bookDestination.copy(bookId = bookId.intValue)
                navController.navigate(route)
            }
            BooksListScreenSideEffects.REFRESH_SCREEN -> {
                onRefresh()
            }
            BooksListScreenSideEffects.ON_CLICK_BACK -> {
                onClickBack()
            }
            BooksListScreenSideEffects.CLOSE_APP -> {
                closeApp()
            }
            BooksListScreenSideEffects.OPEN_CHAT -> {
                viewModel.openUrlOrChat(isChat = true)
            }
            BooksListScreenSideEffects.SUBSCRIBE -> {
                viewModel.openUrlOrChat(url = subscribeLink.value)
            }
            BooksListScreenSideEffects.BUY_BOOK -> {
                viewModel.openUrlOrChat(url = currentBookLink.value)
            }
        }
    }

    when (state) {
        BooksListScreenViewState.LoadingState -> {
            isRefreshing = false
            BooksVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = false,
                lang = viewModel.getLang(),
                booksState = UiState.Loading,
                chips = listOf(),
                selectedChips = listOf(),
                onclickChip = {
                    viewModel.intentHandler(
                        BooksListScreenIntents.UpdateFiltersIntent(
                            ""
                        )
                    )
                },
                onClickBack = {
                    viewModel.intentHandler(BooksListScreenIntents.OnClickBack)
                },
                onClickBook = {
                    viewModel.intentHandler(BooksListScreenIntents.NavigateToBookDetailsIntent)
                },
                selectId = mutableStateOf(0),
                currentBookLink = mutableStateOf(""),
                selectedChip = mutableStateOf(""),
                isRefreshing = isRefreshing,
                isConnectionAvailable = true,
                onRefresh = {},
                subscribeText = "",
                subscribeClick = {},
                searchKeyWord = mutableStateOf(""),
                buyBook = {}
            )
            viewModel.intentHandler(BooksListScreenIntents.InitViewModelIntent)
        }

        is BooksListScreenViewState.SuccessState -> {
            val successState = (state as BooksListScreenViewState.SuccessState)
            val selectedFilter = remember { mutableStateOf("") }
            val searchKeyword = remember { mutableStateOf("") }
            subscribeLink.value = successState.subscribeUrl
            isRefreshing = false
            BooksVerticalSlider(
                modifier = Modifier.fillMaxSize(),
                isAsActive = successState.isAsModeEnabled,
                lang = successState.lang,
                booksState = successState.booksState,
                chips = Mapper.mapToChips(
                    booksState = successState.booksState),
                selectedChips = successState.selectedFilters,
                onclickChip = { viewModel.intentHandler(BooksListScreenIntents.UpdateFiltersIntent(selectedFilter.value)) },
                onClickBack = { viewModel.intentHandler(BooksListScreenIntents.OnClickBack) },
                onClickBook = {
                    viewModel.intentHandler(BooksListScreenIntents.NavigateToBookDetailsIntent)
                },
                searchKeyWord = searchKeyword,
                selectId = bookId,
                currentBookLink = currentBookLink,
                selectedChip = selectedFilter,
                isRefreshing = isRefreshing,
                isConnectionAvailable = successState.isNetworkAvailable,
                onRefresh = {
                    viewModel.intentHandler(BooksListScreenIntents.RefreshIntent)
                },
                subscribeText = successState.subscribeText,
                subscribeClick = { viewModel.intentHandler(BooksListScreenIntents.SubscribeIntent(successState.subscribeUrl)) },
                buyBook = { viewModel.intentHandler(BooksListScreenIntents.BuyBookIntent) }
            )
        }

        is BooksListScreenViewState.ErrorState -> {
            val errorState = (state as BooksListScreenViewState.ErrorState)
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { viewModel.intentHandler(BooksListScreenIntents.CloseApplication) },
                actionSecond = { viewModel.intentHandler(BooksListScreenIntents.OpenChatIntent) },
                onDismiss =  { viewModel.intentHandler(BooksListScreenIntents.CloseApplication) })
        }
    }
}