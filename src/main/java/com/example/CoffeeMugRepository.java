package com.example;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface CoffeeMugRepository extends CrudRepository<CoffeeMug, ObjectId> {
}
