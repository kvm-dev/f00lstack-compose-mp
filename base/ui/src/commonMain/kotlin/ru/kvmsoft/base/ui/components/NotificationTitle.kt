package ru.kvmsoft.base.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import ru.kvmsoft.base.ui.theme.TextStyles

@Composable
fun NotificationTitle(text: String, modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyles.notificationTitleStyle(),
        overflow = TextOverflow.Ellipsis
    )
}