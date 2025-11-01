package ru.kvmsoft.base.ui.background

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val baseBackground: ImageVector
    get() {
        if (_baseBackground != null) {
            return _baseBackground!!
        }
        _baseBackground = Builder(name = "BaseBackground", defaultWidth = 399.0.dp, defaultHeight =
                844.0.dp, viewportWidth = 399.0f, viewportHeight = 844.0f).apply {
            group {
                path(fill = linearGradient(0.0f to Color(0xFF0E0230), 1.0f to Color(0xFF100233),
                        start = Offset(0.0f,0.0f), end = Offset(267.48f,847.57f)), stroke = null,
                        strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                        strokeLineMiter = 4.0f, pathFillType = NonZero) {
                    moveTo(0.0f, 0.0f)
                    horizontalLineToRelative(399.0f)
                    verticalLineToRelative(844.0f)
                    horizontalLineToRelative(-399.0f)
                    close()
                }
                path(fill = linearGradient(0.0f to Color(0xFF0AC296), 1.0f to Color(0xFF10C09B),
                        start = Offset(196.0f,69.0f), end = Offset(189.0f,823.5f)), stroke = null,
                        fillAlpha = 0.5f, strokeLineWidth = 0.0f, strokeLineCap = Butt,
                        strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                    moveTo(-144.13f, 465.39f)
                    curveTo(-142.47f, 402.55f, -107.74f, 372.81f, -21.13f, 388.89f)
                    curveTo(-0.99f, 392.63f, -38.72f, 310.18f, -21.13f, 290.0f)
                    curveTo(-3.55f, 269.82f, 60.13f, 261.58f, 105.5f, 290.0f)
                    curveTo(150.87f, 318.42f, 241.0f, 305.0f, 267.0f, 227.5f)
                    curveTo(293.0f, 150.0f, 305.5f, 104.5f, 390.0f, 71.0f)
                    curveTo(616.37f, -18.74f, 599.23f, 199.79f, 550.37f, 260.89f)
                    lineTo(451.69f, 810.04f)
                    lineTo(387.19f, 983.54f)
                    curveTo(306.86f, 982.54f, 137.69f, 979.54f, 103.69f, 975.54f)
                    curveTo(61.19f, 970.54f, -111.81f, 908.04f, -130.81f, 889.04f)
                    curveTo(-146.01f, 873.84f, -170.97f, 568.39f, -144.13f, 465.39f)
                    close()
                }
                path(fill = linearGradient(0.0f to Color(0xFF16A085), 1.0f to Color(0xFFEF6C00),
                        start = Offset(155.0f,135.0f), end = Offset(225.5f,858.0f)), stroke = null,
                        strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                        strokeLineMiter = 4.0f, pathFillType = NonZero) {
                    moveTo(-73.5f, 498.5f)
                    curveTo(-71.83f, 435.67f, -51.0f, 293.0f, 37.0f, 289.0f)
                    curveTo(133.5f, 284.61f, 149.5f, 393.5f, 221.5f, 385.0f)
                    curveTo(320.72f, 373.29f, 273.0f, 214.0f, 317.0f, 146.0f)
                    curveTo(352.2f, 91.6f, 403.67f, 80.33f, 432.5f, 82.0f)
                    lineTo(447.5f, 747.5f)
                    lineTo(383.0f, 921.0f)
                    curveTo(302.67f, 920.0f, 133.5f, 917.0f, 99.5f, 913.0f)
                    curveTo(57.0f, 908.0f, -116.0f, 845.5f, -135.0f, 826.5f)
                    curveTo(-150.2f, 811.3f, -100.33f, 601.5f, -73.5f, 498.5f)
                    close()
                }
            }
        }
        .build()
        return _baseBackground!!
    }

private var _baseBackground: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = baseBackground, contentDescription = "")
    }
}
