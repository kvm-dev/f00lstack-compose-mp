package ru.kvmsoft.foolstack

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform