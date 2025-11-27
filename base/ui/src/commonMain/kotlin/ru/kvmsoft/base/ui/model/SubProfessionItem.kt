package ru.kvmsoft.base.ui.model

data class SubProfessionItem(
    val professionId: Int,
    val professionName: String,
    var subProfessions: List<SubProfessionItem>
)