package halter.interview.herdservice.infrastructure.cows

import halter.interview.herdservice.domain.cows.CollarStatus
import halter.interview.herdservice.domain.cows.Cow

interface ICollarStatusRepository {
    suspend fun getCollarStatus(cow: Cow): CollarStatus
}