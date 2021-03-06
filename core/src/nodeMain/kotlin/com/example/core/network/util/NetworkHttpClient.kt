package com.example.core.network.util

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlin.js.Date
import kotlin.random.Random

actual val networkHttpClient: HttpClient
    get() = HttpClient(Js) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json(encodeDefaults = false))
        }
    }

actual fun randomUUID(): String = Random.nextDouble().toString().substring(2)+ (Date()).getTime().toString()
actual fun currentTimeMillis(): Long = Date().getTime().toLong()