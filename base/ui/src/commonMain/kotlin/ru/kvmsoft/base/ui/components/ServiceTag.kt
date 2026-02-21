package ru.kvmsoft.base.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import ru.kvmsoft.base.ui.theme.TextStyles

@Composable
fun ServiceTag(text: String){
    Text(
        text = text,
        textAlign = TextAlign.Start,
        style = TextStyles.serviceTagStyle(),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}