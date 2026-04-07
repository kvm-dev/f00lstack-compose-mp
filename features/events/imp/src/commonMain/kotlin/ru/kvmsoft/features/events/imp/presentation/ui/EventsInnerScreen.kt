package ru.kvmsoft.features.events.imp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.kvmsoft.base.ui.background.baseBackground
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.MainGreenButton
import ru.kvmsoft.base.ui.components.ScreenHeader
import ru.kvmsoft.base.ui.components.ServiceSubLabel
import ru.kvmsoft.base.ui.components.ServiceTitle
import ru.kvmsoft.base.ui.components.ServiceTransparentLabel
import ru.kvmsoft.base.ui.components.TextArea
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.ui.res.strings.joinToEventButtonText
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.base.utils.closeApp
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
                Box(Modifier.fillMaxSize()){
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
                    Column(modifier = Modifier.padding(top = 64.dp)){
                        ScreenHeader(
                            modifier = Modifier,
                            text = "",
                            onBackClicked = onClickBack
                        )
                        Row(modifier = Modifier
                            .padding(top = 110.dp, start = 16.dp, end = 16.dp)){
                            ServiceSubLabel(text = successState.event.eventDateStart.timestampToDateString(), isYellow = false, modifier = Modifier)
                            ServiceTransparentLabel(successState.event.eventSubs.toString(), modifier = Modifier)
                        }
                        val background = rememberVectorPainter(image = baseBackground)
                        Spacer(modifier = Modifier.height(22.dp))
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))) {
                            Image(
                                painter = background,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .blur(radius = 16.dp)
                            )
                            Column {
                                ServiceTitle(
                                    text = successState.event.eventName,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 18.dp),
                                    textAlign = TextAlign.Center
                                )

                                TextArea(modifier = Modifier
                                    .weight(0.95f)
                                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                                    text = successState.event.eventDescription)
                                MainGreenButton(onClick = {
                                    viewModel.intentHandler(EventsInnerScreenIntents.JoinToEventIntent(successState.event.eventRefLink))
                                }, text = joinToEventButtonText(viewModel.currentLangState.value), modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp))
                            }
                        }
                    }
                }
        }

        is EventsInnerScreenViewState.ErrorState -> {
            val errorState = state as EventsInnerScreenViewState.ErrorState
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { closeApp() },
                actionSecond = { viewModel.intentHandler(EventsInnerScreenIntents.OpenChatIntent) },
                onDismiss = { closeApp() })
        }
    }
}
