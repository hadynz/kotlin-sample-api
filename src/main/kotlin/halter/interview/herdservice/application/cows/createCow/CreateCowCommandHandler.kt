package halter.interview.herdservice.application.cows.createCow

import halter.interview.herdservice.application.cows.CowDto
import halter.interview.herdservice.domain.cows.Cow
import halter.interview.herdservice.domain.cows.CreateCowCommand
import halter.interview.herdservice.domain.cows.StubbedProductRepository

class CreateCowCommandHandler {
    private val cowRepository = StubbedProductRepository();

    fun handle(command: CreateCowCommand): CowDto {
        var cow = Cow(command)

        if (cowRepository.exists(cow)) {
            throw RuntimeException("Cow already exists: ${cow.id}");
        }

        cowRepository.save(cow);

        return CowDto(
            id = cow.id,
            collarId = cow.collarId,
            cowNumber = cow.cowNumber,
            collarStatus = "Healthy"
        )
    }
}
