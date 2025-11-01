package ru.kvmsoft.base.ui.icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.ComposeResources.preview_icon

@Composable
fun PreviewIcon(modifier: Modifier){
    Icon(
        painter = painterResource(Res.drawable.preview_icon),
        contentDescription = "foolStack preview",
        tint = Color.Unspecified,
        modifier = modifier
    )
}