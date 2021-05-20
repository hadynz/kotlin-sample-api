package halter.interview.herdservice.application.cows.createCow

import kotlinx.serialization.Serializable

@Serializable
class CreateCowRequest(val collarId: String, val cowNumber: String)
