package ru.kvmsoft.features.tests.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestsInnerScreenViewModel

@Composable
fun TestsInnerScreen(viewModel: TestsInnerScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        TestsInnerScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is TestsInnerScreenViewState.ErrorState -> {

        }

        is TestsInnerScreenViewState.SuccessState -> {

        }
    }
}

