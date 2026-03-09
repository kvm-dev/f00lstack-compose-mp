package ru.kvmsoft.features.settings.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.settings.imp.presentation.viewmodel.SettingsScreenViewModel

@Composable
fun SettingsScreen(viewModel: SettingsScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        SettingsScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is SettingsScreenViewState.ErrorState -> {

        }

        is SettingsScreenViewState.SuccessState -> {

        }
    }
}

