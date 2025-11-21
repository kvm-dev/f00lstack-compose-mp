package ru.kvmsoft.features.books.imp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksVersionResponse(
    @SerialName("success") val success: Boolean = false,
    @SerialName("version") val version: Int = 0,
    @SerialName("errorMsg") val errorMsg: String
)