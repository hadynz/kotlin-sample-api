package halter.interview.herdservice.infrastructure.cows;

import halter.interview.herdservice.domain.cows.Cow

interface ICowRepository {
    fun find(cow: Cow): Cow
    fun exists(cow: Cow): Boolean
    fun save(product: Cow)
}

