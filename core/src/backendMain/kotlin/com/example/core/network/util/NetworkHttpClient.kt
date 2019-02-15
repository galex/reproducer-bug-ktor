package com.example.core.network.util

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.util.*

actual val networkHttpClient: HttpClient
    get() = HttpClient(OkHttp)

actual fun randomUUID(): String = UUID.randomUUID().toString()
actual fun currentTimeMillis(): Long = System.currentTimeMillis()