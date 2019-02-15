package com.example.screens

import com.ccfraser.muirwik.components.*
import com.example.screens.profile.EditProfileComponent
import kotlinx.css.padding
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import styled.css
import styled.styledDiv

interface MainFrameState : RState

class MainFrame : RComponent<RProps, MainFrameState>() {

    override fun MainFrameState.init() {
    }

    override fun RBuilder.render() {

        mCssBaseline()

        styledDiv {
            //css { flexGrow = 1.0; padding(2.spacingUnits) }

            mAppBar(MColor.primary, MAppBarPosition.sticky) {
                mToolbar {
                    mTypography("Example project", variant = MTypographyVariant.h6, color = MTypographyColor.inherit) {
                        css { flexGrow = 1.0 }
                    }
                }
            }

        }

        styledDiv {
            css { flexGrow = 1.0; padding(2.spacingUnits) }

            browserRouter {
                switch {
                    route("", EditProfileComponent::class, exact = true)
                }
            }
        }
    }
}

fun RBuilder.mainFrame() = child(MainFrame::class) {}