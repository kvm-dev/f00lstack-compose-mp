package ru.kvmsoft.base.ui.utils

import androidx.compose.ui.graphics.ImageBitmap

expect fun String.decodeBase64ToBitmap(): ImageBitmap?
