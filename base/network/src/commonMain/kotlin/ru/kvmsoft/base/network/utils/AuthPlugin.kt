package ru.kvmsoft.base.network.utils

import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.util.AttributeKey

val disableAuthKey = AttributeKey<Boolean>("disableAuthKey")

fun disableAuthPlugin() = createClientPlugin("DisableAuthPlugin") {
    onRequest { request, _ ->
        if (request.attributes.contains(disableAuthKey)) {
            request.headers.remove("Authorization")
        }
    }
}