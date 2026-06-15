package ru.kvmsoft.base.network

import io.ktor.client.HttpClient

expect object HttpClientProvider {
    val client: HttpClient
}