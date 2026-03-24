package ru.kvmsoft.features.books.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksInnerScreenViewModel

@Composable
fun BooksInnerScreen(viewModel: BooksInnerScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        BooksInnerScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is BooksInnerScreenViewState.ErrorState -> {

        }

        is BooksInnerScreenViewState.SuccessState -> {

        }
    }
}
