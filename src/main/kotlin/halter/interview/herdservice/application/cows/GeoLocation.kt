package halter.interview.herdservice.application.cows

import kotlinx.serialization.Serializable

@Serializable
data class GeoLocation(val lat: Double, val long: Double)