package ru.kvmsoft.features.study.imp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.features.study.imp.presentation.viewmodel.StudyListViewModel

@Composable
fun StudyListScreen(viewModel: StudyListViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
//        when (sideEffect) {
//
//        }
    }
    when (state) {
        StudyListScreenViewState.LoadingState -> {

            viewModel.initViewModel()
        }
        is StudyListScreenViewState.ErrorState -> {

        }

        is StudyListScreenViewState.SuccessState -> {

        }
    }
}

