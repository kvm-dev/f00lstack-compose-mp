package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.MainBlueGreen
import ru.kvmsoft.base.ui.theme.MainYellowLight
import ru.kvmsoft.base.ui.theme.TextStyles.serviceTagStyle

@Composable
fun ServiceSubLabel(text: String, modifier: Modifier, isYellow: Boolean = true){
    val background = if(isYellow){
        MainYellowLight
    }
    else{
        MainBlueGreen
    }
    Box(modifier = modifier
        .clip(RoundedCornerShape(7.dp))
        .background(
            color = background,
            shape = RoundedCornerShape(60.dp)
        )) {
        Text(modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            text = text, style = serviceTagStyle()
        )
    }
}