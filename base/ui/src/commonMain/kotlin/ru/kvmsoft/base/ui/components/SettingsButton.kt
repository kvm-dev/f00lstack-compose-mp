package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.icons.settingsIcon
import ru.kvmsoft.base.ui.theme.MainGreenLight
import ru.kvmsoft.base.ui.theme.SimplyWhite

@Composable
fun SettingsButton(onClick: ()-> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

        Icon(
            tint = SimplyWhite,
            imageVector = settingsIcon,
            contentDescription = "settings",
            modifier = Modifier
                .size(32.dp)
                .padding(2.dp)
                .clickable(
                interactionSource = interactionSource,
                indication = ripple(
                    bounded = true,
                    radius = 24.dp,
                    color = MainGreenLight
                ),
                onClick = { onClick() }
            )
        )
}