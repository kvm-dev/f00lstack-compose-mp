package ru.kvmsoft.base.ui.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val notFoundConnectionIcon: ImageVector
    get() {
        if (_notFoundConnectionIcon != null) {
            return _notFoundConnectionIcon!!
        }
        _notFoundConnectionIcon = Builder(name = "NotFoundConnectionIcon", defaultWidth = 31.0.dp,
                defaultHeight = 31.0.dp, viewportWidth = 31.0f, viewportHeight = 31.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFFF7979)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(15.5f, 3.86f)
                    curveTo(10.429f, 3.86f, 5.35f, 5.669f, 1.559f, 9.302f)
                    lineTo(0.597f, 10.232f)
                    curveTo(-0.175f, 10.967f, -0.197f, 12.193f, 0.537f, 12.965f)
                    curveTo(1.279f, 13.737f, 2.505f, 13.759f, 3.277f, 13.018f)
                    lineTo(4.245f, 12.094f)
                    curveTo(10.224f, 6.373f, 20.775f, 6.373f, 26.754f, 12.094f)
                    lineTo(27.722f, 13.018f)
                    curveTo(28.494f, 13.759f, 29.721f, 13.737f, 30.462f, 12.965f)
                    curveTo(31.196f, 12.193f, 31.174f, 10.967f, 30.402f, 10.232f)
                    lineTo(29.441f, 9.302f)
                    curveTo(25.649f, 5.669f, 20.57f, 3.86f, 15.5f, 3.86f)
                    close()
                    moveTo(15.439f, 11.625f)
                    curveTo(12.396f, 11.648f, 9.377f, 12.844f, 7.288f, 15.137f)
                    lineTo(6.319f, 16.204f)
                    curveTo(5.593f, 16.991f, 5.646f, 18.225f, 6.44f, 18.944f)
                    curveTo(7.235f, 19.663f, 8.461f, 19.602f, 9.18f, 18.807f)
                    lineTo(10.149f, 17.755f)
                    curveTo(12.556f, 15.114f, 17.884f, 14.864f, 20.608f, 17.506f)
                    curveTo(20.843f, 17.46f, 21.077f, 17.438f, 21.312f, 17.438f)
                    curveTo(22.341f, 17.438f, 23.325f, 17.846f, 24.052f, 18.573f)
                    lineTo(24.483f, 19.004f)
                    curveTo(24.506f, 18.981f, 24.529f, 18.966f, 24.559f, 18.944f)
                    curveTo(25.346f, 18.225f, 25.406f, 16.991f, 24.68f, 16.204f)
                    lineTo(23.711f, 15.137f)
                    curveTo(21.531f, 12.753f, 18.474f, 11.602f, 15.439f, 11.625f)
                    close()
                    moveTo(15.5f, 19.375f)
                    curveTo(14.508f, 19.375f, 13.517f, 19.753f, 12.76f, 20.51f)
                    curveTo(11.246f, 22.024f, 11.246f, 24.476f, 12.76f, 25.99f)
                    curveTo(14.274f, 27.503f, 16.726f, 27.503f, 18.239f, 25.99f)
                    curveTo(18.648f, 25.581f, 18.936f, 25.112f, 19.125f, 24.605f)
                    lineTo(18.572f, 24.052f)
                    curveTo(17.498f, 22.978f, 17.202f, 21.403f, 17.664f, 20.041f)
                    curveTo(17.013f, 19.602f, 16.256f, 19.375f, 15.5f, 19.375f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFC10F0F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(21.313f, 19.375f)
                    curveTo(20.798f, 19.375f, 20.306f, 19.579f, 19.943f, 19.943f)
                    curveTo(19.186f, 20.699f, 19.186f, 21.926f, 19.943f, 22.682f)
                    lineTo(22.448f, 25.188f)
                    lineTo(19.943f, 27.693f)
                    curveTo(19.186f, 28.449f, 19.186f, 29.676f, 19.943f, 30.432f)
                    curveTo(20.699f, 31.189f, 21.926f, 31.189f, 22.682f, 30.432f)
                    lineTo(25.188f, 27.927f)
                    lineTo(27.693f, 30.432f)
                    curveTo(28.449f, 31.189f, 29.676f, 31.189f, 30.432f, 30.432f)
                    curveTo(31.189f, 29.676f, 31.189f, 28.449f, 30.432f, 27.693f)
                    lineTo(27.927f, 25.188f)
                    lineTo(30.432f, 22.682f)
                    curveTo(31.189f, 21.926f, 31.189f, 20.699f, 30.432f, 19.943f)
                    curveTo(30.069f, 19.579f, 29.577f, 19.375f, 29.063f, 19.375f)
                    curveTo(28.548f, 19.375f, 28.056f, 19.579f, 27.693f, 19.943f)
                    lineTo(25.188f, 22.448f)
                    lineTo(22.682f, 19.943f)
                    curveTo(22.319f, 19.579f, 21.827f, 19.375f, 21.313f, 19.375f)
                    close()
                }
            }
        }
        .build()
        return _notFoundConnectionIcon!!
    }

private var _notFoundConnectionIcon: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = notFoundConnectionIcon, contentDescription = "")
    }
}
