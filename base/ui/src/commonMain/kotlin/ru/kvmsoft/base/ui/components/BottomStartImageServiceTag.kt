package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.TextStyles

@Composable
fun BottomStartImageServiceTag(text: String, modifier: Modifier){
    Box(modifier = modifier
        .background(
            color = Color.Black.copy(alpha = 0.5f),
            shape = RoundedCornerShape(bottomStart = 10.dp, topEnd = 10.dp)
        )
        .border(
            width = 2.dp,
            color = SimplyWhite,
            shape = RoundedCornerShape(bottomStart = 10.dp, topEnd = 10.dp)
        )
    ){
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 4.dp),
            text = text,
            textAlign = TextAlign.Start,
            style = TextStyles.serviceTagStyle(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}