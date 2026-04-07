package ru.kvmsoft.features.news.imp.presentation.ui

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
import androidx.compose.ui.Alignment
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
import ru.kvmsoft.base.ui.components.ScreenHeader
import ru.kvmsoft.base.ui.components.ServiceSubLabel
import ru.kvmsoft.base.ui.components.ServiceTitle
import ru.kvmsoft.base.ui.components.ShareButton
import ru.kvmsoft.base.ui.components.TextArea
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsInnerScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NewsInnerScreen(viewModel: NewsInnerScreenViewModel = koinViewModel(), newsId: Int, onClickBack: ()->Unit) {

    val state by viewModel.collectAsState()


    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            NewsInnerScreenSideEffects.ON_BACK_PRESSED -> {
                onClickBack()
            }
        }
    }

    when (state) {
        NewsInnerScreenViewState.IdleState -> {
            viewModel.intentHandler(NewsInnerScreenIntents.InitViewModelIntent(newsId = newsId))
        }

        is NewsInnerScreenViewState.SuccessState -> {
            val successState = state as NewsInnerScreenViewState.SuccessState
            val eventImage = successState.news.newsImageBase64
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
                                contentDescription = successState.news.newsName
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
                        onBackClicked = { viewModel.intentHandler(NewsInnerScreenIntents.BackPressedIntent) },
                        withArrow = true
                    )
                    Row(modifier = Modifier
                        .padding(top = 100.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        ServiceSubLabel(text = successState.news.newsDate.timestampToDateString(), isYellow = false, modifier = Modifier)
                        Spacer(modifier = Modifier.weight(1F))
                        ShareButton(modifier = Modifier, onClick = { viewModel.intentHandler(
                            NewsInnerScreenIntents.ShareNewsIntent) })
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
                                text = successState.news.newsName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 18.dp),
                                textAlign = TextAlign.Center
                            )

                            TextArea(modifier = Modifier
                                .weight(0.95f)
                                .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 40.dp),
                                text = successState.news.newsText)
                        }
                    }
                }
            }
        }

        is NewsInnerScreenViewState.ErrorState -> {
            val errorState = state as NewsInnerScreenViewState.ErrorState
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { closeApp() },
                actionSecond = { viewModel.intentHandler(NewsInnerScreenIntents.OpenChatIntent) },
                onDismiss = { closeApp() })
        }
    }
}

