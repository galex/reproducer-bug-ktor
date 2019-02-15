package com.example

import com.example.screens.mainFrame
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class AppComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        mainFrame()
    }
}

fun RBuilder.app() = child(AppComponent::class) {}



