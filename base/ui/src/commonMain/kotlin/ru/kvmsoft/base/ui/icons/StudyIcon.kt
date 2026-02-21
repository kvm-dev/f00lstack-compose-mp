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

public val StudyIcon: ImageVector
    get() {
        if (_studyIcon != null) {
            return _studyIcon!!
        }
        _studyIcon = Builder(name = "StudyIcon", defaultWidth = 83.0.dp, defaultHeight = 88.0.dp,
                viewportWidth = 83.0f, viewportHeight = 88.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFF01AFF9), 1.0f to Color(0xFF0A0672), start =
                    Offset(62.0f,83.0f), end = Offset(25.5f,-24.0f)), stroke = null, strokeLineWidth
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
            path(fill = SolidColor(Color(0xFF0EC1A9)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(46.0f, 46.0f)
                moveToRelative(-16.0f, 0.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, true, true, 32.0f, 0.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, true, true, -32.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(47.5576f, 27.4771f)
                curveTo(47.628f, 27.4354f, 47.6875f, 27.4332f, 47.7656f, 27.4829f)
                lineTo(48.0576f, 27.6685f)
                verticalLineTo(27.6694f)
                curveTo(48.162f, 27.7363f, 48.2836f, 27.8956f, 48.3535f, 28.1558f)
                curveTo(48.4214f, 28.4087f, 48.4243f, 28.7039f, 48.3467f, 28.9722f)
                curveTo(48.223f, 29.3989f, 48.0045f, 29.4702f, 47.9482f, 29.4702f)
                curveTo(47.9241f, 29.4702f, 47.8884f, 29.4641f, 47.8398f, 29.4331f)
                lineTo(47.5488f, 29.2476f)
                curveTo(47.4443f, 29.1808f, 47.3219f, 29.0218f, 47.252f, 28.7612f)
                curveTo(47.1925f, 28.5396f, 47.1836f, 28.2855f, 47.2344f, 28.0454f)
                lineTo(47.2598f, 27.9438f)
                curveTo(47.3385f, 27.6721f, 47.4671f, 27.5307f, 47.5576f, 27.4771f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 2.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(48.6475f, 49.3086f)
                curveTo(48.6474f, 49.5243f, 48.5859f, 49.6834f, 48.5361f, 49.7559f)
                curveTo(45.7082f, 53.87f, 42.0712f, 56.0f, 38.3398f, 56.0f)
                curveTo(34.6085f, 56.0f, 30.9715f, 53.8701f, 28.1436f, 49.7559f)
                curveTo(28.0938f, 49.6835f, 28.0323f, 49.5242f, 28.0322f, 49.3086f)
                verticalLineTo(49.1455f)
                lineTo(28.1367f, 49.2891f)
                curveTo(30.9154f, 53.1053f, 34.5751f, 55.1201f, 38.3398f, 55.1201f)
                curveTo(42.1046f, 55.1201f, 45.7642f, 53.1053f, 48.543f, 49.2891f)
                lineTo(48.6465f, 49.1455f)
                lineTo(48.6475f, 49.3086f)
                close()
                moveTo(53.7773f, 46.2705f)
                lineTo(54.1611f, 47.3906f)
                curveTo(54.0858f, 47.2271f, 54.01f, 47.0436f, 53.9404f, 46.8398f)
                curveTo(53.8664f, 46.6229f, 53.803f, 46.3971f, 53.7461f, 46.1719f)
                curveTo(53.757f, 46.2055f, 53.7665f, 46.2388f, 53.7773f, 46.2705f)
                close()
                moveTo(55.7002f, 46.1719f)
                curveTo(55.6433f, 46.397f, 55.5809f, 46.623f, 55.5068f, 46.8398f)
                curveTo(55.4372f, 47.0437f, 55.3606f, 47.227f, 55.2852f, 47.3906f)
                lineTo(55.6699f, 46.2705f)
                curveTo(55.6807f, 46.239f, 55.6894f, 46.2053f, 55.7002f, 46.1719f)
                close()
                moveTo(44.8242f, 26.1992f)
                curveTo(44.7915f, 26.1783f, 44.8581f, 26.2107f, 44.9072f, 26.3936f)
                curveTo(44.9526f, 26.5625f, 44.9536f, 26.7653f, 44.9023f, 26.9424f)
                curveTo(44.9004f, 26.949f, 44.8965f, 26.9547f, 44.8945f, 26.9609f)
                lineTo(38.8779f, 23.1211f)
                lineTo(38.3398f, 22.7773f)
                lineTo(37.8018f, 23.1211f)
                lineTo(23.8389f, 32.0322f)
                lineTo(22.5176f, 32.875f)
                lineTo(23.8389f, 33.7178f)
                lineTo(37.8018f, 42.6299f)
                lineTo(38.3398f, 42.9727f)
                lineTo(38.8779f, 42.6299f)
                lineTo(50.6172f, 35.1377f)
                lineTo(53.5049f, 33.2939f)
                horizontalLineTo(38.4785f)
                curveTo(38.4341f, 33.2151f, 38.3838f, 33.0714f, 38.3838f, 32.875f)
                curveTo(38.3838f, 32.6781f, 38.435f, 32.5347f, 38.4795f, 32.4561f)
                horizontalLineTo(54.584f)
                curveTo(54.6285f, 32.5347f, 54.6796f, 32.6781f, 54.6797f, 32.875f)
                verticalLineTo(33.2607f)
                lineTo(53.2295f, 34.1875f)
                lineTo(49.1084f, 36.8174f)
                lineTo(48.7344f, 37.0557f)
                lineTo(47.1973f, 38.0371f)
                lineTo(38.3398f, 43.6895f)
                lineTo(22.127f, 33.3428f)
                curveTo(22.1217f, 33.3371f, 22.0984f, 33.3111f, 22.0713f, 33.25f)
                curveTo(22.0313f, 33.1597f, 22.0f, 33.0289f, 22.0f, 32.875f)
                curveTo(22.0f, 32.721f, 22.0312f, 32.5903f, 22.0713f, 32.5f)
                curveTo(22.1051f, 32.4237f, 22.1323f, 32.4022f, 22.127f, 32.4062f)
                lineTo(38.3389f, 22.0596f)
                lineTo(44.8242f, 26.1992f)
                close()
                moveTo(55.1113f, 41.8701f)
                curveTo(55.4424f, 42.0986f, 55.7919f, 42.6345f, 55.9336f, 43.3926f)
                curveTo(55.8988f, 43.3166f, 55.858f, 43.2424f, 55.8105f, 43.1719f)
                curveTo(55.6473f, 42.9295f, 55.347f, 42.6524f, 54.916f, 42.5869f)
                lineTo(54.7236f, 42.5723f)
                curveTo(54.1887f, 42.5723f, 53.8233f, 42.895f, 53.6367f, 43.1719f)
                curveTo(53.5891f, 43.2426f, 53.5476f, 43.3164f, 53.5127f, 43.3926f)
                curveTo(53.6544f, 42.6343f, 54.0048f, 42.0985f, 54.3359f, 41.8701f)
                lineTo(54.7236f, 41.6025f)
                lineTo(55.1113f, 41.8701f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(27.9893f, 40.4873f)
                curveTo(28.0365f, 40.4873f, 28.1387f, 40.5159f, 28.251f, 40.6826f)
                curveTo(28.3611f, 40.8463f, 28.4453f, 41.1007f, 28.4453f, 41.4062f)
                verticalLineTo(41.8789f)
                curveTo(28.4453f, 42.1845f, 28.3611f, 42.4388f, 28.251f, 42.6025f)
                curveTo(28.1387f, 42.7693f, 28.0365f, 42.7978f, 27.9893f, 42.7979f)
                curveTo(27.942f, 42.7979f, 27.8399f, 42.7693f, 27.7275f, 42.6025f)
                curveTo(27.6174f, 42.4388f, 27.5332f, 42.1845f, 27.5332f, 41.8789f)
                verticalLineTo(41.4062f)
                curveTo(27.5332f, 41.1007f, 27.6174f, 40.8463f, 27.7275f, 40.6826f)
                curveTo(27.8399f, 40.5159f, 27.942f, 40.4873f, 27.9893f, 40.4873f)
                close()
            }
        }
        .build()
        return _studyIcon!!
    }

private var _studyIcon: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = StudyIcon, contentDescription = "")
    }
}
