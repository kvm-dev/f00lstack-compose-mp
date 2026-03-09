package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsInnerScreenViewModel

@Composable
fun EventsInnerScreen(viewModel: EventsInnerScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        EventsInnerScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is EventsInnerScreenViewState.ErrorState -> {

        }

        is EventsInnerScreenViewState.SuccessState -> {

        }
    }
}
