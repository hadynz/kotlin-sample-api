package halter.interview.herdservice.domain.cows

import java.util.*

enum class CollarStatus {
    Healthy, Broken
}

data class GeoLocation(val lat: Int, val long: Int);

data class Cow(val command: CreateCowCommand) {
    var id: String = UUID.randomUUID().toString();
    var collarId = command.collarId
    var cowNumber = command.cowNumber
    var createdAtUtc = Date()
    var updatedAtUtc: Date? = null
}
