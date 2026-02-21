package ru.kvmsoft.base.ui.icons.achievements

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
import ru.kvmsoft.base.ui.icons.mainIcon

public val Foolstaker: ImageVector
    get() {
        if (_foolstaker != null) {
            return _foolstaker!!
        }
        _foolstaker = Builder(name = "Foolstaker", defaultWidth = 160.0.dp, defaultHeight =
                141.0.dp, viewportWidth = 160.0f, viewportHeight = 141.0f).apply {
            path(fill = SolidColor(Color(0xFF0EC1A9)), stroke = SolidColor(Color(0xFFF1F1F5)),
                    fillAlpha = 0.26f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 0.5f)
                lineTo(144.0f, 0.5f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 159.5f, 16.0f)
                lineTo(159.5f, 125.0f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 144.0f, 140.5f)
                lineTo(16.0f, 140.5f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 0.5f, 125.0f)
                lineTo(0.5f, 16.0f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 16.0f, 0.5f)
                close()
            }
            path(fill = linearGradient(0.0f to Color(0xFFF4D03F), 1.0f to Color(0xFF16A085), start =
                    Offset(80.0f,20.0f), end = Offset(80.0f,84.0f)), stroke = null, strokeLineWidth
                    = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(66.0f, 20.0f)
                lineTo(94.0f, 20.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 112.0f, 38.0f)
                lineTo(112.0f, 66.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 94.0f, 84.0f)
                lineTo(66.0f, 84.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 48.0f, 66.0f)
                lineTo(48.0f, 38.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 66.0f, 20.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(65.691f, 23.692f)
                lineTo(94.307f, 23.692f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 108.307f, 37.692f)
                lineTo(108.307f, 66.307f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 94.307f, 80.307f)
                lineTo(65.691f, 80.307f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 51.691f, 66.307f)
                lineTo(51.691f, 37.692f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 65.691f, 23.692f)
                close()
            }
            group {
                path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(92.074f, 50.297f)
                    lineTo(94.058f, 48.312f)
                    curveTo(95.314f, 47.056f, 95.314f, 45.013f, 94.058f, 43.756f)
                    curveTo(93.673f, 43.371f, 93.21f, 43.1f, 92.715f, 42.951f)
                    curveTo(93.12f, 42.401f, 93.339f, 41.74f, 93.339f, 41.045f)
                    curveTo(93.339f, 40.184f, 93.003f, 39.375f, 92.395f, 38.767f)
                    curveTo(91.786f, 38.158f, 90.977f, 37.823f, 90.117f, 37.823f)
                    curveTo(90.081f, 37.823f, 90.045f, 37.824f, 90.008f, 37.825f)
                    curveTo(90.037f, 36.965f, 89.723f, 36.096f, 89.068f, 35.44f)
                    curveTo(88.413f, 34.785f, 87.542f, 34.472f, 86.684f, 34.5f)
                    curveTo(86.685f, 34.464f, 86.686f, 34.428f, 86.686f, 34.392f)
                    curveTo(86.686f, 33.531f, 86.35f, 32.722f, 85.742f, 32.114f)
                    curveTo(84.486f, 30.858f, 82.442f, 30.858f, 81.186f, 32.114f)
                    lineTo(80.5f, 32.8f)
                    lineTo(79.814f, 32.114f)
                    curveTo(79.206f, 31.505f, 78.397f, 31.17f, 77.536f, 31.17f)
                    curveTo(76.676f, 31.17f, 75.867f, 31.505f, 75.258f, 32.114f)
                    curveTo(74.603f, 32.769f, 74.29f, 33.639f, 74.319f, 34.499f)
                    curveTo(74.283f, 34.498f, 74.246f, 34.497f, 74.21f, 34.497f)
                    curveTo(73.35f, 34.497f, 72.54f, 34.832f, 71.932f, 35.44f)
                    curveTo(71.276f, 36.096f, 70.964f, 36.965f, 70.992f, 37.826f)
                    curveTo(70.956f, 37.825f, 70.92f, 37.823f, 70.883f, 37.823f)
                    curveTo(70.023f, 37.823f, 69.213f, 38.158f, 68.605f, 38.767f)
                    curveTo(67.997f, 39.375f, 67.662f, 40.184f, 67.662f, 41.045f)
                    curveTo(67.662f, 41.74f, 67.88f, 42.401f, 68.285f, 42.95f)
                    curveTo(67.783f, 43.101f, 67.323f, 43.375f, 66.942f, 43.756f)
                    curveTo(65.689f, 45.01f, 65.686f, 47.047f, 66.933f, 48.304f)
                    curveTo(66.937f, 48.307f, 66.94f, 48.31f, 66.943f, 48.313f)
                    lineTo(68.93f, 50.3f)
                    curveTo(68.932f, 50.303f, 68.935f, 50.305f, 68.938f, 50.308f)
                    curveTo(69.057f, 50.428f, 69.185f, 50.536f, 69.318f, 50.634f)
                    lineTo(68.731f, 51.222f)
                    curveTo(68.159f, 51.793f, 67.868f, 52.572f, 67.911f, 53.414f)
                    curveTo(67.952f, 54.223f, 68.3f, 54.993f, 68.891f, 55.583f)
                    lineTo(72.251f, 58.944f)
                    curveTo(72.875f, 59.567f, 73.693f, 59.879f, 74.512f, 59.879f)
                    curveTo(75.331f, 59.879f, 76.15f, 59.567f, 76.773f, 58.944f)
                    lineTo(78.335f, 57.382f)
                    curveTo(79.048f, 57.535f, 79.774f, 57.612f, 80.5f, 57.612f)
                    curveTo(81.226f, 57.612f, 81.952f, 57.535f, 82.665f, 57.382f)
                    lineTo(84.227f, 58.944f)
                    curveTo(84.85f, 59.567f, 85.669f, 59.879f, 86.488f, 59.879f)
                    curveTo(87.306f, 59.879f, 88.125f, 59.567f, 88.748f, 58.944f)
                    lineTo(92.109f, 55.583f)
                    curveTo(93.356f, 54.337f, 93.497f, 52.45f, 92.425f, 51.377f)
                    lineTo(91.709f, 50.661f)
                    lineTo(92.062f, 50.308f)
                    curveTo(92.066f, 50.304f, 92.07f, 50.3f, 92.074f, 50.297f)
                    close()
                    moveTo(76.488f, 33.343f)
                    curveTo(76.768f, 33.063f, 77.14f, 32.909f, 77.536f, 32.909f)
                    curveTo(77.932f, 32.909f, 78.305f, 33.063f, 78.585f, 33.343f)
                    lineTo(81.246f, 36.004f)
                    curveTo(81.824f, 36.583f, 81.824f, 37.523f, 81.246f, 38.102f)
                    curveTo(80.966f, 38.382f, 80.593f, 38.536f, 80.198f, 38.536f)
                    horizontalLineTo(80.197f)
                    curveTo(79.801f, 38.536f, 79.429f, 38.382f, 79.149f, 38.102f)
                    curveTo(79.148f, 38.101f, 79.148f, 38.101f, 79.148f, 38.1f)
                    lineTo(76.488f, 35.441f)
                    curveTo(76.486f, 35.439f, 76.484f, 35.437f, 76.482f, 35.435f)
                    curveTo(75.91f, 34.856f, 75.912f, 33.919f, 76.488f, 33.343f)
                    close()
                    moveTo(73.157f, 38.763f)
                    curveTo(72.583f, 38.184f, 72.584f, 37.246f, 73.161f, 36.67f)
                    curveTo(73.441f, 36.39f, 73.814f, 36.236f, 74.21f, 36.236f)
                    curveTo(74.606f, 36.236f, 74.978f, 36.389f, 75.258f, 36.669f)
                    curveTo(75.258f, 36.669f, 75.258f, 36.67f, 75.258f, 36.67f)
                    curveTo(75.259f, 36.671f, 75.26f, 36.672f, 75.261f, 36.673f)
                    lineTo(77.919f, 39.33f)
                    curveTo(77.92f, 39.332f, 77.922f, 39.334f, 77.924f, 39.336f)
                    lineTo(78.585f, 39.996f)
                    curveTo(78.865f, 40.276f, 79.019f, 40.649f, 79.019f, 41.045f)
                    curveTo(79.019f, 41.441f, 78.865f, 41.813f, 78.585f, 42.093f)
                    curveTo(78.305f, 42.373f, 77.932f, 42.528f, 77.536f, 42.528f)
                    curveTo(77.14f, 42.528f, 76.768f, 42.373f, 76.488f, 42.093f)
                    curveTo(76.484f, 42.09f, 76.481f, 42.086f, 76.477f, 42.083f)
                    lineTo(75.825f, 41.431f)
                    curveTo(75.824f, 41.43f, 75.824f, 41.429f, 75.823f, 41.428f)
                    lineTo(73.161f, 38.767f)
                    lineTo(73.161f, 38.767f)
                    curveTo(73.16f, 38.765f, 73.158f, 38.764f, 73.157f, 38.763f)
                    close()
                    moveTo(69.835f, 39.996f)
                    curveTo(70.115f, 39.716f, 70.487f, 39.562f, 70.883f, 39.562f)
                    curveTo(71.279f, 39.562f, 71.652f, 39.716f, 71.932f, 39.996f)
                    lineTo(74.596f, 42.66f)
                    curveTo(75.171f, 43.239f, 75.17f, 44.177f, 74.593f, 44.755f)
                    curveTo(74.313f, 45.035f, 73.94f, 45.189f, 73.544f, 45.189f)
                    curveTo(73.148f, 45.189f, 72.776f, 45.035f, 72.496f, 44.754f)
                    curveTo(72.493f, 44.751f, 72.489f, 44.748f, 72.486f, 44.744f)
                    lineTo(69.843f, 42.102f)
                    curveTo(69.84f, 42.099f, 69.838f, 42.096f, 69.835f, 42.093f)
                    curveTo(69.555f, 41.813f, 69.401f, 41.441f, 69.401f, 41.045f)
                    curveTo(69.4f, 40.649f, 69.555f, 40.276f, 69.835f, 39.996f)
                    close()
                    moveTo(68.18f, 47.092f)
                    curveTo(68.177f, 47.088f, 68.174f, 47.085f, 68.171f, 47.082f)
                    curveTo(67.593f, 46.504f, 67.594f, 45.564f, 68.172f, 44.986f)
                    curveTo(68.452f, 44.706f, 68.824f, 44.552f, 69.22f, 44.552f)
                    curveTo(69.616f, 44.552f, 69.989f, 44.706f, 70.269f, 44.986f)
                    lineTo(72.265f, 46.982f)
                    curveTo(72.843f, 47.56f, 72.843f, 48.501f, 72.265f, 49.079f)
                    curveTo(71.985f, 49.359f, 71.612f, 49.513f, 71.216f, 49.513f)
                    horizontalLineTo(71.216f)
                    curveTo(71.143f, 49.513f, 71.072f, 49.508f, 71.001f, 49.498f)
                    curveTo(70.995f, 49.496f, 70.99f, 49.496f, 70.985f, 49.495f)
                    curveTo(70.679f, 49.447f, 70.398f, 49.306f, 70.174f, 49.085f)
                    curveTo(70.172f, 49.083f, 70.169f, 49.081f, 70.167f, 49.078f)
                    lineTo(68.18f, 47.092f)
                    close()
                    moveTo(78.288f, 55.584f)
                    curveTo(78.281f, 55.582f, 78.273f, 55.581f, 78.266f, 55.579f)
                    curveTo(78.248f, 55.575f, 78.231f, 55.571f, 78.214f, 55.568f)
                    curveTo(78.201f, 55.566f, 78.188f, 55.564f, 78.175f, 55.563f)
                    curveTo(78.161f, 55.561f, 78.146f, 55.559f, 78.132f, 55.558f)
                    curveTo(78.116f, 55.557f, 78.101f, 55.556f, 78.086f, 55.556f)
                    curveTo(78.074f, 55.555f, 78.061f, 55.555f, 78.049f, 55.555f)
                    curveTo(78.033f, 55.556f, 78.016f, 55.556f, 78.0f, 55.558f)
                    curveTo(77.989f, 55.559f, 77.977f, 55.56f, 77.965f, 55.561f)
                    curveTo(77.949f, 55.563f, 77.933f, 55.565f, 77.918f, 55.568f)
                    curveTo(77.905f, 55.57f, 77.893f, 55.572f, 77.881f, 55.575f)
                    curveTo(77.866f, 55.578f, 77.852f, 55.581f, 77.838f, 55.585f)
                    curveTo(77.825f, 55.589f, 77.811f, 55.593f, 77.798f, 55.597f)
                    curveTo(77.785f, 55.601f, 77.773f, 55.606f, 77.76f, 55.61f)
                    curveTo(77.746f, 55.616f, 77.732f, 55.621f, 77.718f, 55.627f)
                    curveTo(77.706f, 55.632f, 77.695f, 55.638f, 77.684f, 55.643f)
                    curveTo(77.67f, 55.65f, 77.656f, 55.657f, 77.642f, 55.665f)
                    curveTo(77.631f, 55.671f, 77.62f, 55.677f, 77.609f, 55.684f)
                    curveTo(77.596f, 55.692f, 77.584f, 55.7f, 77.572f, 55.708f)
                    curveTo(77.559f, 55.717f, 77.547f, 55.726f, 77.535f, 55.735f)
                    curveTo(77.525f, 55.743f, 77.516f, 55.75f, 77.506f, 55.758f)
                    curveTo(77.492f, 55.77f, 77.478f, 55.782f, 77.465f, 55.795f)
                    curveTo(77.46f, 55.8f, 77.454f, 55.804f, 77.449f, 55.809f)
                    lineTo(75.544f, 57.715f)
                    curveTo(74.975f, 58.284f, 74.05f, 58.284f, 73.481f, 57.715f)
                    lineTo(70.12f, 54.354f)
                    curveTo(69.835f, 54.069f, 69.667f, 53.703f, 69.648f, 53.325f)
                    curveTo(69.63f, 52.981f, 69.741f, 52.67f, 69.96f, 52.451f)
                    lineTo(71.161f, 51.25f)
                    curveTo(71.179f, 51.251f, 71.198f, 51.252f, 71.216f, 51.252f)
                    curveTo(71.216f, 51.252f, 71.216f, 51.252f, 71.216f, 51.252f)
                    curveTo(72.077f, 51.252f, 72.886f, 50.917f, 73.494f, 50.308f)
                    curveTo(74.425f, 49.377f, 74.665f, 48.013f, 74.215f, 46.857f)
                    curveTo(74.82f, 46.73f, 75.376f, 46.431f, 75.823f, 45.984f)
                    curveTo(76.334f, 45.473f, 76.637f, 44.831f, 76.732f, 44.165f)
                    curveTo(76.992f, 44.231f, 77.261f, 44.266f, 77.536f, 44.266f)
                    curveTo(77.536f, 44.266f, 77.536f, 44.266f, 77.536f, 44.266f)
                    curveTo(78.397f, 44.266f, 79.206f, 43.931f, 79.814f, 43.323f)
                    curveTo(80.423f, 42.714f, 80.758f, 41.905f, 80.758f, 41.045f)
                    curveTo(80.758f, 40.77f, 80.723f, 40.501f, 80.657f, 40.242f)
                    curveTo(81.343f, 40.144f, 81.977f, 39.83f, 82.475f, 39.331f)
                    curveTo(83.731f, 38.075f, 83.731f, 36.031f, 82.476f, 34.775f)
                    lineTo(81.729f, 34.029f)
                    lineTo(82.415f, 33.343f)
                    curveTo(82.994f, 32.765f, 83.934f, 32.765f, 84.512f, 33.343f)
                    curveTo(84.792f, 33.623f, 84.947f, 33.996f, 84.947f, 34.392f)
                    curveTo(84.947f, 34.788f, 84.792f, 35.16f, 84.512f, 35.44f)
                    curveTo(84.343f, 35.61f, 84.258f, 35.832f, 84.258f, 36.055f)
                    curveTo(84.258f, 36.277f, 84.342f, 36.5f, 84.512f, 36.67f)
                    curveTo(84.852f, 37.009f, 85.402f, 37.009f, 85.742f, 36.67f)
                    curveTo(86.32f, 36.092f, 87.26f, 36.091f, 87.839f, 36.67f)
                    curveTo(88.417f, 37.248f, 88.417f, 38.189f, 87.839f, 38.767f)
                    curveTo(87.669f, 38.937f, 87.584f, 39.159f, 87.584f, 39.382f)
                    curveTo(87.584f, 39.604f, 87.669f, 39.826f, 87.839f, 39.996f)
                    curveTo(88.178f, 40.336f, 88.729f, 40.336f, 89.068f, 39.996f)
                    curveTo(89.348f, 39.716f, 89.721f, 39.562f, 90.117f, 39.562f)
                    curveTo(90.513f, 39.562f, 90.885f, 39.716f, 91.165f, 39.996f)
                    curveTo(91.446f, 40.276f, 91.6f, 40.649f, 91.6f, 41.045f)
                    curveTo(91.6f, 41.436f, 91.45f, 41.803f, 91.176f, 42.082f)
                    curveTo(91.173f, 42.086f, 91.169f, 42.09f, 91.165f, 42.094f)
                    lineTo(89.918f, 43.341f)
                    curveTo(89.607f, 43.651f, 89.577f, 44.144f, 89.847f, 44.49f)
                    lineTo(89.892f, 44.548f)
                    curveTo(90.162f, 44.893f, 90.646f, 44.984f, 91.022f, 44.759f)
                    curveTo(91.605f, 44.412f, 92.348f, 44.505f, 92.828f, 44.986f)
                    curveTo(93.407f, 45.564f, 93.407f, 46.505f, 92.828f, 47.083f)
                    lineTo(90.833f, 49.078f)
                    curveTo(90.829f, 49.082f, 90.825f, 49.086f, 90.822f, 49.09f)
                    lineTo(86.538f, 53.373f)
                    curveTo(84.389f, 55.522f, 81.228f, 56.369f, 78.288f, 55.584f)
                    close()
                    moveTo(91.196f, 52.607f)
                    curveTo(91.577f, 52.988f, 91.429f, 53.805f, 90.88f, 54.354f)
                    lineTo(87.519f, 57.715f)
                    curveTo(86.95f, 58.284f, 86.025f, 58.284f, 85.456f, 57.715f)
                    lineTo(84.531f, 56.79f)
                    curveTo(85.733f, 56.277f, 86.834f, 55.536f, 87.768f, 54.603f)
                    lineTo(90.479f, 51.891f)
                    lineTo(91.196f, 52.607f)
                    close()
                }
            }
        }
        .build()
        return _foolstaker!!
    }

private var _foolstaker: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Foolstaker, contentDescription = "")
    }
}

