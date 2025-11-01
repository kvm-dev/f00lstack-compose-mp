package ru.kvmsoft.base.network.utils

import FoolStack.base.network.APP_VERSION
import FoolStack.base.network.BASE_URL_PRODUCTION
import FoolStack.base.network.BASE_URL_TEST
import FoolStack.base.network.BUILD_TYPE
import ru.kvmsoft.base.network.model.BuildType
import ru.kvmsoft.base.network.model.PlatformType
import ru.kvmsoft.base.network.platform

fun getBuildType(): BuildType {
    return if(BUILD_TYPE.contains("debug")) BuildType.DEBUG else BuildType.RELEASE
}

fun getCurrentVersion() = APP_VERSION

fun getPlatform(): PlatformType{
    return if(platform().contains("Android")) PlatformType.ANDROID else PlatformType.IOS
}

fun getBaseUrl(): String{
    return if(getBuildType() == BuildType.DEBUG) BASE_URL_TEST else BASE_URL_PRODUCTION
}
