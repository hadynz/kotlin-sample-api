package halter.interview.herdservice.httpapi.routes

import halter.interview.herdservice.application.cows.CowDto
import halter.interview.herdservice.domain.cows.CreateCowCommand
import halter.interview.herdservice.application.cows.createCow.CreateCowCommandHandler
import halter.interview.herdservice.domain.cows.CollarStatus
import halter.interview.herdservice.domain.cows.Cow
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.cowRouting() {
    val handler = CreateCowCommandHandler();

    route("/cows") {
        get {
            val stringList = listOf(
                CowDto(
                    "fe0a1ec1-e7d4-4b2d-a555-ae23926ee9d0",
                    "261",
                    "88261",
                    CollarStatus.Healthy.toString(),
                    //GeoLocation(123, 456)
                ),
                CowDto(
                    "fe0a1ec1-e7d4-4b2d-a555-ae23926ee9d0",
                    "261",
                    "88261",
                    CollarStatus.Healthy.toString(),
                    //GeoLocation(123, 456)
                )
            )
            call.respond(stringList)
        }
        put("{id}") {
            val id = call.parameters["id"] ?: return@put call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )

            val cow = call.receive<Cow>()
            call.respondText("Cow updated correctly", status = HttpStatusCode.OK)
        }
        post {
            val request = call.receive<CreateCowRequest>()
            val command = CreateCowCommand(request.collarId, request.cowNumber)

            val cowDto = handler.handle(command);
            call.respond(HttpStatusCode.Created, cowDto)
        }
    }
}

fun Application.registerCowRoutes() {
    routing {
        cowRouting()
    }
}