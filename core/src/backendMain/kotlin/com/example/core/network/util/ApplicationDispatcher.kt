package com.example.core.network.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val ApplicationDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default