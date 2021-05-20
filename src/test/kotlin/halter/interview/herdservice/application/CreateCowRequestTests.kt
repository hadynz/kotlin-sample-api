package halter.interview.herdservice.application

import halter.interview.herdservice.httpapi.routes.CreateCowRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CreateCowRequestTests {
    @Test
    fun validCowRequest() {
        var cow = CreateCowRequest("123", "456");
        assertEquals("123", cow.collarId)
        assertEquals("456", cow.cowNumber)
    }
}