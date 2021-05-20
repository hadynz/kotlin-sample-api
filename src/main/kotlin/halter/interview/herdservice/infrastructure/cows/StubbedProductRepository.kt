package halter.interview.herdservice.infrastructure.cows

import halter.interview.herdservice.domain.cows.Cow

class StubbedProductRepository : ICowRepository {
    private val cows = mutableMapOf<String, Cow>()

    override fun find(cow: Cow): Cow {
        return cows[cow.collarId] ?: throw RuntimeException("Cow not found: collarId=${cow.collarId}")
    }

    override fun exists(cow: Cow): Boolean {
        return cows.containsKey(cow.collarId)
    }

    override fun save(cow: Cow) {
        cows[cow.collarId] = cow
    }
}