package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.util.*
import io.ktor.util.Identity.encode

import kotlinx.serialization.*
import kotlinx.serialization.json.*

fun Application.configureRouting() {

	// Starting point for a Ktor app:
	routing {
		get("/") {
			call.respondText("Hello World!")
			val data = call.request.queryParameters
			val person = Person(data["firstName"]!!,data["lastName"]!!,data["age"]!!)
			val serialized = Json.encodeToString(person)
			println(serialized)
		}
	}
	routing {
	}
}

@Serializable
data class Person(val firstName: String, val lastName: String, val age: String)