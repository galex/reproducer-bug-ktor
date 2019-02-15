package com.example.screens.profile

import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.card.mCard
import com.ccfraser.muirwik.components.card.mCardContent
import com.ccfraser.muirwik.components.form.mFormControl
import com.ccfraser.muirwik.components.input.mInput
import com.ccfraser.muirwik.components.input.mInputLabel
import com.example.core.network.api.ProfileAPI
import kotlinx.css.*
import kotlinx.html.InputType
import org.w3c.files.Blob
import org.w3c.files.FileReader
import react.*
import styled.css
import styled.styledDiv

interface EditProfileState : RState {
    var avatarPath: String?
    var avatarBinaryString: String?
    var avatarInput: String?
}

class EditProfileComponent : RComponent<RProps, EditProfileState>() {

    private val fileReaderAsUrl = FileReader().apply {
        onload = {
            setState {
                avatarPath = it.target.asDynamic().result as? String
            }
        }
    }

    private val fileReaderAsBinaryString = FileReader().apply {
        onload = {
            setState {
                avatarBinaryString = it.target.asDynamic().result as? String
            }
        }
    }

    override fun EditProfileState.init() {
        avatarPath = ""
    }

    private fun save() {

        val avatarFile = state.avatarPath
        println(avatarFile)

        ProfileAPI.postMultipartEditProfile(state.avatarBinaryString!!) {
            println("result = $it")
        }
    }

    override fun RBuilder.render() {

        mGridContainer {
            css {
                justifyContent = JustifyContent.center
            }

            mCard {
                css {
                    marginTop = 10.px
                    width = 560.px
                }

                mCardContent {

                    mTypography("Edit your profile", variant = MTypographyVariant.h5, component = "h3")

                    mAvatar(src = state.avatarPath) {
                        css {
                            margin(2.spacingUnits)
                            width = 100.px
                            height = 100.px
                        }
                    }

                    mFormControl(fullWidth = true, margin = MMargin.dense) {
                        mInputLabel("Avatar")
                        mInput(type = InputType.file,
                                onChange = {

                                    state.avatarInput = it.targetInputValue
                                    println(state.avatarInput)

                                    //val blob = it.target.asDynamic().files[0] as Blob
                                    fileReaderAsUrl.readAsDataURL(it.target.asDynamic().files[0] as Blob)
                                    fileReaderAsBinaryString.readAsBinaryString(it.target.asDynamic().files[0] as Blob)

                                })
                    }

                }

                mButton(caption = "Save",
                        primary = true,
                        size = MButtonSize.medium,
                        fullWidth = true,
                        onClick = { save() })
            }
        }
    }
}