package ru.kvmsoft.features.main.imp.presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.ui.background.baseBackground
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel()) {
    val viewModelState by viewModel.progressState.collectAsState()
    when (viewModelState) {
        ProgressState.IDLE -> {

            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {}
        ProgressState.COMPLETED -> {}
    }
    Column() {

    }
}

