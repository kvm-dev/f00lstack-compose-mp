package ru.kvmsoft.features.interview.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.interview.imp.presentation.viewmodel.InterviewInnerScreenViewModel

@Composable
fun InterviewInnerScreen(viewModel: InterviewInnerScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        InterviewInnerScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is InterviewInnerScreenViewState.ErrorState -> {

        }

        is InterviewInnerScreenViewState.SuccessState -> {

        }
    }
}
