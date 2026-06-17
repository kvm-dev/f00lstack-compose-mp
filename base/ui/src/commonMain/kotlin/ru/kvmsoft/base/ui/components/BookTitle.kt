package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.TextStyles.bookTitleStyle

@Composable
fun BookTitle(text: String, modifier: Modifier, textAlign: TextAlign){
    Text(modifier = modifier
        .padding(top = 10.dp)
        .fillMaxWidth(),
        textAlign = textAlign,
        text = text, style = bookTitleStyle(),
        maxLines = 3,
        minLines = 3,
        overflow = TextOverflow.Ellipsis
    )
}