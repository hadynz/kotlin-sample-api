package halter.interview.herdservice.application.cows.createCow

import halter.interview.herdservice.application.cows.CowDto
import halter.interview.herdservice.application.cows.GeoLocation
import halter.interview.herdservice.domain.cows.*
import halter.interview.herdservice.infrastructure.cows.CollarStatusRepository
import halter.interview.herdservice.infrastructure.cows.StubbedProductRepository

class CreateCowCommandHandler {
    private val cowRepository = StubbedProductRepository();
    private val collarStatusRepository = CollarStatusRepository();

    suspend fun handle(command: CreateCowCommand): CowDto {
        var cow = Cow(command)

        if (cowRepository.exists(cow)) {
            throw RuntimeException("Cow already exists: ${cow.id}");
        }

        val collarStatus = collarStatusRepository.getCollarStatus(cow);

        // TODO: Should a Cow be saved if a corresponding collar cannot be found?
        cowRepository.save(cow);

        return CowDto(
            id = cow.id,
            collarId = cow.collarId,
            cowNumber = cow.cowNumber,
            collarStatus = if (collarStatus.healthy) "Healthy" else "Broken",
            // TODO: Lat/Long should always be Doubles inside collar status by default
            lastLocation = GeoLocation(collarStatus.lat.toDouble(), collarStatus.lng.toDouble())
        )
    }
}
