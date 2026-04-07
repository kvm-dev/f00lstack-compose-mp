package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import com.kashif_e.backdrop.drawBackdrop
import com.kashif_e.backdrop.effects.blur
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.model.EventItem
import ru.kvmsoft.base.ui.model.NewsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getCurrencySymbol
import ru.kvmsoft.base.ui.res.strings.getEventsListScreenTitle
import ru.kvmsoft.base.ui.res.strings.getFreePay
import ru.kvmsoft.base.ui.res.strings.getMoreButtonText
import ru.kvmsoft.base.ui.res.strings.getNewsListScreenTitle
import ru.kvmsoft.base.ui.res.strings.getNotFoundNewsText
import ru.kvmsoft.base.ui.theme.HeaderMainColorWithTransparent
import ru.kvmsoft.base.ui.theme.ShimmerColor1
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsVerticalSlider(
    modifier: Modifier,
    lang: CurrentLanguageDomain,
    newsState: UiState<NewsItemState>,
    onClickNews: () -> Unit,
    selectId: MutableState<Int>,
    isRefreshing: Boolean,
    isConnectionAvailable: Boolean,
    onRefresh: ()->Unit
) {
    var clickEnabled by remember { mutableStateOf(true) }
    val state = rememberPullToRefreshState()
    when(newsState){
        UiState.Empty -> {
            val backdrop = rememberLayerBackdrop()
            val composition by rememberLottieComposition {
                LottieCompositionSpec.JsonString(
                    Res.readBytes("files/calendar-animation.json").decodeToString()
                )
            }
            Box(
                modifier = modifier
                    .padding(top = 10.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .drawBackdrop(
                        backdrop = backdrop,
                        shape = { RoundedCornerShape(24.dp) },
                        effects = { blur(68.dp.toPx()) }
                    )
                    .fillMaxWidth()
                    .background(Color.Gray.copy(alpha = 0.5f))
                    .clip(RoundedCornerShape(percent = 24))
                    .padding(16.dp)){
                    Column(modifier = Modifier
                        .padding(top = 48.dp)
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .padding(top = 48.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillWidth,
                            painter = rememberLottiePainter(
                                composition = composition,
                                iterations = Compottie.IterateForever),
                            contentDescription = ""
                        )

                        ErrorTitleText(text = getNotFoundNewsText(lang), modifier = Modifier.padding(top = 12.dp))
                    }
                }
            }
        }
        UiState.Loading -> {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 10.dp,
                    bottom = 10.dp
                ),
                modifier = modifier
                    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                    .pullToRefresh(
                        state = if(isConnectionAvailable) { state } else {
                            PullToRefreshState()
                        },
                        isRefreshing = isRefreshing,
                        onRefresh = { if(isConnectionAvailable){
                            onRefresh()
                        }
                        }
                    )
            ) {
                stickyHeader {
                    Column(modifier = Modifier
                        .background(HeaderMainColorWithTransparent)) {
                        ScreenHeader(
                            withArrow = false,
                            modifier = Modifier,
                            text = getNewsListScreenTitle(lang = lang),
                            onBackClicked = {}
                        )
                    }
                }
                items(10) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp)) {
                        ShimmerEffect(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .padding(top = 18.dp)
                                .background(ShimmerColor1, RoundedCornerShape(10)),
                            durationMillis = 1000,
                            cornerRadius = 10
                        )
                        ShimmerEffect(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                        )
                        ShimmerEffect(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .fillMaxWidth(Random.nextFloat())
                                .height(20.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                        )
                        ShimmerEffect(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .width(64.dp)
                                .height(12.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                        )

                        ShimmerEffect(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth()
                                .height(48.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                        )
                    }
                }
            }
        }

        is UiState.Success-> {
            PullToRefreshBox(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .zIndex(1F),
                indicator = {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .graphicsLayer {
                                translationY = state.distanceFraction * 50.dp.toPx()
                                alpha = state.distanceFraction.coerceIn(0f, 1f)
                            }
                            .background(Color.Transparent, CircleShape)
                            .padding(8.dp)
                    ) {
                        if (isRefreshing) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        } else {
                            LogoIcon(modifier = Modifier.size(48.dp).rotate(state.distanceFraction * 360f))
                        }
                    }
                },
                state = state,
                isRefreshing = isRefreshing,
                onRefresh = onRefresh) {
                LazyColumn(
                    modifier = modifier,
                    contentPadding = PaddingValues(
                        bottom = 10.dp
                    )
                ) {
                    stickyHeader() {
                        Column(
                            modifier = Modifier
                                .background(HeaderMainColorWithTransparent)
                                .clickable(enabled = false) { }
                        ) {
                            ScreenHeader(
                                withArrow = false,
                                modifier = Modifier,
                                text = getNewsListScreenTitle(lang = lang),
                                onBackClicked = {}
                            )
                        }
                    }

                    itemsIndexed(newsState.data?.news?.sortedBy { it.newsId } ?: listOf()) { index, news ->

                        Card(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 18.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Transparent,
                            ),
                        ) {
                            Column {
                                if (news.newsImageBase64.isNotEmpty()) {
                                    if (news.newsImageBase64.decodeBase64ToBitmap() != null) {
                                        news.newsImageBase64.decodeBase64ToBitmap()?.let {
                                            Image(
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(180.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                bitmap = it,
                                                contentDescription = news.newsName
                                            )
                                        }
                                    } else {
                                        ShowNotFoundImageHorizontal()
                                    }
                                } else {
                                    ShowNotFoundImageHorizontal()
                                }
                                ServiceTitle(modifier = Modifier
                                    .padding(top = 8.dp)
                                    .fillMaxWidth(),
                                    text = news.newsName,
                                    textAlign = TextAlign.Start)
                                ServiceTag(
                                    text = news.newsDate.timestampToDateString(),
                                    modifier = Modifier
                                        .padding(top = 16.dp))
                                MainOrangeButton(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(top = 16.dp),
                                    isEnabled = true,
                                    isLoading = false,
                                    text = getMoreButtonText(lang),
                                    onClick = {
                                    if(clickEnabled) {
                                        clickEnabled = false
                                        selectId.value = news.newsId
                                        onClickNews()
                                    }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}