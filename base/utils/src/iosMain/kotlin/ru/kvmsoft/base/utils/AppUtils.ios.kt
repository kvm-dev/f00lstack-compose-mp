package ru.kvmsoft.base.utils

import platform.posix.exit

actual fun closeApp(){
    exit(0)
}