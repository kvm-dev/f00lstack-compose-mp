package ru.kvmsoft.features.main.imp.presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.ui.background.baseBackground
import ru.kvmsoft.base.ui.components.MainScreenHeader
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel(), onNavigationAuthorization: ()->Unit) {
    val viewModelState by viewModel.progressState.collectAsState()
    when (viewModelState) {
        ProgressState.IDLE -> {

            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {}
        ProgressState.COMPLETED -> {}
        ProgressState.UNAUTHORIZED -> {
            viewModel.goToAuthorize()
            onNavigationAuthorization()
        }
    }
    Column(modifier = Modifier
        .padding(top = 50.dp, start = 24.dp, end = 24.dp)) {
        MainScreenHeader(
            onClickUser = {},
            onClickSettings = {},
            onClickConnectionNotFound = {},
            userIcon = "",
            userName = "UserName",
            lang = CurrentLanguageDomain.EN,
            isConnectionAvailable = true
        )
    }
}

