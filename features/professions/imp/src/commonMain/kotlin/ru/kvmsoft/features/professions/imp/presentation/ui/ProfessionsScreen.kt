package ru.kvmsoft.features.professions.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.professions.imp.presentation.viewmodel.ProfessionsScreenViewModel

@Composable
fun ProfessionsScreen(viewModel: ProfessionsScreenViewModel = koinViewModel()) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        ProfessionsScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is ProfessionsScreenViewState.ErrorState -> {

        }

        is ProfessionsScreenViewState.SuccessState -> {

        }
    }
}

