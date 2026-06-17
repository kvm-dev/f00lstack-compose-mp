package ru.kvmsoft.base.ui.model

data class BookItem(
    val bookId: Int,
    val bookName: String,
    val bookDescription: String,
    val bookPrice: Int,
    val bookSalePrice: Int,
    val bookImageBase64: String,
    val bookTags: List<Chip>,
    val bookRefLink: String
)