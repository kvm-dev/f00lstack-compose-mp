package ru.kvmsoft.base.ui.images

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

public val notFoundImageHorizontal: ImageVector
    get() {
        if (_notFoundHorizontal != null) {
            return _notFoundHorizontal!!
        }
        _notFoundHorizontal = Builder(name = "NotFoundHorizontal", defaultWidth = 351.0.dp,
                defaultHeight = 180.0.dp, viewportWidth = 351.0f, viewportHeight = 180.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFFD3CABE), 0.730869f to Color(0xFF554C40),
                    start = Offset(175.5f,0.0f), end = Offset(175.5f,180.0f)), stroke = null,
                    fillAlpha = 0.9f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin =
                    Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(351.0f)
                verticalLineToRelative(180.0f)
                horizontalLineToRelative(-351.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF0EC1A9)),
                    strokeAlpha = 0.26f, strokeLineWidth = 1.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.5f, 0.5f)
                horizontalLineToRelative(350.0f)
                verticalLineToRelative(179.0f)
                horizontalLineToRelative(-350.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.824f, 179.586f)
                curveTo(63.525f, 179.015f, 62.727f, 177.638f, 63.086f, 176.587f)
                curveTo(63.236f, 176.152f, 64.098f, 173.736f, 65.002f, 171.219f)
                curveTo(66.921f, 165.876f, 68.423f, 161.065f, 69.741f, 156.031f)
                curveTo(70.782f, 152.059f, 72.61f, 143.692f, 72.61f, 142.901f)
                verticalLineTo(142.398f)
                lineTo(69.571f, 142.516f)
                curveTo(66.72f, 142.626f, 66.457f, 142.604f, 65.344f, 142.171f)
                curveTo(63.8f, 141.57f, 63.082f, 140.653f, 63.236f, 139.479f)
                curveTo(63.328f, 138.778f, 63.927f, 137.94f, 66.23f, 135.292f)
                curveTo(71.863f, 128.815f, 73.948f, 125.303f, 74.617f, 121.164f)
                curveTo(75.118f, 118.057f, 75.135f, 118.044f, 80.789f, 116.512f)
                curveTo(87.937f, 114.575f, 94.59f, 112.461f, 101.654f, 109.884f)
                curveTo(122.754f, 102.184f, 140.027f, 93.004f, 166.399f, 75.476f)
                lineTo(171.165f, 72.308f)
                lineTo(171.334f, 70.599f)
                curveTo(171.426f, 69.66f, 171.688f, 66.175f, 171.916f, 62.855f)
                curveTo(172.144f, 59.535f, 172.672f, 52.042f, 173.091f, 46.206f)
                lineTo(173.851f, 35.593f)
                lineTo(173.286f, 35.013f)
                curveTo(172.886f, 34.603f, 172.69f, 34.049f, 172.617f, 33.12f)
                curveTo(172.528f, 31.979f, 172.606f, 31.693f, 173.217f, 30.942f)
                curveTo(174.942f, 28.821f, 178.997f, 28.346f, 181.494f, 29.972f)
                curveTo(182.824f, 30.838f, 183.381f, 31.718f, 183.381f, 32.953f)
                curveTo(183.381f, 33.913f, 182.669f, 35.309f, 182.034f, 35.591f)
                curveTo(181.72f, 35.731f, 181.683f, 37.111f, 181.934f, 39.253f)
                lineTo(182.107f, 40.732f)
                lineTo(183.622f, 40.844f)
                curveTo(186.759f, 41.076f, 189.778f, 41.575f, 191.215f, 42.097f)
                curveTo(193.164f, 42.807f, 193.918f, 43.604f, 193.918f, 44.954f)
                curveTo(193.918f, 45.77f, 194.059f, 46.102f, 194.606f, 46.57f)
                curveTo(196.312f, 48.031f, 200.527f, 48.757f, 205.026f, 48.364f)
                curveTo(206.51f, 48.234f, 208.296f, 48.003f, 208.994f, 47.85f)
                curveTo(210.739f, 47.469f, 211.132f, 47.495f, 211.897f, 48.047f)
                curveTo(213.024f, 48.859f, 212.802f, 49.536f, 210.981f, 50.849f)
                curveTo(208.989f, 52.285f, 207.433f, 53.056f, 204.608f, 54.01f)
                curveTo(201.756f, 54.974f, 198.431f, 55.549f, 195.706f, 55.551f)
                curveTo(191.56f, 55.554f, 190.147f, 54.857f, 189.888f, 52.684f)
                lineTo(189.731f, 51.366f)
                lineTo(188.313f, 51.307f)
                curveTo(186.865f, 51.247f, 183.181f, 51.543f, 182.906f, 51.741f)
                curveTo(182.822f, 51.801f, 183.04f, 56.558f, 183.391f, 62.312f)
                lineTo(184.029f, 72.773f)
                lineTo(187.063f, 75.116f)
                curveTo(190.203f, 77.541f, 198.518f, 83.254f, 203.239f, 86.23f)
                curveTo(223.128f, 98.766f, 245.375f, 108.425f, 272.134f, 116.14f)
                curveTo(275.105f, 116.997f, 277.762f, 117.845f, 278.037f, 118.024f)
                curveTo(278.844f, 118.55f, 279.207f, 119.24f, 279.393f, 120.599f)
                curveTo(279.728f, 123.054f, 280.871f, 125.389f, 284.297f, 130.619f)
                curveTo(286.237f, 133.58f, 287.785f, 136.367f, 288.327f, 137.873f)
                curveTo(289.52f, 141.192f, 287.954f, 142.581f, 283.008f, 142.59f)
                curveTo(281.3f, 142.593f, 280.644f, 142.662f, 280.644f, 142.838f)
                curveTo(280.645f, 142.972f, 280.833f, 144.264f, 281.064f, 145.71f)
                curveTo(282.656f, 155.683f, 284.773f, 164.665f, 287.699f, 173.861f)
                lineTo(288.818f, 177.379f)
                lineTo(288.262f, 178.286f)
                curveTo(287.916f, 178.849f, 287.365f, 179.342f, 286.809f, 179.586f)
                curveTo(285.913f, 179.98f, 285.853f, 179.98f, 175.817f, 179.98f)
                curveTo(65.78f, 179.98f, 65.72f, 179.98f, 64.824f, 179.586f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(78.893f, 169.418f)
                curveTo(80.032f, 165.214f, 82.303f, 156.83f, 83.941f, 150.786f)
                curveTo(85.579f, 144.742f, 86.882f, 139.769f, 86.836f, 139.736f)
                curveTo(86.79f, 139.703f, 86.002f, 139.888f, 85.084f, 140.147f)
                curveTo(83.524f, 140.588f, 79.628f, 141.438f, 77.946f, 141.705f)
                curveTo(77.361f, 141.798f, 77.203f, 141.934f, 77.203f, 142.345f)
                curveTo(77.203f, 143.902f, 74.299f, 156.072f, 72.449f, 162.262f)
                curveTo(71.405f, 165.758f, 68.522f, 174.145f, 67.747f, 175.941f)
                lineTo(67.264f, 177.061f)
                horizontalLineTo(72.044f)
                horizontalLineTo(76.824f)
                lineTo(78.893f, 169.418f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.504f, 176.428f)
                curveTo(96.583f, 176.08f, 97.436f, 171.195f, 98.397f, 165.572f)
                curveTo(99.359f, 159.949f, 100.648f, 152.414f, 101.262f, 148.827f)
                curveTo(102.312f, 142.691f, 102.35f, 142.294f, 101.906f, 142.109f)
                curveTo(99.47f, 141.095f, 97.142f, 139.78f, 95.523f, 138.504f)
                lineTo(93.58f, 136.974f)
                lineTo(92.888f, 137.323f)
                curveTo(92.508f, 137.515f, 91.255f, 138.043f, 90.103f, 138.496f)
                curveTo(88.951f, 138.949f, 88.009f, 139.363f, 88.009f, 139.417f)
                curveTo(88.009f, 139.51f, 86.949f, 143.431f, 81.388f, 163.917f)
                curveTo(80.137f, 168.522f, 78.825f, 173.363f, 78.472f, 174.675f)
                lineTo(77.83f, 177.061f)
                horizontalLineTo(87.095f)
                horizontalLineTo(96.36f)
                lineTo(96.504f, 176.428f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(115.565f, 176.915f)
                curveTo(115.563f, 176.834f, 117.038f, 167.981f, 118.843f, 157.242f)
                curveTo(120.648f, 146.501f, 122.054f, 137.662f, 121.966f, 137.599f)
                curveTo(121.879f, 137.536f, 120.981f, 138.026f, 119.971f, 138.687f)
                curveTo(117.655f, 140.204f, 114.962f, 141.509f, 112.903f, 142.112f)
                curveTo(110.062f, 142.944f, 106.566f, 143.137f, 104.17f, 142.594f)
                curveTo(103.328f, 142.402f, 103.324f, 142.411f, 102.878f, 145.126f)
                curveTo(102.729f, 146.036f, 101.451f, 153.505f, 100.037f, 161.723f)
                curveTo(98.623f, 169.941f, 97.467f, 176.754f, 97.467f, 176.863f)
                curveTo(97.467f, 176.993f, 100.557f, 177.061f, 106.518f, 177.061f)
                curveTo(111.495f, 177.061f, 115.567f, 176.995f, 115.565f, 176.915f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(123.943f, 176.806f)
                curveTo(123.943f, 176.666f, 125.22f, 175.695f, 126.781f, 174.649f)
                curveTo(130.265f, 172.313f, 136.147f, 167.644f, 140.26f, 163.947f)
                lineTo(143.34f, 161.178f)
                lineTo(143.639f, 152.227f)
                curveTo(143.803f, 147.304f, 143.937f, 142.684f, 143.937f, 141.96f)
                lineTo(143.936f, 140.644f)
                lineTo(142.518f, 141.213f)
                curveTo(136.733f, 143.535f, 129.906f, 142.89f, 124.764f, 139.536f)
                curveTo(123.854f, 138.943f, 123.072f, 138.49f, 123.026f, 138.53f)
                curveTo(122.981f, 138.57f, 121.494f, 147.255f, 119.722f, 157.832f)
                lineTo(116.5f, 177.061f)
                horizontalLineTo(120.221f)
                curveTo(123.108f, 177.061f, 123.943f, 177.004f, 123.943f, 176.806f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(141.864f, 175.149f)
                curveTo(150.579f, 165.47f, 158.826f, 154.557f, 165.786f, 143.493f)
                lineTo(166.627f, 142.157f)
                lineTo(165.784f, 142.278f)
                curveTo(165.321f, 142.345f, 164.319f, 142.4f, 163.557f, 142.401f)
                lineTo(162.173f, 142.401f)
                lineTo(160.891f, 144.217f)
                curveTo(158.02f, 148.283f, 152.304f, 154.789f, 147.183f, 159.816f)
                curveTo(141.661f, 165.239f, 136.97f, 169.225f, 130.725f, 173.799f)
                lineTo(126.273f, 177.061f)
                horizontalLineTo(133.208f)
                horizontalLineTo(140.143f)
                lineTo(141.864f, 175.149f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(223.566f, 173.799f)
                curveTo(215.387f, 167.85f, 208.952f, 162.054f, 201.356f, 153.791f)
                curveTo(198.037f, 150.181f, 193.288f, 144.611f, 192.121f, 142.959f)
                curveTo(191.643f, 142.283f, 191.549f, 142.249f, 189.883f, 142.136f)
                curveTo(188.926f, 142.071f, 188.12f, 142.038f, 188.09f, 142.063f)
                curveTo(188.061f, 142.087f, 189.273f, 143.991f, 190.784f, 146.294f)
                curveTo(197.004f, 155.775f, 205.03f, 165.358f, 213.507f, 173.429f)
                curveTo(215.29f, 175.126f, 216.869f, 176.637f, 217.017f, 176.787f)
                curveTo(217.232f, 177.006f, 218.355f, 177.061f, 222.668f, 177.061f)
                horizontalLineTo(228.051f)
                lineTo(223.566f, 173.799f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(236.057f, 173.8f)
                curveTo(234.826f, 170.696f, 232.961f, 165.948f, 226.477f, 149.41f)
                curveTo(224.903f, 145.394f, 223.555f, 141.964f, 223.483f, 141.788f)
                curveTo(223.362f, 141.496f, 223.233f, 141.501f, 221.993f, 141.84f)
                curveTo(217.644f, 143.031f, 212.06f, 142.174f, 207.308f, 139.586f)
                curveTo(206.424f, 139.105f, 205.659f, 138.742f, 205.607f, 138.779f)
                curveTo(205.555f, 138.817f, 206.565f, 143.695f, 207.851f, 149.621f)
                lineTo(210.19f, 160.395f)
                lineTo(211.746f, 161.864f)
                curveTo(214.435f, 164.403f, 224.597f, 172.584f, 227.902f, 174.87f)
                lineTo(231.068f, 177.061f)
                horizontalLineTo(234.209f)
                lineTo(237.35f, 177.061f)
                lineTo(236.057f, 173.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(255.788f, 176.72f)
                curveTo(255.787f, 176.532f, 254.207f, 168.804f, 252.276f, 159.545f)
                curveTo(250.345f, 150.286f, 248.765f, 142.647f, 248.765f, 142.569f)
                curveTo(248.765f, 142.491f, 248.37f, 142.508f, 247.888f, 142.608f)
                curveTo(246.357f, 142.925f, 242.478f, 142.823f, 240.675f, 142.418f)
                curveTo(238.229f, 141.869f, 235.437f, 140.586f, 232.959f, 138.872f)
                lineTo(230.76f, 137.351f)
                lineTo(229.293f, 138.429f)
                curveTo(228.487f, 139.022f, 227.067f, 139.87f, 226.138f, 140.314f)
                curveTo(225.209f, 140.757f, 224.449f, 141.238f, 224.449f, 141.383f)
                curveTo(224.449f, 141.529f, 225.903f, 145.344f, 227.679f, 149.861f)
                curveTo(236.344f, 171.892f, 237.67f, 175.277f, 237.97f, 176.136f)
                lineTo(238.292f, 177.061f)
                horizontalLineTo(247.041f)
                curveTo(255.193f, 177.061f, 255.789f, 177.037f, 255.788f, 176.72f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(281.454f, 176.987f)
                curveTo(281.454f, 176.946f, 280.293f, 173.376f, 278.873f, 169.052f)
                curveTo(277.454f, 164.728f, 274.903f, 156.941f, 273.204f, 151.747f)
                curveTo(271.507f, 146.552f, 270.058f, 142.124f, 269.986f, 141.906f)
                curveTo(269.894f, 141.625f, 269.233f, 141.325f, 267.733f, 140.883f)
                curveTo(265.336f, 140.177f, 263.083f, 139.233f, 260.51f, 137.858f)
                lineTo(258.751f, 136.919f)
                lineTo(256.392f, 138.664f)
                curveTo(254.203f, 140.283f, 251.84f, 141.575f, 250.293f, 141.999f)
                curveTo(249.683f, 142.166f, 249.661f, 142.229f, 249.875f, 143.213f)
                curveTo(250.245f, 144.912f, 256.869f, 176.897f, 256.869f, 176.983f)
                curveTo(256.869f, 177.026f, 262.4f, 177.061f, 269.162f, 177.061f)
                curveTo(275.922f, 177.061f, 281.454f, 177.028f, 281.454f, 176.987f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(284.39f, 174.71f)
                curveTo(281.479f, 165.871f, 278.949f, 154.803f, 277.264f, 143.538f)
                lineTo(277.099f, 142.436f)
                lineTo(274.756f, 142.197f)
                curveTo(273.468f, 142.065f, 272.077f, 141.888f, 271.665f, 141.802f)
                curveTo(270.99f, 141.663f, 270.93f, 141.689f, 271.053f, 142.072f)
                curveTo(271.205f, 142.546f, 274.507f, 152.633f, 277.439f, 161.58f)
                curveTo(278.492f, 164.793f, 280.013f, 169.437f, 280.821f, 171.901f)
                curveTo(281.628f, 174.364f, 282.352f, 176.532f, 282.43f, 176.72f)
                curveTo(282.539f, 176.983f, 282.867f, 177.061f, 283.868f, 177.061f)
                horizontalLineTo(285.163f)
                lineTo(284.39f, 174.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(146.689f, 157.881f)
                curveTo(150.916f, 153.628f, 155.884f, 147.959f, 158.765f, 144.103f)
                curveTo(160.037f, 142.401f, 160.134f, 142.191f, 159.693f, 142.081f)
                curveTo(155.991f, 141.16f, 153.729f, 140.216f, 151.203f, 138.538f)
                lineTo(149.347f, 137.306f)
                lineTo(147.215f, 138.699f)
                lineTo(145.084f, 140.094f)
                lineTo(144.918f, 143.145f)
                curveTo(144.564f, 149.686f, 144.418f, 160.022f, 144.683f, 159.828f)
                curveTo(144.828f, 159.721f, 145.732f, 158.845f, 146.689f, 157.881f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(207.007f, 150.357f)
                curveTo(206.02f, 145.819f, 205.004f, 141.121f, 204.75f, 139.915f)
                curveTo(204.496f, 138.709f, 204.146f, 137.62f, 203.973f, 137.495f)
                curveTo(203.733f, 137.322f, 203.286f, 137.523f, 202.098f, 138.335f)
                curveTo(201.24f, 138.922f, 199.963f, 139.685f, 199.262f, 140.03f)
                curveTo(197.711f, 140.794f, 194.77f, 141.815f, 194.121f, 141.815f)
                curveTo(193.861f, 141.815f, 193.648f, 141.868f, 193.648f, 141.932f)
                curveTo(193.648f, 142.348f, 200.286f, 150.096f, 204.382f, 154.462f)
                curveTo(208.387f, 158.731f, 208.619f, 158.961f, 208.723f, 158.761f)
                curveTo(208.767f, 158.676f, 207.995f, 154.894f, 207.007f, 150.357f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(112.325f, 140.128f)
                curveTo(115.218f, 139.166f, 119.321f, 136.512f, 121.854f, 133.965f)
                curveTo(122.177f, 133.641f, 122.296f, 133.706f, 123.277f, 134.739f)
                curveTo(124.74f, 136.28f, 128.115f, 138.661f, 129.946f, 139.443f)
                curveTo(132.516f, 140.541f, 135.313f, 140.894f, 137.83f, 140.437f)
                lineTo(138.987f, 140.227f)
                lineTo(139.164f, 135.715f)
                curveTo(139.261f, 133.234f, 139.341f, 129.963f, 139.342f, 128.447f)
                lineTo(139.343f, 125.691f)
                lineTo(136.573f, 125.575f)
                curveTo(124.509f, 125.073f, 114.482f, 124.587f, 107.632f, 124.175f)
                curveTo(103.193f, 123.907f, 99.527f, 123.714f, 99.485f, 123.746f)
                curveTo(99.443f, 123.778f, 98.843f, 126.502f, 98.154f, 129.801f)
                lineTo(96.9f, 135.798f)
                lineTo(97.692f, 136.519f)
                curveTo(99.697f, 138.342f, 102.487f, 139.92f, 104.76f, 140.515f)
                curveTo(106.732f, 141.032f, 110.131f, 140.858f, 112.325f, 140.128f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(249.124f, 140.172f)
                curveTo(251.155f, 139.473f, 253.452f, 138.088f, 255.165f, 136.529f)
                lineTo(256.525f, 135.292f)
                lineTo(255.248f, 129.493f)
                curveTo(254.545f, 126.304f, 253.894f, 123.639f, 253.799f, 123.571f)
                curveTo(253.705f, 123.502f, 250.74f, 123.636f, 247.211f, 123.868f)
                curveTo(235.625f, 124.629f, 219.369f, 125.459f, 216.029f, 125.459f)
                curveTo(215.03f, 125.459f, 214.164f, 125.524f, 214.103f, 125.605f)
                curveTo(214.02f, 125.712f, 215.674f, 140.05f, 215.784f, 140.183f)
                curveTo(215.911f, 140.338f, 218.377f, 140.383f, 219.497f, 140.252f)
                curveTo(222.733f, 139.872f, 226.723f, 137.791f, 229.709f, 134.926f)
                curveTo(230.449f, 134.217f, 231.117f, 133.641f, 231.195f, 133.646f)
                curveTo(231.273f, 133.651f, 231.824f, 134.146f, 232.418f, 134.747f)
                curveTo(234.925f, 137.276f, 238.893f, 139.691f, 241.813f, 140.463f)
                curveTo(243.907f, 141.016f, 247.03f, 140.892f, 249.124f, 140.172f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(74.637f, 140.137f)
                curveTo(76.123f, 139.971f, 77.422f, 139.777f, 77.522f, 139.706f)
                curveTo(77.623f, 139.635f, 79.035f, 135.765f, 80.66f, 131.106f)
                curveTo(83.905f, 121.803f, 83.83f, 122.386f, 81.784f, 122.357f)
                curveTo(80.729f, 122.342f, 80.176f, 122.059f, 80.176f, 121.535f)
                curveTo(80.176f, 120.971f, 80.883f, 120.854f, 83.177f, 121.04f)
                curveTo(85.33f, 121.214f, 85.39f, 121.206f, 87.833f, 120.482f)
                curveTo(121.277f, 110.564f, 147.071f, 98.013f, 165.443f, 82.717f)
                curveTo(167.161f, 81.286f, 170.953f, 77.859f, 171.363f, 77.366f)
                curveTo(171.495f, 77.207f, 169.479f, 78.478f, 166.882f, 80.189f)
                curveTo(134.458f, 101.559f, 111.616f, 112.313f, 81.495f, 120.388f)
                lineTo(79.167f, 121.013f)
                lineTo(78.865f, 122.895f)
                curveTo(78.21f, 126.98f, 75.858f, 130.909f, 70.035f, 137.646f)
                curveTo(68.777f, 139.101f, 67.748f, 140.358f, 67.748f, 140.438f)
                curveTo(67.748f, 140.651f, 71.508f, 140.487f, 74.637f, 140.137f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(165.852f, 140.259f)
                curveTo(168.363f, 139.925f, 171.477f, 138.67f, 173.953f, 136.993f)
                curveTo(175.177f, 136.165f, 176.635f, 135.07f, 177.196f, 134.561f)
                lineTo(178.214f, 133.634f)
                lineTo(179.43f, 134.773f)
                curveTo(181.279f, 136.504f, 184.561f, 138.615f, 186.447f, 139.284f)
                curveTo(188.022f, 139.843f, 190.885f, 140.342f, 191.029f, 140.084f)
                curveTo(191.064f, 140.019f, 191.051f, 136.877f, 190.999f, 133.102f)
                lineTo(190.904f, 126.238f)
                horizontalLineTo(176.766f)
                horizontalLineTo(162.627f)
                lineTo(162.477f, 127.844f)
                curveTo(162.395f, 128.728f, 162.259f, 131.875f, 162.177f, 134.839f)
                curveTo(162.036f, 139.885f, 162.057f, 140.233f, 162.505f, 140.318f)
                curveTo(163.346f, 140.475f, 164.357f, 140.458f, 165.852f, 140.259f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(284.788f, 139.431f)
                curveTo(284.037f, 137.605f, 283.313f, 136.333f, 280.712f, 132.274f)
                curveTo(277.737f, 127.632f, 276.141f, 124.366f, 275.888f, 122.402f)
                lineTo(275.708f, 121.012f)
                lineTo(273.381f, 120.386f)
                curveTo(269.062f, 119.224f, 257.969f, 115.737f, 252.47f, 113.813f)
                curveTo(233.903f, 107.314f, 217.415f, 99.506f, 201.943f, 89.885f)
                curveTo(196.929f, 86.767f, 188.578f, 81.077f, 184.713f, 78.145f)
                curveTo(179.346f, 74.074f, 179.851f, 75.236f, 185.687f, 80.383f)
                curveTo(203.761f, 96.327f, 229.857f, 109.667f, 262.549f, 119.676f)
                lineTo(266.742f, 120.96f)
                lineTo(269.474f, 120.746f)
                curveTo(272.457f, 120.512f, 273.08f, 120.581f, 273.08f, 121.145f)
                curveTo(273.08f, 121.683f, 272.591f, 121.892f, 270.968f, 122.049f)
                curveTo(270.069f, 122.137f, 269.572f, 122.273f, 269.639f, 122.412f)
                curveTo(269.699f, 122.535f, 271.128f, 126.596f, 272.814f, 131.437f)
                lineTo(275.881f, 140.239f)
                lineTo(276.71f, 140.315f)
                curveTo(277.165f, 140.356f, 279.264f, 140.405f, 281.373f, 140.422f)
                lineTo(285.209f, 140.453f)
                lineTo(284.788f, 139.431f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(161.313f, 133.212f)
                curveTo(161.408f, 129.443f, 161.423f, 126.315f, 161.346f, 126.259f)
                curveTo(161.268f, 126.203f, 157.715f, 126.095f, 153.449f, 126.018f)
                curveTo(149.182f, 125.941f, 144.525f, 125.824f, 143.1f, 125.759f)
                lineTo(140.509f, 125.64f)
                lineTo(140.332f, 129.882f)
                curveTo(140.107f, 135.238f, 140.102f, 139.674f, 140.321f, 139.674f)
                curveTo(140.414f, 139.674f, 141.234f, 139.288f, 142.144f, 138.818f)
                curveTo(144.176f, 137.767f, 146.409f, 136.203f, 148.124f, 134.63f)
                curveTo(148.836f, 133.977f, 149.505f, 133.443f, 149.611f, 133.443f)
                curveTo(149.717f, 133.443f, 150.418f, 134.034f, 151.169f, 134.757f)
                curveTo(152.681f, 136.214f, 153.933f, 137.119f, 155.958f, 138.219f)
                curveTo(157.281f, 138.938f, 160.263f, 140.063f, 160.845f, 140.063f)
                curveTo(161.048f, 140.063f, 161.193f, 137.944f, 161.313f, 133.212f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(193.955f, 139.802f)
                curveTo(196.558f, 139.237f, 200.064f, 137.219f, 202.215f, 135.049f)
                curveTo(202.878f, 134.38f, 203.537f, 133.832f, 203.68f, 133.832f)
                curveTo(203.823f, 133.832f, 204.992f, 134.629f, 206.278f, 135.603f)
                curveTo(207.564f, 136.577f, 209.351f, 137.751f, 210.25f, 138.212f)
                curveTo(211.985f, 139.102f, 214.354f, 140.003f, 214.564f, 139.851f)
                curveTo(214.633f, 139.801f, 214.333f, 136.783f, 213.896f, 133.145f)
                curveTo(213.459f, 129.506f, 213.101f, 126.322f, 213.1f, 126.069f)
                lineTo(213.099f, 125.609f)
                lineTo(208.169f, 125.756f)
                curveTo(205.457f, 125.837f, 200.685f, 125.957f, 197.564f, 126.022f)
                lineTo(191.891f, 126.14f)
                lineTo(191.905f, 126.773f)
                curveTo(191.914f, 127.121f, 191.944f, 130.254f, 191.973f, 133.735f)
                curveTo(192.015f, 138.878f, 192.093f, 140.063f, 192.388f, 140.063f)
                curveTo(192.587f, 140.063f, 193.292f, 139.946f, 193.955f, 139.802f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(274.7f, 139.92f)
                curveTo(274.7f, 139.715f, 268.684f, 122.457f, 268.579f, 122.362f)
                curveTo(268.476f, 122.268f, 255.17f, 123.308f, 255.011f, 123.422f)
                curveTo(254.951f, 123.465f, 255.405f, 125.77f, 256.02f, 128.543f)
                curveTo(256.635f, 131.317f, 257.139f, 133.707f, 257.14f, 133.855f)
                curveTo(257.141f, 134.003f, 257.435f, 133.861f, 257.793f, 133.54f)
                lineTo(258.445f, 132.956f)
                lineTo(260.966f, 134.723f)
                curveTo(262.353f, 135.695f, 264.074f, 136.777f, 264.791f, 137.128f)
                curveTo(266.588f, 138.006f, 270.147f, 139.184f, 272.409f, 139.648f)
                curveTo(274.601f, 140.098f, 274.7f, 140.11f, 274.7f, 139.92f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(81.848f, 138.878f)
                curveTo(86.418f, 137.785f, 90.875f, 136.1f, 93.723f, 134.389f)
                lineTo(94.979f, 133.634f)
                lineTo(95.512f, 134.241f)
                lineTo(96.045f, 134.847f)
                lineTo(96.209f, 134.193f)
                curveTo(96.334f, 133.694f, 98.046f, 125.5f, 98.356f, 123.91f)
                curveTo(98.401f, 123.68f, 97.135f, 123.529f, 91.658f, 123.112f)
                curveTo(87.943f, 122.829f, 84.824f, 122.65f, 84.726f, 122.714f)
                curveTo(84.576f, 122.813f, 78.824f, 139.039f, 78.824f, 139.364f)
                curveTo(78.824f, 139.565f, 79.277f, 139.493f, 81.848f, 138.878f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(190.284f, 124.637f)
                curveTo(190.359f, 124.583f, 189.565f, 122.063f, 188.52f, 119.036f)
                curveTo(184.566f, 107.579f, 181.169f, 94.951f, 178.278f, 80.964f)
                curveTo(177.348f, 76.466f, 177.229f, 76.091f, 176.712f, 76.037f)
                curveTo(176.205f, 75.983f, 176.122f, 76.13f, 175.834f, 77.595f)
                curveTo(173.649f, 88.685f, 170.328f, 101.936f, 167.287f, 111.701f)
                curveTo(166.157f, 115.329f, 163.252f, 123.811f, 162.937f, 124.403f)
                curveTo(162.835f, 124.595f, 163.237f, 124.681f, 164.513f, 124.743f)
                curveTo(166.823f, 124.856f, 190.115f, 124.76f, 190.284f, 124.637f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(162.621f, 122.538f)
                curveTo(166.241f, 112.875f, 170.698f, 97.049f, 173.507f, 83.885f)
                curveTo(174.032f, 81.422f, 174.525f, 79.15f, 174.602f, 78.836f)
                curveTo(174.825f, 77.931f, 174.516f, 78.332f, 172.862f, 81.097f)
                curveTo(165.724f, 93.028f, 155.701f, 106.854f, 144.679f, 119.974f)
                curveTo(142.759f, 122.258f, 141.241f, 124.165f, 141.305f, 124.211f)
                curveTo(141.501f, 124.352f, 152.734f, 124.626f, 157.421f, 124.604f)
                lineTo(161.855f, 124.583f)
                lineTo(162.621f, 122.538f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(202.833f, 124.463f)
                curveTo(207.811f, 124.341f, 211.928f, 124.213f, 211.981f, 124.179f)
                curveTo(212.035f, 124.146f, 210.381f, 122.076f, 208.306f, 119.579f)
                curveTo(197.172f, 106.184f, 187.626f, 92.936f, 180.528f, 81.023f)
                curveTo(179.653f, 79.556f, 178.894f, 78.388f, 178.84f, 78.427f)
                curveTo(178.625f, 78.583f, 181.329f, 90.642f, 183.274f, 98.197f)
                curveTo(185.371f, 106.347f, 188.571f, 116.713f, 190.982f, 123.171f)
                lineTo(191.545f, 124.68f)
                lineTo(192.664f, 124.682f)
                curveTo(193.279f, 124.684f, 197.855f, 124.585f, 202.833f, 124.463f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(142.017f, 121.769f)
                curveTo(149.616f, 112.93f, 158.479f, 101.369f, 164.491f, 92.453f)
                curveTo(168.975f, 85.802f, 174.737f, 76.486f, 174.737f, 75.884f)
                curveTo(174.737f, 75.283f, 174.25f, 75.695f, 172.72f, 77.594f)
                curveTo(170.589f, 80.239f, 165.348f, 85.902f, 162.571f, 88.559f)
                curveTo(148.772f, 101.764f, 131.947f, 111.796f, 111.008f, 119.303f)
                curveTo(108.539f, 120.188f, 105.575f, 121.207f, 104.424f, 121.566f)
                curveTo(103.272f, 121.925f, 102.33f, 122.278f, 102.33f, 122.349f)
                curveTo(102.33f, 122.421f, 103.455f, 122.535f, 104.829f, 122.604f)
                curveTo(106.204f, 122.672f, 110.428f, 122.901f, 114.218f, 123.112f)
                curveTo(119.991f, 123.434f, 130.314f, 123.906f, 137.047f, 124.157f)
                curveTo(137.939f, 124.19f, 138.934f, 124.233f, 139.259f, 124.254f)
                curveTo(139.742f, 124.284f, 140.24f, 123.836f, 142.017f, 121.769f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(222.325f, 123.796f)
                curveTo(228.73f, 123.516f, 237.035f, 123.071f, 246.4f, 122.505f)
                curveTo(248.591f, 122.373f, 250.293f, 122.207f, 250.182f, 122.136f)
                curveTo(250.071f, 122.066f, 248.581f, 121.546f, 246.873f, 120.982f)
                curveTo(237.512f, 117.89f, 226.116f, 112.918f, 218.152f, 108.45f)
                curveTo(208.255f, 102.896f, 198.797f, 95.908f, 190.911f, 88.323f)
                curveTo(187.987f, 85.51f, 182.526f, 79.601f, 180.815f, 77.399f)
                curveTo(180.124f, 76.509f, 179.564f, 76.006f, 179.262f, 76.003f)
                curveTo(179.002f, 76.001f, 178.789f, 76.069f, 178.789f, 76.156f)
                curveTo(178.789f, 76.242f, 179.622f, 77.71f, 180.64f, 79.417f)
                curveTo(188.52f, 92.634f, 197.463f, 105.115f, 209.131f, 119.179f)
                lineTo(213.21f, 124.096f)
                horizontalLineTo(214.341f)
                curveTo(214.964f, 124.096f, 218.556f, 123.961f, 222.325f, 123.796f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(108.949f, 119.243f)
                curveTo(132.294f, 111.098f, 150.226f, 100.089f, 165.213f, 84.699f)
                curveTo(167.739f, 82.105f, 168.271f, 81.455f, 166.997f, 82.522f)
                curveTo(153.02f, 94.225f, 135.871f, 103.894f, 114.006f, 112.399f)
                curveTo(107.011f, 115.121f, 94.023f, 119.53f, 89.018f, 120.883f)
                curveTo(88.308f, 121.074f, 87.786f, 121.272f, 87.856f, 121.323f)
                curveTo(87.926f, 121.374f, 90.634f, 121.605f, 93.873f, 121.837f)
                lineTo(99.763f, 122.259f)
                lineTo(101.924f, 121.599f)
                curveTo(103.113f, 121.236f, 106.274f, 120.176f, 108.949f, 119.243f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(263.346f, 121.225f)
                lineTo(264.557f, 121.075f)
                lineTo(259.294f, 119.433f)
                curveTo(245.763f, 115.212f, 230.421f, 109.083f, 219.104f, 103.378f)
                curveTo(206.69f, 97.12f, 193.702f, 88.68f, 186.261f, 82.035f)
                curveTo(185.021f, 80.928f, 185.96f, 82.091f, 188.041f, 84.239f)
                curveTo(193.979f, 90.37f, 198.735f, 94.482f, 205.658f, 99.47f)
                curveTo(212.872f, 104.668f, 218.942f, 108.274f, 227.013f, 112.157f)
                curveTo(233.457f, 115.257f, 242.401f, 118.791f, 249.82f, 121.169f)
                lineTo(252.635f, 122.071f)
                lineTo(257.385f, 121.723f)
                curveTo(259.998f, 121.531f, 262.681f, 121.307f, 263.346f, 121.225f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(179.346f, 73.106f)
                lineTo(179.964f, 72.745f)
                lineTo(179.212f, 60.887f)
                curveTo(178.798f, 54.365f, 178.313f, 46.599f, 178.133f, 43.629f)
                curveTo(177.953f, 40.659f, 177.742f, 38.182f, 177.664f, 38.126f)
                curveTo(177.585f, 38.069f, 177.439f, 39.404f, 177.34f, 41.092f)
                curveTo(177.24f, 42.78f, 176.73f, 50.163f, 176.206f, 57.5f)
                curveTo(175.682f, 64.836f, 175.288f, 71.318f, 175.331f, 71.904f)
                curveTo(175.399f, 72.818f, 175.507f, 73.006f, 176.086f, 73.216f)
                curveTo(177.076f, 73.575f, 178.631f, 73.523f, 179.346f, 73.106f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(198.554f, 53.91f)
                curveTo(202.844f, 53.305f, 206.198f, 52.12f, 208.861f, 50.268f)
                curveTo(209.856f, 49.576f, 210.314f, 49.146f, 209.993f, 49.207f)
                curveTo(209.696f, 49.263f, 208.373f, 49.443f, 207.053f, 49.607f)
                curveTo(201.184f, 50.336f, 196.296f, 49.679f, 193.569f, 47.793f)
                lineTo(192.545f, 47.085f)
                lineTo(192.579f, 50.455f)
                curveTo(192.612f, 53.716f, 192.632f, 53.83f, 193.198f, 53.995f)
                curveTo(194.094f, 54.255f, 196.359f, 54.219f, 198.554f, 53.91f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(191.576f, 47.325f)
                curveTo(191.394f, 43.446f, 191.356f, 43.382f, 188.809f, 42.675f)
                curveTo(187.705f, 42.368f, 186.478f, 42.231f, 184.231f, 42.161f)
                lineTo(181.162f, 42.066f)
                lineTo(181.318f, 42.821f)
                curveTo(181.404f, 43.237f, 181.554f, 45.001f, 181.653f, 46.741f)
                curveTo(181.807f, 49.476f, 181.89f, 49.905f, 182.269f, 49.906f)
                curveTo(182.51f, 49.907f, 183.938f, 49.805f, 185.443f, 49.68f)
                curveTo(188.47f, 49.427f, 190.244f, 49.627f, 191.111f, 50.318f)
                curveTo(191.364f, 50.519f, 191.608f, 50.684f, 191.653f, 50.684f)
                curveTo(191.697f, 50.684f, 191.663f, 49.173f, 191.576f, 47.325f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(179.144f, 34.694f)
                curveTo(180.162f, 34.319f, 180.667f, 33.695f, 180.674f, 32.803f)
                curveTo(180.679f, 32.128f, 180.523f, 31.848f, 179.89f, 31.392f)
                curveTo(178.76f, 30.577f, 176.926f, 30.577f, 175.796f, 31.392f)
                curveTo(174.517f, 32.313f, 174.827f, 34.017f, 176.387f, 34.64f)
                curveTo(177.185f, 34.959f, 178.363f, 34.982f, 179.144f, 34.694f)
                close()
            }
        }
        .build()
        return _notFoundHorizontal!!
    }

private var _notFoundHorizontal: ImageVector? = null
