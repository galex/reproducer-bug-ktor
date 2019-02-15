package com.example.core.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
data class Profile(
    val id: Int,
    @Optional val firstName: String? = null,
    @Optional val lastName: String? = null,
    @Optional val avatarUrl: String? = null)