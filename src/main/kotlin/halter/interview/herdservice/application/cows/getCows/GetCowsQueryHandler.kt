package halter.interview.herdservice.application.cows.getCows

import halter.interview.herdservice.application.cows.CowDto
import halter.interview.herdservice.domain.cows.Cow
import halter.interview.herdservice.domain.cows.CreateCowCommand

class GetCowsQueryHandler {
    fun handle(command: CreateCowCommand): CowDto {
        println("Filling")
        var cow = Cow(command)

        return CowDto(
            id = cow.id,
            collarId = cow.collarId,
            cowNumber = cow.cowNumber,
            collarStatus = cow.collarStatus.toString()
        )
    }
}
