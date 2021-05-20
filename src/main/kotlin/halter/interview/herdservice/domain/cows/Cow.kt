package halter.interview.herdservice.domain.cows

import java.util.*

data class Cow(val command: CreateCowCommand) {
    var id: String = UUID.randomUUID().toString();
    var collarId = command.collarId
    var cowNumber = command.cowNumber
    var createdAtUtc = Date()
    var updatedAtUtc: Date? = null
}
