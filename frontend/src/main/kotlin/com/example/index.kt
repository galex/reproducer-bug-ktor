@file:Suppress("UnsafeCastFromDynamic")

package com.example

import react.dom.render
import kotlin.browser.document

@JsModule("react-hot-loader")
private external val hotModule: dynamic
private val hot = hotModule.hot
private val module = js("module")

fun main() {

    println("in the main app, thats ok!")

    val hotWrapper = hot(module)
    render(document.getElementById("root")) {
        hotWrapper(app())
    }
}
