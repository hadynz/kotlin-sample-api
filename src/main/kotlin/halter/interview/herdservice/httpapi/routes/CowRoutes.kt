package halter.interview.herdservice.httpapi.routes

import halter.interview.herdservice.application.cows.createCow.CreateCowCommandHandler
import halter.interview.herdservice.application.cows.createCow.CreateCowRequest
import halter.interview.herdservice.domain.cows.CreateCowCommand
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.cowRouting() {
    val handler = CreateCowCommandHandler();

    route("/cows") {
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