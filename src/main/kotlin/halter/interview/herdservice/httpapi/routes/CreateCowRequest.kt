package halter.interview.herdservice.httpapi.routes

import kotlinx.serialization.Serializable

@Serializable
class CreateCowRequest(val collarId: String, val cowNumber: String)
