package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.res.strings.getExitDialogNoButton
import ru.kvmsoft.base.ui.res.strings.getExitDialogTitle
import ru.kvmsoft.base.ui.res.strings.getExitDialogYesButton
import ru.kvmsoft.base.ui.theme.BottomSheetBackground
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ExitBottomSheet(
    lang: CurrentLanguageDomain,
    onDismissRequest: () -> Unit
) {
    BackHandler {
        onDismissRequest()
    }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { newState ->
            newState != SheetValue.Hidden
        }
    )

    val closeApplicationAnimation by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/close-animation.json").decodeToString()
        )
    }

    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        sheetState = bottomSheetState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    getExitDialogTitle(lang), modifier = Modifier
                        .fillMaxWidth(),
                    style = getFoolStackTypography().displayLarge,
                    color = SimplyWhite,
                    textAlign  = TextAlign.Center
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    contentScale = ContentScale.FillWidth,
                    painter = rememberLottiePainter(
                        composition = closeApplicationAnimation,
                        iterations = Compottie.IterateForever
                    ),
                    contentDescription = ""
                )

                MainOrangeButton(
                    isLoading = false,
                    isEnabled = true,
                    onClick = { onDismissRequest() },
                    text = getExitDialogNoButton(lang),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp))

                SecondWhiteButton(
                    isLoading = false,
                    isEnabled = true,
                    onClick = { closeApp() },
                    text = getExitDialogYesButton(lang),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp))
            }
        },
        containerColor = BottomSheetBackground
    )
}