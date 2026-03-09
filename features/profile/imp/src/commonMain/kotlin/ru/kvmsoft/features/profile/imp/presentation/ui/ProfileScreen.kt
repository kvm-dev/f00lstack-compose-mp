package ru.kvmsoft.features.profile.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.profile.imp.presentation.viewmodel.ProfileScreenViewModel

@Composable
fun ProfileScreen(viewModel: ProfileScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        ProfileScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is ProfileScreenViewState.ErrorState -> {

        }

        is ProfileScreenViewState.SuccessState -> {

        }
    }
}


