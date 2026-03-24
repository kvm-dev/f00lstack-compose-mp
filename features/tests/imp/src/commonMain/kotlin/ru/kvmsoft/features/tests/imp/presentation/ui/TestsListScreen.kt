package ru.kvmsoft.features.tests.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestsListScreenViewModel

@Composable
fun TestsListScreen(viewModel: TestsListScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        TestsListScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is TestsListScreenViewState.ErrorState -> {

        }

        is TestsListScreenViewState.SuccessState -> {

        }
    }
}

