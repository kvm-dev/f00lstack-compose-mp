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
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

val BooksIcon: ImageVector
    get() {
        if (_booksIcon != null) {
            return _booksIcon!!
        }
        _booksIcon = Builder(name = "BooksIcon", defaultWidth = 83.0.dp, defaultHeight = 88.0.dp,
                viewportWidth = 83.0f, viewportHeight = 88.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFFBB0267), 1.0f to Color(0xFFF89103), start =
                    Offset(42.0f,75.5f), end = Offset(72.5f,-20.5f)), stroke = null, strokeLineWidth
                    = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
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
            group {
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
                    moveTo(33.572f, 20.0f)
                    curveTo(35.6408f, 20.0f, 37.5893f, 20.9089f, 39.0005f, 22.4649f)
                    curveTo(40.4107f, 20.9089f, 42.3592f, 20.0f, 44.428f, 20.0f)
                    horizontalLineTo(51.1504f)
                    curveTo(51.896f, 20.0f, 52.5004f, 20.6534f, 52.5004f, 21.4595f)
                    lineTo(52.5f, 22.9267f)
                    lineTo(55.65f, 22.9278f)
                    curveTo(56.3335f, 22.9278f, 56.8983f, 23.4769f, 56.9877f, 24.1892f)
                    lineTo(57.0f, 24.3873f)
                    verticalLineTo(54.5405f)
                    curveTo(57.0f, 55.2794f, 56.4921f, 55.89f, 55.8332f, 55.9867f)
                    lineTo(55.65f, 56.0f)
                    horizontalLineTo(22.35f)
                    curveTo(21.6665f, 56.0f, 21.1017f, 55.4509f, 21.0123f, 54.7386f)
                    lineTo(21.0f, 54.5405f)
                    verticalLineTo(24.3873f)
                    curveTo(21.0f, 23.6484f, 21.5079f, 23.0378f, 22.1668f, 22.9411f)
                    lineTo(22.35f, 22.9278f)
                    lineTo(25.4982f, 22.9267f)
                    lineTo(25.4996f, 21.4595f)
                    curveTo(25.4996f, 20.7206f, 26.0074f, 20.11f, 26.6664f, 20.0133f)
                    lineTo(26.8496f, 20.0f)
                    horizontalLineTo(33.572f)
                    close()
                    moveTo(25.4982f, 25.8456f)
                    horizontalLineTo(23.7f)
                    verticalLineTo(53.0811f)
                    lineTo(37.0978f, 53.0807f)
                    curveTo(36.2039f, 51.9539f, 34.9211f, 51.2496f, 33.5323f, 51.1479f)
                    lineTo(33.1831f, 51.1351f)
                    horizontalLineTo(26.8496f)
                    curveTo(26.1661f, 51.1351f, 25.6013f, 50.5861f, 25.5119f, 49.8737f)
                    lineTo(25.4996f, 49.6757f)
                    lineTo(25.4982f, 25.8456f)
                    close()
                    moveTo(52.5004f, 49.6757f)
                    curveTo(52.5004f, 50.4817f, 51.896f, 51.1351f, 51.1504f, 51.1351f)
                    horizontalLineTo(44.8169f)
                    curveTo(43.2954f, 51.1351f, 41.8706f, 51.8599f, 40.9022f, 53.0807f)
                    lineTo(54.3f, 53.0811f)
                    verticalLineTo(25.8456f)
                    horizontalLineTo(52.5f)
                    lineTo(52.5004f, 49.6757f)
                    close()
                    moveTo(49.8022f, 22.917f)
                    lineTo(44.428f, 22.9189f)
                    lineTo(44.0782f, 22.9324f)
                    curveTo(42.5717f, 23.0486f, 41.1973f, 23.9109f, 40.3504f, 25.2774f)
                    verticalLineTo(49.7282f)
                    lineTo(40.3924f, 49.6954f)
                    curveTo(41.6778f, 48.7454f, 43.212f, 48.2162f, 44.8169f, 48.2162f)
                    lineTo(49.8022f, 48.2143f)
                    lineTo(49.8018f, 24.4718f)
                    lineTo(49.7976f, 24.3873f)
                    lineTo(49.8018f, 24.3005f)
                    lineTo(49.8022f, 22.917f)
                    close()
                    moveTo(33.572f, 22.9189f)
                    lineTo(28.1982f, 22.917f)
                    lineTo(28.2024f, 24.3873f)
                    lineTo(28.1982f, 24.4426f)
                    verticalLineTo(48.2143f)
                    lineTo(33.1831f, 48.2162f)
                    curveTo(34.6275f, 48.2162f, 36.0146f, 48.6449f, 37.2147f, 49.4231f)
                    lineTo(37.6482f, 49.7263f)
                    verticalLineTo(25.2755f)
                    curveTo(36.8677f, 24.0158f, 35.6366f, 23.1843f, 34.2669f, 22.9724f)
                    lineTo(33.9218f, 22.9324f)
                    lineTo(33.572f, 22.9189f)
                    close()
                }
            }
        }
        .build()
        return _booksIcon!!
    }

private var _booksIcon: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = BooksIcon, contentDescription = "")
    }
}