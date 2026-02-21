package ru.kvmsoft.base.ui.utils

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import android.util.Base64

actual fun String.decodeBase64ToBitmap(): ImageBitmap? {
        return try {
        val imageBytes = Base64.decode(this.substringAfter("base64,"), Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        bitmap.asImageBitmap()
    } catch (_: Exception) {
        null
    }
}