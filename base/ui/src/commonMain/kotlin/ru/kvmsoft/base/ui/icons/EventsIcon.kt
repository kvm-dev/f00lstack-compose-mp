package ru.kvmsoft.base.ui.icons

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

val EventsIcon: ImageVector
    get() {
        if (_eventsIcon != null) {
            return _eventsIcon!!
        }
        _eventsIcon = Builder(name = "EventsIcon", defaultWidth = 83.0.dp, defaultHeight = 88.0.dp,
                viewportWidth = 83.0f, viewportHeight = 88.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFF370567), 1.0f to Color(0xFFC500FE), start =
                    Offset(41.5f,0.0f), end = Offset(41.5f,83.0f)), stroke = null, strokeLineWidth =
                    0.0f, strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(30.5f, 6.3509f)
                curveTo(37.3068f, 2.4209f, 45.6932f, 2.4209f, 52.5f, 6.3509f)
                lineTo(66.4401f, 14.3991f)
                curveTo(73.2469f, 18.3291f, 77.4401f, 25.5919f, 77.4401f, 33.4517f)
                verticalLineTo(49.5483f)
                curveTo(77.4401f, 57.4081f, 73.2469f, 64.6709f, 66.4401f, 68.6009f)
                lineTo(52.5f, 76.6491f)
                curveTo(45.6932f, 80.5791f, 37.3068f, 80.5791f, 30.5f, 76.6491f)
                lineTo(16.5599f, 68.6009f)
                curveTo(9.7531f, 64.6709f, 5.5599f, 57.4081f, 5.5599f, 49.5483f)
                verticalLineTo(33.4517f)
                curveTo(5.5599f, 25.5919f, 9.7531f, 18.3291f, 16.5599f, 14.3991f)
                lineTo(30.5f, 6.3509f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0EC1A9)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(46.0f, 45.0f)
                moveToRelative(-16.0f, 0.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, true, true, 32.0f, 0.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, true, true, -32.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(37.9394f, 49.5608f)
                curveTo(38.6087f, 50.2301f, 39.7231f, 50.1198f, 40.2481f, 49.3322f)
                lineTo(46.2481f, 40.3322f)
                curveTo(46.7077f, 39.6429f, 46.5213f, 38.7117f, 45.8321f, 38.2521f)
                curveTo(45.1428f, 37.7925f, 44.2114f, 37.9789f, 43.7519f, 38.6681f)
                lineTo(38.7668f, 46.1457f)
                lineTo(35.5607f, 42.9395f)
                curveTo(34.9749f, 42.3538f, 34.0251f, 42.3538f, 33.4393f, 42.9395f)
                curveTo(32.8536f, 43.5253f, 32.8536f, 44.4751f, 33.4393f, 45.0609f)
                lineTo(37.9394f, 49.5608f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(55.5001f, 23.0f)
                horizontalLineTo(47.7431f)
                curveTo(47.1255f, 21.2521f, 45.4598f, 20.0f, 43.5f, 20.0f)
                curveTo(41.5403f, 20.0f, 39.8746f, 21.2521f, 39.257f, 23.0f)
                horizontalLineTo(35.7432f)
                curveTo(35.1255f, 21.2521f, 33.4598f, 20.0f, 31.5f, 20.0f)
                curveTo(29.5402f, 20.0f, 27.8746f, 21.2521f, 27.2569f, 23.0f)
                horizontalLineTo(22.5f)
                curveTo(21.6716f, 23.0f, 21.0f, 23.6716f, 21.0f, 24.5f)
                verticalLineTo(32.0f)
                verticalLineTo(54.5f)
                curveTo(21.0f, 55.3284f, 21.6716f, 56.0f, 22.5f, 56.0f)
                horizontalLineTo(55.5f)
                curveTo(56.3284f, 56.0f, 57.0f, 55.3284f, 57.0f, 54.5f)
                verticalLineTo(32.0f)
                verticalLineTo(24.5f)
                curveTo(57.0001f, 23.6716f, 56.3285f, 23.0f, 55.5001f, 23.0f)
                close()
                moveTo(24.0f, 26.0f)
                horizontalLineTo(28.5f)
                curveTo(29.3285f, 26.0f, 30.0f, 25.3284f, 30.0f, 24.5f)
                curveTo(30.0f, 23.6709f, 30.6709f, 23.0f, 31.5f, 23.0f)
                curveTo(32.3291f, 23.0f, 33.0f, 23.6709f, 33.0f, 24.5f)
                curveTo(33.0f, 25.3291f, 32.3291f, 26.0f, 31.5001f, 26.0f)
                curveTo(30.6716f, 26.0f, 30.0001f, 26.6715f, 30.0001f, 27.5f)
                curveTo(30.0001f, 28.3284f, 30.6716f, 28.9999f, 31.5001f, 28.9999f)
                curveTo(33.4598f, 28.9999f, 35.1255f, 27.7478f, 35.7432f, 25.9999f)
                horizontalLineTo(40.5001f)
                curveTo(41.3285f, 25.9999f, 42.0001f, 25.3284f, 42.0001f, 24.4999f)
                curveTo(42.0001f, 23.6709f, 42.671f, 23.0f, 43.5f, 23.0f)
                curveTo(44.3291f, 23.0f, 45.0f, 23.6709f, 45.0f, 24.5f)
                curveTo(45.0f, 25.3291f, 44.3291f, 26.0f, 43.5f, 26.0f)
                curveTo(42.6716f, 26.0f, 42.0001f, 26.6715f, 42.0001f, 27.5f)
                curveTo(42.0001f, 28.3284f, 42.6716f, 28.9999f, 43.5f, 28.9999f)
                curveTo(45.4598f, 28.9999f, 47.1255f, 27.7478f, 47.7431f, 25.9999f)
                horizontalLineTo(54.0f)
                verticalLineTo(30.4999f)
                horizontalLineTo(24.0f)
                verticalLineTo(26.0f)
                close()
                moveTo(54.0f, 53.0f)
                horizontalLineTo(24.0f)
                verticalLineTo(33.5f)
                horizontalLineTo(54.0001f)
                verticalLineTo(53.0f)
                horizontalLineTo(54.0f)
                close()
            }
        }
        .build()
        return _eventsIcon!!
    }

private var _eventsIcon: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = EventsIcon, contentDescription = "")
    }
}