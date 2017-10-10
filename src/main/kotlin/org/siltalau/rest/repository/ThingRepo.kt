package org.siltalau.rest.repository

import org.siltalau.rest.model.Thing
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ThingRepo: ReactiveMongoRepository<Thing, String>