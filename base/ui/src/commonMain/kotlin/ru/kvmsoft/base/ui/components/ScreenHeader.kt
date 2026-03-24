package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.icons.BackArrowIcon
import ru.kvmsoft.base.ui.theme.MainGreenLight
import ru.kvmsoft.base.ui.theme.TextStyles.screenTitleStyle

@Composable
fun ScreenHeader(text: String, modifier: Modifier, onBackClicked: () -> Unit, withArrow: Boolean = true){
    val interaction = remember { MutableInteractionSource() }
    Box(modifier = modifier.
    padding(horizontal = 16.dp)) {
        if(withArrow){
            Icon(
                tint = Color.Unspecified,
                imageVector = BackArrowIcon,
                contentDescription = "backButton",
                modifier = Modifier
                    .size(width = 6.dp, height = 12.dp)
                    .clickable(
                        interactionSource = interaction,
                        indication = ripple(
                            bounded = true,
                            radius = 24.dp,
                            color = MainGreenLight
                        ),
                        onClick = { onBackClicked() }
                    )
            )
        }
        Text(modifier = modifier
            .fillMaxWidth(),
            text = text,
            style = screenTitleStyle(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}