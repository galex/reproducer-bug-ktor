package com.example.backend.route

import com.example.core.model.Profile
import com.example.core.network.util.EDIT
import com.example.core.network.util.PROFILES
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.http.content.streamProvider
import io.ktor.request.receiveMultipart
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route
import kotlinx.io.core.readBytes

fun Route.profiles() {

    route("/$PROFILES") {

        post("/$EDIT") {

            val multipart = call.receiveMultipart()
            val out = arrayListOf<String>()

            multipart.forEachPart { part ->
                out += when (part) {
                    is PartData.FormItem -> {
                        "FormItem(${part.name},${part.value})"
                    }
                    is PartData.FileItem -> {
                        val bytes = part.streamProvider().readBytes()
                        val str = String(bytes)
                        "FileItem(${part.name},${part.originalFileName},$str)"
                    }
                    is PartData.BinaryItem -> {
                        "BinaryItem(${part.name},${part.provider().readBytes()})"
                    }
                }

                part.dispose()
            }

            println(out)
            call.respond(HttpStatusCode.OK, Profile(1, "test1", "test2"))
        }
    }
}