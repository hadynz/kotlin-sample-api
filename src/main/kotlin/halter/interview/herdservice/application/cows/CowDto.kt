package halter.interview.herdservice.application.cows

import kotlinx.serialization.Serializable

@Serializable
class CowDto(
    val id: String,
    val collarId: String,
    val cowNumber: String,
    val collarStatus: String,
    //val lastLocation: GeoLocation
)