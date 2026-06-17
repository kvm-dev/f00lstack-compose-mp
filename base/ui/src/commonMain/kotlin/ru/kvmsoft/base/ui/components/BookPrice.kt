package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.TextStyles.bookPrice

@Composable
fun BookPrice(text: String, modifier: Modifier, textAlign: TextAlign, strikethrough: Boolean = false, oldPrice: Boolean = true){
    if(oldPrice){
        if(strikethrough){
            Text(modifier = modifier
                .padding(top = 2.dp, start = 10.dp),
                textAlign = textAlign,
                textDecoration = TextDecoration.LineThrough,
                text = text, style = bookPrice(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        else{
            Text(modifier = modifier
                .padding(top = 2.dp, start = 10.dp),
                textAlign = textAlign,
                text = text, style = bookPrice(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
    else{
        Text(modifier = modifier
            .padding(top = 2.dp, end = 10.dp),
            textAlign = textAlign,
            text = text, style = bookPrice(isOld = false),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}