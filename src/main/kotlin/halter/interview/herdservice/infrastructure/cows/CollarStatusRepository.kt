package halter.interview.herdservice.infrastructure.cows

import halter.interview.herdservice.domain.cows.CollarStatus
import halter.interview.herdservice.domain.cows.Cow
import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class CollarStatusRepository : ICollarStatusRepository {
    private val client = HttpClient(Java) {
        install(JsonFeature)
    }

    private val collarStatusUrl =
        { cow: Cow -> "https://5d96585ca824b400141d26b2.mockapi.io/halter/device/${cow.collarId}/status" };

    /**
     * TODO: Handle the following error scenarios:
     * - bad collar status, and no results found from endpoint
     * - invalid or bad response from endpoint
     * - retry with backoff strategy if endpoint is unreachable (needs Product input)
     */
    override suspend fun getCollarStatus(cow: Cow): CollarStatus {
        var collars: List<CollarStatus> = client.request(collarStatusUrl(cow))

        /**
         * TODO: Need to implement a deserializer that will always parse `timestamp`
         * to a Date or Timestamp object and then sort to retrieve latest date
         */
        return collars[0];
    }
}