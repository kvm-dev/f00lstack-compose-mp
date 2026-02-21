package ru.kvmsoft.base.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import ru.kvmsoft.base.ui.theme.DisabledButtonBackground
import ru.kvmsoft.base.ui.theme.GreenLight
import ru.kvmsoft.base.ui.theme.MainBackgroundLight
import ru.kvmsoft.base.ui.theme.MainBlackLight
import ru.kvmsoft.base.ui.theme.MainGreyLight
import ru.kvmsoft.base.ui.theme.MainMenuBackgroundLight
import ru.kvmsoft.base.ui.theme.MainOrangeLight
import ru.kvmsoft.base.ui.theme.MainYellowLight
import ru.kvmsoft.base.ui.theme.ShimmerColor1
import ru.kvmsoft.base.ui.theme.ShimmerColor2
import ru.kvmsoft.base.ui.theme.ShimmerColor3
import ru.kvmsoft.base.ui.theme.ShimmerColor4
import ru.kvmsoft.base.ui.theme.ShimmerColor5
import ru.kvmsoft.base.ui.theme.ShimmerColor6
import ru.kvmsoft.base.ui.theme.ShimmerColor7
import ru.kvmsoft.base.ui.theme.Turquoise
import ru.kvmsoft.base.ui.theme.Unfocused

@Composable
fun ShimmerEffect(
    modifier: Modifier,
    widthOfShadowBrush: Int = 500,
    angleOfAxisY: Float = 270f,
    durationMillis: Int = 1000,
    cornerRadius: Int
) {
//    val shimmerColors = listOf(
//        Color.White.copy(alpha = 0.3f),
//        Color.White.copy(alpha = 0.5f),
//        Color.White.copy(alpha = 1.0f),
//        Color.White.copy(alpha = 0.5f),
//        Color.White.copy(alpha = 0.3f),
//    )

    val shimmerColors = listOf(
        ShimmerColor1.copy(alpha = 0.3f),
        ShimmerColor2.copy(alpha = 0.3f),
        ShimmerColor3.copy(alpha = 0.3f),
        ShimmerColor4.copy(alpha = 0.5f),
        ShimmerColor5.copy(alpha = 1.0f),
        ShimmerColor6.copy(alpha = 0.5f),
        ShimmerColor7.copy(alpha = 0.3f)
    )
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
        end = Offset(x = translateAnimation.value, y = angleOfAxisY),
    )

    Box(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(brush, shape = RoundedCornerShape(cornerRadius))
        )
    }


}