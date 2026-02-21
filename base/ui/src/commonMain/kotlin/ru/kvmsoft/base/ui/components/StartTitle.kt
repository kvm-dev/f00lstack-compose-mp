package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.TextStyles
import ru.kvmsoft.base.ui.theme.getFoolStackTypography

@Composable
fun StartTitle(text: String, modifier: Modifier) {
    Text(
        text, modifier = modifier
            .fillMaxWidth(),
        style = TextStyles.getTitlesStyle().titleMedium,
        color = SimplyWhite,
        textAlign  = TextAlign.Start
    )
}