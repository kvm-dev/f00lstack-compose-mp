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

public val settingsIcon: ImageVector
    get() {
        if (_settings != null) {
            return _settings!!
        }
        _settings = Builder(name = "Settings", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(13.313f, 23.759f)
                    horizontalLineTo(10.79f)
                    curveTo(10.411f, 23.759f, 10.278f, 23.76f, 8.985f, 20.555f)
                    lineTo(7.986f, 20.149f)
                    curveTo(5.264f, 21.384f, 4.942f, 21.384f, 4.834f, 21.384f)
                    horizontalLineTo(4.626f)
                    lineTo(4.448f, 21.231f)
                    lineTo(2.66f, 19.482f)
                    curveTo(2.388f, 19.21f, 2.294f, 19.116f, 3.693f, 15.953f)
                    lineTo(3.286f, 14.99f)
                    curveTo(0.0f, 13.812f, 0.0f, 13.676f, 0.0f, 13.288f)
                    verticalLineTo(10.814f)
                    curveTo(0.0f, 10.427f, 0.0f, 10.304f, 3.275f, 9.038f)
                    lineTo(3.682f, 8.072f)
                    curveTo(2.202f, 4.958f, 2.304f, 4.861f, 2.596f, 4.586f)
                    lineTo(4.519f, 2.701f)
                    lineTo(4.758f, 2.693f)
                    curveTo(5.048f, 2.693f, 6.125f, 3.086f, 7.962f, 3.862f)
                    lineTo(8.958f, 3.457f)
                    curveTo(10.157f, 0.24f, 10.304f, 0.241f, 10.683f, 0.241f)
                    horizontalLineTo(13.206f)
                    curveTo(13.583f, 0.241f, 13.716f, 0.241f, 15.01f, 3.447f)
                    lineTo(16.01f, 3.85f)
                    curveTo(18.728f, 2.616f, 19.054f, 2.616f, 19.163f, 2.616f)
                    horizontalLineTo(19.37f)
                    lineTo(19.548f, 2.766f)
                    lineTo(21.336f, 4.513f)
                    curveTo(21.608f, 4.788f, 21.701f, 4.882f, 20.301f, 8.045f)
                    lineTo(20.71f, 9.015f)
                    curveTo(24.0f, 10.187f, 24.0f, 10.323f, 24.0f, 10.712f)
                    verticalLineTo(13.182f)
                    curveTo(24.0f, 13.561f, 24.0f, 13.694f, 20.721f, 14.961f)
                    lineTo(20.316f, 15.928f)
                    curveTo(21.789f, 19.029f, 21.692f, 19.126f, 21.416f, 19.404f)
                    lineTo(19.478f, 21.301f)
                    lineTo(19.238f, 21.308f)
                    curveTo(18.949f, 21.308f, 17.874f, 20.914f, 16.04f, 20.138f)
                    lineTo(15.038f, 20.542f)
                    curveTo(13.835f, 23.759f, 13.699f, 23.759f, 13.313f, 23.759f)
                    close()
                    moveTo(11.052f, 22.738f)
                    horizontalLineTo(13.042f)
                    curveTo(13.271f, 22.272f, 13.764f, 21.038f, 14.159f, 19.975f)
                    lineTo(14.239f, 19.764f)
                    lineTo(16.051f, 19.032f)
                    lineTo(16.246f, 19.115f)
                    curveTo(17.325f, 19.575f, 18.602f, 20.085f, 19.099f, 20.242f)
                    lineTo(20.497f, 18.875f)
                    curveTo(20.32f, 18.382f, 19.781f, 17.178f, 19.295f, 16.162f)
                    lineTo(19.198f, 15.955f)
                    lineTo(19.947f, 14.165f)
                    lineTo(20.151f, 14.087f)
                    curveTo(21.242f, 13.667f, 22.506f, 13.149f, 22.978f, 12.912f)
                    verticalLineTo(10.991f)
                    curveTo(22.5f, 10.766f, 21.241f, 10.288f, 20.157f, 9.903f)
                    lineTo(19.944f, 9.827f)
                    lineTo(19.19f, 8.036f)
                    lineTo(19.28f, 7.834f)
                    curveTo(19.744f, 6.786f, 20.26f, 5.551f, 20.426f, 5.053f)
                    lineTo(19.024f, 3.682f)
                    curveTo(18.571f, 3.84f, 17.304f, 4.383f, 16.235f, 4.871f)
                    lineTo(16.036f, 4.962f)
                    lineTo(14.224f, 4.232f)
                    lineTo(14.144f, 4.031f)
                    curveTo(13.715f, 2.962f, 13.183f, 1.722f, 12.943f, 1.263f)
                    horizontalLineTo(10.955f)
                    curveTo(10.725f, 1.728f, 10.233f, 2.962f, 9.839f, 4.025f)
                    lineTo(9.761f, 4.235f)
                    lineTo(7.954f, 4.969f)
                    lineTo(7.759f, 4.886f)
                    curveTo(6.677f, 4.426f, 5.398f, 3.917f, 4.899f, 3.76f)
                    lineTo(3.503f, 5.128f)
                    curveTo(3.678f, 5.62f, 4.219f, 6.824f, 4.703f, 7.84f)
                    lineTo(4.802f, 8.047f)
                    lineTo(4.048f, 9.835f)
                    lineTo(3.846f, 9.914f)
                    curveTo(2.757f, 10.333f, 1.495f, 10.851f, 1.023f, 11.087f)
                    verticalLineTo(13.01f)
                    curveTo(1.5f, 13.236f, 2.758f, 13.716f, 3.842f, 14.102f)
                    lineTo(4.053f, 14.179f)
                    lineTo(4.807f, 15.964f)
                    lineTo(4.717f, 16.166f)
                    curveTo(4.253f, 17.212f, 3.737f, 18.446f, 3.571f, 18.943f)
                    lineTo(4.976f, 20.318f)
                    curveTo(5.427f, 20.159f, 6.693f, 19.616f, 7.763f, 19.127f)
                    lineTo(7.963f, 19.036f)
                    lineTo(9.771f, 19.771f)
                    lineTo(9.852f, 19.972f)
                    curveTo(10.282f, 21.041f, 10.812f, 22.278f, 11.052f, 22.738f)
                    close()
                    moveTo(12.0f, 16.116f)
                    curveTo(9.686f, 16.116f, 7.803f, 14.269f, 7.803f, 12.0f)
                    curveTo(7.803f, 9.731f, 9.686f, 7.886f, 12.0f, 7.886f)
                    curveTo(14.312f, 7.886f, 16.191f, 9.732f, 16.191f, 12.0f)
                    curveTo(16.191f, 14.269f, 14.312f, 16.116f, 12.0f, 16.116f)
                    close()
                    moveTo(12.0f, 8.908f)
                    curveTo(10.249f, 8.908f, 8.826f, 10.295f, 8.826f, 12.0f)
                    curveTo(8.826f, 13.705f, 10.248f, 15.094f, 12.0f, 15.094f)
                    curveTo(13.748f, 15.094f, 15.17f, 13.705f, 15.17f, 12.0f)
                    curveTo(15.17f, 10.295f, 13.748f, 8.908f, 12.0f, 8.908f)
                    close()
                }
            }
        }
        .build()
        return _settings!!
    }

private var _settings: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = settingsIcon, contentDescription = "")
    }
}
