package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.background.emptyEvents
import ru.kvmsoft.base.ui.model.EventItem
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getCurrencySymbol
import ru.kvmsoft.base.ui.res.strings.getFreeCost
import ru.kvmsoft.base.ui.res.strings.getNotFoundEventsText
import ru.kvmsoft.base.ui.theme.ShimmerColor1
import ru.kvmsoft.base.ui.theme.SimplyBlack
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalFoundationApi::class, ExperimentalGraphicsApi::class)
@Composable
fun MainScreenEventsSlider(sliderState: UiState<EventsItemState>, lang: CurrentLanguageDomain, onClickEvent: () -> Unit,
                           selectId: MutableState<Int>, isAsActive: Boolean, isKnowHowToUseSlider: Boolean, onSwipeEvent: () -> Unit) {
    var isKnowHowToUseSlider by remember { mutableStateOf(isKnowHowToUseSlider) }
    println("стейт слайдер ин $isKnowHowToUseSlider")
    when(sliderState){
        UiState.Empty -> {
            val background = rememberVectorPainter(image = emptyEvents)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .paint(painter = background,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        sizeToIntrinsics = true),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    getNotFoundEventsText(lang), modifier = Modifier
                        .fillMaxWidth(),
                    style = getFoolStackTypography().labelSmall,
                    color = SimplyBlack,
                    textAlign  = TextAlign.Center
                )
            }
        }

        UiState.Loading->{
            Column(modifier = Modifier.fillMaxWidth()) {
                ShimmerEffect(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(top = 18.dp)
                        .background(ShimmerColor1, RoundedCornerShape(10)),
                    durationMillis = 1000,
                    cornerRadius = 10
                )
                Row(Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                    ShimmerEffect(
                        modifier = Modifier
                            .size(120.dp, 16.dp)
                            .background(ShimmerColor1, RoundedCornerShape(16)),
                        durationMillis = 1000,
                        cornerRadius = 16
                    )
                    Spacer(modifier = Modifier
                        .weight(1f)
                        .height(22.dp))
                    ShimmerEffect(
                        modifier = Modifier
                            .size(80.dp, 24.dp)
                            .background(ShimmerColor1, RoundedCornerShape(10)),
                        durationMillis = 1000,
                        cornerRadius = 10
                    )
                }
                Row(Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                    ShimmerEffect(
                        modifier = Modifier
                            .size(200.dp, 48.dp)
                            .background(ShimmerColor1, RoundedCornerShape(16)),
                        durationMillis = 1000,
                        cornerRadius = 16
                    )
                    Spacer(modifier = Modifier
                        .weight(1f)
                        .height(22.dp))
                    ShimmerEffect(
                        modifier = Modifier
                            .size(60.dp, 18.dp)
                            .background(ShimmerColor1, RoundedCornerShape(16)),
                        durationMillis = 1000,
                        cornerRadius = 16
                    )
                }
            }
        }

        is UiState.Success ->{
            val composition by rememberLottieComposition {
                LottieCompositionSpec.JsonString(
                    Res.readBytes("files/horizontal-swipe-animation.json").decodeToString()
                )
            }
            var clickEventEnabled by remember { mutableStateOf(true) }
            val eventsList = sliderState.data?.events?: listOf()
            var filteredEvents: List<EventItem> = if(isAsActive){
                eventsList.filter { it.eventCost == 0 }
            }
            else{
                eventsList
            }
            //max 5
            if(filteredEvents.size>5){
                filteredEvents = filteredEvents.subList(0, 5)
            }
            val endlessPagerMultiplier = 1000 // A large multiplier to simulate infinite scrolling without memory issues
            val pageCount = endlessPagerMultiplier * filteredEvents.size
            val initialPage = pageCount / 2
            val pagerState = rememberPagerState(
                initialPage = initialPage,
                pageCount = { pageCount }
            )

            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { page ->
                    if(initialPage!=page){
                        isKnowHowToUseSlider = true
                        onSwipeEvent()
                    }
                }
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()){
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                ) { pageIndex ->
                    val resolvedPageContentIndex = pageIndex % eventsList.size
                    val item = eventsList[resolvedPageContentIndex]
                    var subTags = ""
                    item.eventTags.forEach { tag ->
                        subTags += "${tag.name}/"
                    }
                    if (subTags.isNotEmpty()) {
                        subTags = subTags.dropLast(1)
                    }
                    val cost: String
                    val symbol = getCurrencySymbol(lang)
                    cost = if (item.eventCost > 0) {
                        "${item.eventCost} $symbol"
                    } else {
                        getFreeCost(lang)
                    }
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .clickable(enabled = clickEventEnabled) {
                                clickEventEnabled = false
                                selectId.value = item.eventId
                                onClickEvent()
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent,
                        ),
                    ) {
                        Column {
                            if (item.eventImageBase64.isNotEmpty()) {
                                if (item.eventImageBase64.decodeBase64ToBitmap() != null) {
                                    item.eventImageBase64.decodeBase64ToBitmap()?.let {
                                        Image(
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp)
                                                .clip(RoundedCornerShape(10.dp)),
                                            bitmap = it,
                                            contentDescription = item.eventName
                                        )
                                    }
                                } else {
                                    ShowNotFoundImageHorizontal()
                                }
                            } else {
                                ShowNotFoundImageHorizontal()
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                                    .align(Alignment.End)
                            ) {
                                Column(modifier = Modifier.weight(2F).padding(end = 2.dp)) {
                                    ServiceTag(subTags)
                                    ServiceTitle(modifier = Modifier, text = item.eventName)
                                }
                                Column {
                                    ServiceSubLabel(
                                        text = item.eventStartDate, modifier = Modifier
                                            .align(Alignment.End)
                                    )
                                    ServiceText(
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        text = cost
                                    )
                                }
                            }

                        }
                    }
                }
                    if(!isKnowHowToUseSlider){
                        Image(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillWidth,
                            painter = rememberLottiePainter(
                                composition = composition,
                                iterations = Compottie.IterateForever),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}