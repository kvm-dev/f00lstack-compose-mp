package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.theme.BottomSheetBackground
import ru.kvmsoft.base.ui.theme.GreenLight
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.getFoolStackTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseErrorBottomSheet(title: String, description: String, mainButtonText: String? = null, secondButtonText: String? = null, actionMain:()->Unit, actionSecond:()->Unit, onDismiss:()->Unit){
    val errorApplicationAnimation by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/error-animation.json").decodeToString()
        )
    }

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    title, modifier = Modifier
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
                        composition = errorApplicationAnimation,
                        iterations = Compottie.IterateForever
                    ),
                    contentDescription = ""
                )
                Text(
                    description,
                    modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                    style = getFoolStackTypography().bodyMedium,
                    color = GreenLight,
                    textAlign  = TextAlign.Center
                )
                if(!mainButtonText.isNullOrBlank()){
                    MainOrangeButton(
                        isLoading = false,
                        isEnabled = true,
                        onClick = { actionMain() },
                        text = mainButtonText,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp))
                }
                if(!secondButtonText.isNullOrBlank()){
                    SecondWhiteButton(
                        isLoading = false,
                        isEnabled = true,
                        onClick = { actionSecond() },
                        text = secondButtonText,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp))
                }
            }
        },
        containerColor = BottomSheetBackground
    )
}
