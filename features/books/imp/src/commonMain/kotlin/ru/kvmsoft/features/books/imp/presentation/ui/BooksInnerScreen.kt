package ru.kvmsoft.features.books.imp.presentation.ui

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
import ru.kvmsoft.base.ui.components.AdvTextBlock
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.BookInnerTitle
import ru.kvmsoft.base.ui.components.MainGreenButton
import ru.kvmsoft.base.ui.components.ScreenHeader
import ru.kvmsoft.base.ui.components.ServiceSubLabel
import ru.kvmsoft.base.ui.components.ServiceTitle
import ru.kvmsoft.base.ui.components.ServiceTransparentLabel
import ru.kvmsoft.base.ui.components.TextArea
import ru.kvmsoft.base.ui.res.strings.getBookSalePercentText
import ru.kvmsoft.base.ui.res.strings.getBuyBookInnerText
import ru.kvmsoft.base.ui.res.strings.getBuyBookText
import ru.kvmsoft.base.ui.res.strings.getStudiesAdvText
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.ui.res.strings.joinToEventButtonText
import ru.kvmsoft.base.ui.utils.ShowNotFoundImageHorizontal
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.features.books.imp.presentation.viewmodel.BooksInnerScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BooksInnerScreen(viewModel: BooksInnerScreenViewModel = koinViewModel(), bookId: Int, onClickBack: ()->Unit) {

    val state by viewModel.collectAsState()

    BackHandler(enabled = true) {
        onClickBack()
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            BooksInnerScreenSideEffects.OnBackPressed -> {
                onClickBack()
            }
            BooksInnerScreenSideEffects.CloseApp -> {
                closeApp()
            }
            BooksInnerScreenSideEffects.OpenChat -> {
                viewModel.openLinkOrOpenChat(isChat = true)
            }
            is BooksInnerScreenSideEffects.BuyBook -> {
                viewModel.openLinkOrOpenChat(sideEffect.url)
            }
            is BooksInnerScreenSideEffects.PartnerLink -> {
                viewModel.openLinkOrOpenChat(sideEffect.url)
            }
        }
    }
    when (state) {
        BooksInnerScreenViewState.IdleState -> {
            viewModel.intentHandler(BooksInnerScreenIntents.InitViewModelIntent(bookId = bookId))
        }

        is BooksInnerScreenViewState.SuccessState -> {
            val background = rememberVectorPainter(image = baseBackground)
            val successState = state as BooksInnerScreenViewState.SuccessState
            val cost = if(successState.book.bookCostWithSale>0 && successState.book.bookCostWithSale>successState.book.bookCostWithoutSale)
                successState.book.bookCostWithSale else successState.book.bookCostWithoutSale
            Box(Modifier.fillMaxSize()){
                Image(
                    painter = background,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(radius = 16.dp)
                )
                Column(modifier = Modifier
                    .padding(top = 64.dp)
                    .fillMaxSize()){
                    ScreenHeader(modifier = Modifier, text = "", onBackClicked = { viewModel.intentHandler(BooksInnerScreenIntents.BackPressedIntent) })
                    BookInnerTitle(text = successState.book.bookName, modifier = Modifier)
                    Spacer(modifier = Modifier.height(22.dp))
                    AdvTextBlock(text = "${successState.partnerText} ${getBookSalePercentText(lang = successState.lang, percent = successState.discountPercent)}", modifier = Modifier, onClick = { viewModel.intentHandler(
                        BooksInnerScreenIntents.PartnerLinkIntent(url = successState.partnerLink)
                    )})
                    TextArea(modifier = Modifier
                        .weight(0.95f)
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                        text = successState.book.bookDescription)
                    MainGreenButton(onClick = {
                        viewModel.intentHandler(BooksInnerScreenIntents.BuyBookIntent(successState.book.bookRefLink))
                    }, text = getBuyBookInnerText(successState.lang, cost), modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp))
                }
            }
        }

        is BooksInnerScreenViewState.ErrorState -> {
            val errorState = state as BooksInnerScreenViewState.ErrorState
            BaseErrorBottomSheet(
                title = getUnknownErrorTitle(lang = errorState.lang),
                description = getUnknownErrorDescription(lang = errorState.lang),
                mainButtonText = getUnknownErrorMainButton(lang = errorState.lang),
                secondButtonText = getUnknownErrorSecondButton(lang = errorState.lang),
                actionMain = { viewModel.intentHandler(BooksInnerScreenIntents.CloseApplication) },
                actionSecond = { viewModel.intentHandler(BooksInnerScreenIntents.OpenChatIntent) },
                onDismiss = { viewModel.intentHandler(BooksInnerScreenIntents.CloseApplication) })
        }
    }
}
