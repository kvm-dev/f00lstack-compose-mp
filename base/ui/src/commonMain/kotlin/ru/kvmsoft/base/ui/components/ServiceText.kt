package ru.kvmsoft.base.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kvmsoft.base.ui.theme.TextStyles.serviceTextStyle

@Composable
fun ServiceText(text: String, modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        style = serviceTextStyle()
    )
}