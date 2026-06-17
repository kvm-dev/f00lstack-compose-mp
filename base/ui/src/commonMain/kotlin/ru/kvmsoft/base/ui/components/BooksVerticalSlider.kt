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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import com.kashif_e.backdrop.drawBackdrop
import com.kashif_e.backdrop.effects.blur
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.model.BooksItemState
import ru.kvmsoft.base.ui.model.Chip
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getBooksListScreenTitle
import ru.kvmsoft.base.ui.res.strings.getBooksSearchPlaceholderText
import ru.kvmsoft.base.ui.res.strings.getBuyBookText
import ru.kvmsoft.base.ui.res.strings.getCurrencySymbol
import ru.kvmsoft.base.ui.res.strings.getFreePay
import ru.kvmsoft.base.ui.res.strings.getNotFoundBooksText
import ru.kvmsoft.base.ui.res.strings.getNotFoundWithFiltersOrSearchText
import ru.kvmsoft.base.ui.res.strings.getOkButton
import ru.kvmsoft.base.ui.theme.HeaderMainColorWithTransparent
import ru.kvmsoft.base.ui.theme.ShimmerColor1
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageVertical
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksVerticalSlider(
    modifier: Modifier,
    isAsActive: Boolean,
    lang: CurrentLanguageDomain,
    booksState: UiState<BooksItemState>,
    chips: List<Chip>,
    selectedChips: List<String>,
    onClickBook: () -> Unit,
    subscribeText: String,
    subscribeClick: ()-> Unit,
    searchKeyWord: MutableState<String>,
    selectId: MutableState<Int>,
    currentBookLink: MutableState<String>,
    selectedChip: MutableState<String>,
    onclickChip: () -> Unit,
    isRefreshing: Boolean,
    isConnectionAvailable: Boolean,
    onRefresh: ()->Unit,
    onClickBack: () -> Unit,
    buyBook: () -> Unit
) {
    var clickEnabled by remember { mutableStateOf(true) }
    val state = rememberPullToRefreshState()
    when(booksState){
        UiState.Empty -> {
            val backdrop = rememberLayerBackdrop()
            val composition by rememberLottieComposition {
                LottieCompositionSpec.JsonString(
                    Res.readBytes("files/books-animation.json").decodeToString()
                )
            }
            Box(
                modifier = Modifier
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

                        ErrorTitleText(text = getNotFoundBooksText(lang), modifier = Modifier.padding(top = 12.dp))

                        MainYellowButton(
                            text = getOkButton(),
                            onClick = onClickBack,
                            isEnabled = true,
                            isLoading = false,
                            modifier = Modifier
                                .width(200.dp)
                                .padding(top = 48.dp))
                    }
                }
            }
        }
        UiState.Loading -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    top = 60.dp,
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
                            modifier = Modifier,
                            text = getBooksListScreenTitle(lang = lang),
                            onBackClicked = onClickBack
                        )
                        LazyRow(Modifier.padding(top = 16.dp, bottom = 10.dp)) {
                            items(10) {
                                ShimmerEffect(
                                    modifier = Modifier
                                        .width(120.dp)
                                        .height(37.dp)
                                        .padding(horizontal = 4.dp)
                                        .background(ShimmerColor1, RoundedCornerShape(34)),
                                    durationMillis = 1000,
                                    cornerRadius = 34
                                )
                            }
                        }
                        ShimmerEffect(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 8.dp, end = 8.dp, top = 10.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                        )
                    }
                }
                item(
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    ShimmerEffect(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                            .padding(24.dp)
                            .background(ShimmerColor1, RoundedCornerShape(24)),
                        durationMillis = 1000,
                        cornerRadius = 24
                    )
                }
                items(10) {
                    ShimmerEffect(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(310.dp)
                                .padding(top = 18.dp, start = 16.dp, end = 16.dp)
                                .background(ShimmerColor1, RoundedCornerShape(16)),
                            durationMillis = 1000,
                            cornerRadius = 16
                    )
                }
            }
        }

        is UiState.Success -> {
            val scope = rememberCoroutineScope()
            val filteredBooks = remember(booksState, selectedChips) {
                val allBooks = booksState.data?.books ?: emptyList()
                val activeChips = selectedChips.filter { it.isNotEmpty() }

                if (activeChips.isEmpty()) {
                    emptyList()
                } else {
                    allBooks.sortedBy { it.bookId }
                }
            }

            val keywordWithFilteredBooks = if(searchKeyWord.value.isNotEmpty() && searchKeyWord.value.length>2){
                filteredBooks.filter { it.bookName.toLowerCase(Locale.current).contains(searchKeyWord.value.toLowerCase(Locale.current)) }.toList()
            } else {
                filteredBooks
            }

            PullToRefreshBox(
                modifier = Modifier
                    .padding(top = 40.dp)
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
                onRefresh = onRefresh
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        top = 20.dp,
                        bottom = 10.dp
                    )
                ) {
                    stickyHeader {
                        Column(
                            modifier = Modifier
                                .background(HeaderMainColorWithTransparent)
                                .clickable(enabled = false) { }
                        ) {
                            ScreenHeader(
                                modifier = Modifier,
                                text = getBooksListScreenTitle(lang = lang),
                                onBackClicked = onClickBack
                            )
                            ChipSelector(
                                chips = chips,
                                selectedChips = selectedChips,
                                selectedChip = selectedChip,
                                onclickChip = onclickChip
                            )
                            SearchInput(
                                modifier = Modifier,
                                keyword = searchKeyWord,
                                placeholderText = getBooksSearchPlaceholderText(lang),
                                onValueChange = { searchKeyWord.value = it }
                            )
                        }
                    }
                    if(!isAsActive){
                        item(
                            span = { GridItemSpan(maxLineSpan) }
                        ) {
                            AdvTextBlock(text = subscribeText, modifier = Modifier, onClick = subscribeClick)
                        }
                    }
                    if(keywordWithFilteredBooks.isNotEmpty()){
                        itemsIndexed(keywordWithFilteredBooks) { index, book ->
                            val defaultCost = remember(book.bookPrice, lang) {
                                if (book.bookPrice > 0) {
                                    if(lang == CurrentLanguageDomain.RU){
                                        "${book.bookPrice} ${getCurrencySymbol(lang)}"
                                    }
                                    else{
                                        "${getCurrencySymbol(lang)}${book.bookPrice}"
                                    }
                                } else {
                                    getFreePay(lang)
                                }
                            }

                            val saleCost = remember(book.bookSalePrice, lang) {
                                if (book.bookSalePrice > 0) {
                                    if(lang == CurrentLanguageDomain.RU){
                                        "${book.bookSalePrice} ${getCurrencySymbol(lang)}"
                                    }
                                    else{
                                        "${getCurrencySymbol(lang)}${book.bookSalePrice}"
                                    }
                                } else {
                                    ""
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .clickable(enabled = clickEnabled) {
                                        clickEnabled = false
                                        selectId.value = book.bookId
                                        if(!isAsActive){
                                            onClickBook()
                                        }
                                        scope.launch {
                                            delay(500)
                                            clickEnabled = true
                                        }
                                    }
                                    .padding(horizontal = 20.dp, vertical = 18.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent,
                                ),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(shape = RoundedCornerShape(16.dp), color = SimplyWhite)) {
                                    if (book.bookImageBase64.isNotEmpty()) {
                                        val bitmap = remember(book.bookImageBase64) {
                                            book.bookImageBase64.decodeBase64ToBitmap()
                                        }
                                        if (bitmap != null) {
                                            Image(
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(10.dp)),
                                                bitmap = bitmap,
                                                contentDescription = book.bookName
                                            )
                                        } else {
                                            ShowNotFoundImageVertical()
                                        }
                                    } else {
                                        ShowNotFoundImageVertical()
                                    }
                                    BookTitle(
                                        text = book.bookName,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.
                                        padding(horizontal = 10.dp))
                                    if(!isAsActive){
                                        if(book.bookSalePrice>0 && book.bookPrice>book.bookSalePrice){
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 10.dp)
                                                    .align(Alignment.End)
                                            ) {
                                                BookPrice(
                                                    strikethrough = true,
                                                    text = defaultCost,
                                                    modifier = Modifier,
                                                    textAlign = TextAlign.Start)
                                                Spacer(modifier = Modifier.weight(1f))
                                                BookPrice(
                                                    oldPrice = false,
                                                    text = saleCost,
                                                    modifier = Modifier,
                                                    textAlign = TextAlign.End)
                                            }
                                        }
                                        else{
                                            BookPrice(
                                                text = defaultCost,
                                                modifier = Modifier,
                                                textAlign = TextAlign.Start)
                                        }
                                        MainGreenButton(onClick = {
                                            currentBookLink.value = book.bookRefLink
                                            buyBook()
                                        }, getBuyBookText(lang), modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 6.dp, end = 6.dp, bottom = 6.dp, top = 12.dp))
                                    }
                                }
                            }
                        }
                    }
                    else{
                        item(
                            span = { GridItemSpan(maxLineSpan) }
                        ) {
                            NotFoundItemsBlock(text = getNotFoundWithFiltersOrSearchText(lang))
                        }
                    }
                }
            }
        }
    }
}