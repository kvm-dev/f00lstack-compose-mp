package ru.kvmsoft.features.news.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsListScreenViewModel

@Composable
fun NewsListScreen(viewModel: NewsListScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        NewsListScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is NewsListScreenViewState.ErrorState -> {

        }

        is NewsListScreenViewState.SuccessState -> {

        }
    }
}

