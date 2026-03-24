package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.TextStyles.boldItalicLabel

@Composable
fun ServiceTransparentLabel(text: String, modifier: Modifier){
    Text(modifier = modifier
        .padding(horizontal = 8.dp),
        textAlign = TextAlign.Center,
        text = text, style = boldItalicLabel(),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}