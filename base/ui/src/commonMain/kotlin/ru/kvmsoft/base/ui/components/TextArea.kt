package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kvmsoft.base.ui.theme.TextStyles.textArea

@Composable
fun TextArea(text: String, modifier: Modifier){
    val scrollState = rememberScrollState()
    Text(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        text = text,
        style = textArea()
    )
}