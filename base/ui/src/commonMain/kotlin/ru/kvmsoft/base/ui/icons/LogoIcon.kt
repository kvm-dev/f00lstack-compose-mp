package ru.kvmsoft.base.ui.icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.ComposeResources.logo_fs

@Composable
fun LogoIcon(modifier: Modifier){
    Icon(
        painter = painterResource(Res.drawable.logo_fs),
        contentDescription = "foolStack logo",
        tint = Color.Unspecified,
        modifier = modifier
    )
}