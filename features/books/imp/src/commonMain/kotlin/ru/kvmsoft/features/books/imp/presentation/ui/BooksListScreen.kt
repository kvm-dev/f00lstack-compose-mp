package ru.kvmsoft.features.books.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksListScreenViewModel

@Composable
fun BooksListScreen(viewModel: BooksListScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        BooksListScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is BooksListScreenViewState.ErrorState -> {

        }

        is BooksListScreenViewState.SuccessState -> {

        }
    }
}
