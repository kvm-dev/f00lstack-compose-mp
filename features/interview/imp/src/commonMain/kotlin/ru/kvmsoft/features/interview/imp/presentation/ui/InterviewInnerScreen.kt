package ru.kvmsoft.features.interview.imp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.interview.imp.presentation.viewmodel.InterviewInnerScreenViewModel

@Composable
fun InterviewInnerScreen(viewModel: InterviewInnerScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {
    val viewModelState by viewModel.progressState.collectAsState()
    when (viewModelState) {
        ProgressState.IDLE -> {

            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {}
        ProgressState.COMPLETED -> {}
        ProgressState.UNAUTHORIZED -> {
            onNavigationAuthorization()
        }
    }

    Column {

    }
}

