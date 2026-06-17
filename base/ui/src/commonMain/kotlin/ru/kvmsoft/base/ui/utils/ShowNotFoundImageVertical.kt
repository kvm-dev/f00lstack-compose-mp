package ru.kvmsoft.base.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.images.notFoundImageHorizontal

@Composable
fun ShowNotFoundImageVertical(modifier: Modifier? = null) {
    if(modifier == null){
        Image(
            imageVector = notFoundImageHorizontal,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp) // Example size
                .clip(RoundedCornerShape(percent = 10)),
        )
    }
    else{
        Image(
            imageVector = notFoundImageHorizontal,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier,
        )
    }
}