package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.TextStyles.serviceTitleStyle

@Composable
fun ServiceTitle(text: String, modifier: Modifier){
    Text(modifier = modifier
        .padding(top = 10.dp)
        .width(240.dp),
        textAlign = TextAlign.Start,
        text = text, style = serviceTitleStyle(),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}