package halter.interview.herdservice.application.cows.createCow

import halter.interview.herdservice.application.cows.CowDto
import halter.interview.herdservice.domain.cows.Cow
import halter.interview.herdservice.domain.cows.CreateCowCommand

class CreateCowCommandHandler {
    fun handle(command: CreateCowCommand): CowDto {
        var cow = Cow(command)

        return CowDto(
            collarId = cow.collarId,
            cowNumber = cow.cowNumber,
        )
    }
}
