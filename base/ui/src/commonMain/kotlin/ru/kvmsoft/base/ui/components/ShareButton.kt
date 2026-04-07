package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kvmsoft.base.ui.icons.ShareIcon
import ru.kvmsoft.base.ui.theme.MainOrangeLight

@Composable
fun ShareButton(modifier: Modifier, onClick: () -> Unit) {
        Box(modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .size(32.dp)
            .background(MainOrangeLight)
            .clickable{
                onClick()
            },
            contentAlignment = Alignment.Center)
        {
            Icon(
                imageVector = ShareIcon,
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
            )
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewShareButton() {
    ShareButton(onClick = {}, modifier = Modifier)
}