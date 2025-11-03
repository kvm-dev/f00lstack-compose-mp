package ru.kvmsoft.features.splash.imp.presentation.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.ui.ComposeResources.logo_fs
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.theme.MainGreenLight
import ru.kvmsoft.base.ui.theme.MainOrangeLight
import ru.kvmsoft.base.ui.theme.Turquoise
import ru.kvmsoft.base.ui.theme.UnselectedNavigationColor
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.splash.imp.ComposeResources.Res
import ru.kvmsoft.features.splash.imp.presentation.res.strings.getSplashDescription
import ru.kvmsoft.features.splash.imp.presentation.res.strings.getSplashTitle
import ru.kvmsoft.features.splash.imp.presentation.viewmodel.SplashScreenViewModel
@Composable
fun SplashScreen(viewModel: SplashScreenViewModel = koinViewModel(), onNavigateToHome: () -> Unit, onNavigationAuthorization: () -> Unit) {
    val viewModelState by viewModel.progressState.collectAsState()

    when (viewModelState) {
        ProgressState.IDLE -> {
            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {
        }
        ProgressState.COMPLETED -> {
            val uiState by viewModel.uiState.collectAsState()
            when(uiState){
                SplashScreenViewState.LoadingState -> {
                    //todo loading
                }
                is SplashScreenViewState.ErrorState -> {
                    //todo network error or something else
                }
                is SplashScreenViewState.SuccessState -> {
                    val infiniteTransition = rememberInfiniteTransition()
                    val animatedColor1 by infiniteTransition.animateColor(
                        initialValue = MainOrangeLight,
                        targetValue = MainGreenLight,
                        animationSpec = infiniteRepeatable(tween(durationMillis = 2000), RepeatMode.Reverse)
                    )
                    val animatedColor2 by infiniteTransition.animateColor(
                        initialValue = Turquoise,
                        targetValue = MainOrangeLight,
                        animationSpec = infiniteRepeatable(tween(durationMillis = 2000), RepeatMode.Reverse)
                    )

                    val composition by rememberLottieComposition {
                        LottieCompositionSpec.JsonString(
                            Res.readBytes("files/fs-animation.json").decodeToString()
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(animatedColor1, animatedColor2),
                                    start = Offset(0f, 0f),
                                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                                )
                            )
                    ) {
                        Text(getSplashTitle(), modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                            .clickable{
                                onNavigationAuthorization()
                            },
                            style = getFoolStackTypography().headlineLarge,
                            textAlign  = TextAlign.Center
                        )
                        LogoIcon(
                            modifier = Modifier
                                .size(128.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            getSplashDescription((uiState as SplashScreenViewState.SuccessState).language), modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp),
                            style = getFoolStackTypography().titleMedium,
                            color = UnselectedNavigationColor,
                            textAlign  = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillWidth,
                            painter = rememberLottiePainter(
                                composition = composition,
                                iterations = Compottie.IterateForever
                            ),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

