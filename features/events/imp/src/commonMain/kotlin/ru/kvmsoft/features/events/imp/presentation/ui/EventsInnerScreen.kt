package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.theme.MainYellowLight
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.features.events.imp.presentation.viewmodel.EventsInnerScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EventsInnerScreen(viewModel: EventsInnerScreenViewModel = koinViewModel(), eventId: Int, onClickBack: ()->Unit) {

    val state by viewModel.collectAsState()

    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            EventsInnerScreenSideEffects.ON_BACK_PRESSED -> {
                onClickBack()
            }
        }
    }
    when (state) {
        EventsInnerScreenViewState.IdleState -> {
            viewModel.intentHandler(EventsInnerScreenIntents.InitViewModelIntent(eventId = eventId))
        }

        is EventsInnerScreenViewState.SuccessState -> {
            val successState = state as EventsInnerScreenViewState.SuccessState
            val eventImage = successState.event.eventImageBase64
            Column{
                Box{
                    if (eventImage.isNotEmpty()) {
                        if (eventImage.decodeBase64ToBitmap() != null) {
                            eventImage.decodeBase64ToBitmap()?.let {
                                Image(
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(264.dp),
                                    bitmap = it,
                                    contentDescription = successState.event.eventName
                                )
                            }
                        } else {
                            ShowNotFoundImageHorizontal(modifier = Modifier
                                .fillMaxWidth()
                                .height(264.dp))
                        }
                    } else {
                        ShowNotFoundImageHorizontal(modifier = Modifier
                            .fillMaxWidth()
                            .height(264.dp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(color = MainYellowLight)
                            .offset(y = 20.dp)
                    )
                }
            }
        }

        is EventsInnerScreenViewState.ErrorState -> {

        }
    }
}
