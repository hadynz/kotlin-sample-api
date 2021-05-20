package halter.interview.herdservice.domain.cows;

interface CowRepository {
    fun find(cow: Cow): Cow
    fun exists(cow: Cow): Boolean
    fun save(product: Cow)
}

class StubbedProductRepository : CowRepository {
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

    fun clear() {
        cows.clear()
    }
}
