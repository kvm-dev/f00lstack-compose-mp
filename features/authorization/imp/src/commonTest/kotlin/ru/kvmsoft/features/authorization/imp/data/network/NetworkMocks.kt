package ru.kvmsoft.features.authorization.imp.data.network

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

object NetworkMocks {
  val authByEmailCorrectMock  = MockEngine { request ->
        respond(
            content = """{"userToken":"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJyZWREYXRlIjoxNzQxNzI2ODI2LCJsb2dpbiI6InRlc3RAZm9vbHN0YWNrLnJ1IiwidG9rZW5FeHAiOjE3NDk0MTY0MjYsInVzZXJfdG9rZW5fbGFzdF91cGRhdGUiOjE3NDE3MjY4MjYsInVzZXJJZCI6MX0.LWXXjwJmCjzH5SVAHTBjTqCvMB1f1IEa20JTQSZZkH-GRoQ-qBIJ4boPOLlbjLiuy-IPd7ya_wc49mhI2IVghn6Bz3qMMeHF4mRAzHNgEZyRVRJcWD6KEzlrp1Fe063DDqpkRixyeY6UsgJgwgEklWYBo-uD-XFBt27Cbvr5V60", "userRefreshToken":"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJyZWZyZXNoX3Rva2VuX2xhc3RfdXBkYXRlIjoxNzQxNzI2ODI2fQ.UWK_ziCO7BMoUiu43VKiT2K7cD1_zgrDVKh9yIqWGnKjw2m8105HbdrPIpNKMu9osaKcqO4s6pAEFA-iu5AichwQZPC3N-29-kw45UqQ__jSHIHertCV-FsGRdqaUnYb6sPqeAzENblYAAp6BOSozsDf9f1B-6QOqE5sExxhkv0", "errorMsg":""}""",
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}