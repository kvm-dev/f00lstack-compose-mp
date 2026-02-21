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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

public val emptyEvents: ImageVector
    get() {
        if (_emptyEvents != null) {
            return _emptyEvents!!
        }
        _emptyEvents = Builder(name = "EmptyEvents", defaultWidth = 351.0.dp, defaultHeight =
                180.0.dp, viewportWidth = 351.0f, viewportHeight = 180.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFF956625), 0.730869f to Color(0xFFFBAB3E),
                    start = Offset(175.5f,0.0f), end = Offset(175.5f,180.0f)), stroke = null,
                    fillAlpha = 0.9f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin =
                    Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.0f, 0.0f)
                lineTo(341.0f, 0.0f)
                arcTo(10.0f, 10.0f, 0.0f, false, true, 351.0f, 10.0f)
                lineTo(351.0f, 170.0f)
                arcTo(10.0f, 10.0f, 0.0f, false, true, 341.0f, 180.0f)
                lineTo(10.0f, 180.0f)
                arcTo(10.0f, 10.0f, 0.0f, false, true, 0.0f, 170.0f)
                lineTo(0.0f, 10.0f)
                arcTo(10.0f, 10.0f, 0.0f, false, true, 10.0f, 0.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF0EC1A9)),
                    strokeAlpha = 0.26f, strokeLineWidth = 1.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.0f, 0.5f)
                lineTo(341.0f, 0.5f)
                arcTo(9.5f, 9.5f, 0.0f, false, true, 350.5f, 10.0f)
                lineTo(350.5f, 170.0f)
                arcTo(9.5f, 9.5f, 0.0f, false, true, 341.0f, 179.5f)
                lineTo(10.0f, 179.5f)
                arcTo(9.5f, 9.5f, 0.0f, false, true, 0.5f, 170.0f)
                lineTo(0.5f, 10.0f)
                arcTo(9.5f, 9.5f, 0.0f, false, true, 10.0f, 0.5f)
                close()
            }
        }
        .build()
        return _emptyEvents!!
    }

private var _emptyEvents: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = emptyEvents, contentDescription = "")
    }
}
