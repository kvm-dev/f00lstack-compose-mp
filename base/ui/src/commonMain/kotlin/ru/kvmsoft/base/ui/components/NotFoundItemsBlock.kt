package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.DisabledButtonBackground
import ru.kvmsoft.base.ui.theme.TextStyles.advTextStyle

@Composable
fun NotFoundItemsBlock(text: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 32.dp)
            .border(width = 1.dp, color = DisabledButtonBackground, shape = RoundedCornerShape(18.dp))
            .padding(horizontal = 10.dp, vertical = 14.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            textAlign = TextAlign.Center,
            style = advTextStyle()
        )
    }
}