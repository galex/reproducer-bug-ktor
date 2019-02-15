@file:Suppress("unused")

package com.example.core.network.api

import com.example.core.model.Profile
import com.example.core.network.util.*
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import io.ktor.http.Url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.io.core.toByteArray
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.stringify

//@UseExperimental(ImplicitReflectionSerializer::class)
object ProfileAPI {

//    @UseExperimental(ImplicitReflectionSerializer::class)
//    fun postEditProfile(editProfile: EditProfile, token: String, errorBlock: ((ApiError) -> Unit)? = null, successBlock: (Profile) -> Unit) {
//
//        val address = Url("$BASE_URL/$PROFILES/$EDIT").toString()
//        println("address = $address")
//        GlobalScope.apply {
//            launch(ApplicationDispatcher) {
//                try {
//                    val result: Profile = networkHttpClient.post {
//                        url(address)
//                        header(HttpHeaders.Authorization, "Bearer $token")
//                        body = TextContent(kotlinx.serialization.json.Json.stringify(editProfile), contentType = ContentType.Application.Json)
//                    }
//                    println(result)
//                    successBlock(result)
//                } catch (e: BadResponseStatusException) {
//                    println(e)
//                    errorBlock?.invoke(ApiError.TOKEN_EXPIRED)
//                }
//            }
//        }
//    }

    @UseExperimental(ImplicitReflectionSerializer::class)
    fun postMultipartEditProfile(binaryString: String, successBlock: (Profile) -> Unit) {


        val address = Url("$BASE_URL/$PROFILES/$EDIT").toString()
        println("address = $address")
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: Profile = networkHttpClient.post {
                    url(address)
                    body = MultiPartContent.build {
                        add("file", binaryString.toByteArray(), filename = "binary.bin")
                    }
                }

                println(result)
                successBlock(result)
            }
        }
    }
}