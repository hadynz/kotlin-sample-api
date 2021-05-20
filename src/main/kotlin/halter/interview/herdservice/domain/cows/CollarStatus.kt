package halter.interview.herdservice.domain.cows

import kotlinx.serialization.Serializable

@Serializable
data class CollarStatus(
    val id: String,
    val serialNumber: String,
    // TODO: These values should be defined as Int in this domain
    val lat: String,
    val lng: String,
    // TODO: This should be a DateTime or Timestamp object
    val timestamp: String,
    val healthy: Boolean
)