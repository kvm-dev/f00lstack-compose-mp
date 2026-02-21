package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.theme.MainYellowLight
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.TextStyles.chipsStyle
import ru.kvmsoft.base.ui.theme.UnselectedBorderChipColor

@Composable
fun Chip(
    id: Int,
    label: String,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) {
        MainYellowLight
    } else {
        SimplyWhite
    }
    val borderColor = if (isSelected) {
        Color.Transparent
    } else {
        UnselectedBorderChipColor
    }
    Box(
        modifier = modifier
            .border(border = BorderStroke(1.dp, borderColor), shape =  RoundedCornerShape(percent = 34))
            .clip(shape = RoundedCornerShape(percent = 34))
            .background(backgroundColor)
            .clickable(onClick = {onClick()})

    ) {
        Text(
            text = label,
            style = chipsStyle(),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}