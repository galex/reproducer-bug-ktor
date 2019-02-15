package com.example.core.network.util

import io.ktor.client.HttpClient
import kotlinx.serialization.Serializer

expect val networkHttpClient: HttpClient
expect fun randomUUID(): String
expect fun currentTimeMillis(): Long

