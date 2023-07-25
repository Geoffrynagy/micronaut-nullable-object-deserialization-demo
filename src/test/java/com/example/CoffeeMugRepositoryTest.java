package com.example;

import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(startApplication = false)
class CoffeeMugRepositoryTest {

    @Inject
    CoffeeMugRepository repository;

    @Test
    void givenCoffeeMugWithSomePropertiesAsNull_whenFindById_thenDeserializationIsSuccess() {
        // GIVEN
        final Coffee coffee = new Coffee("black", "bla",null);

        final ObjectId id = ObjectId.get();
        final CoffeeMug coffeeMug = new CoffeeMug(id, "large", true, null, coffee);
        repository.save(coffeeMug);

        // WHEN
        final Optional<CoffeeMug> actual = repository.findById(id);

        // THEN
        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(coffeeMug);
        assertThat(actual.get().getName()).isNull();
        assertThat(actual.get().getSize()).isEqualToIgnoringCase("large");
        assertThat(actual.get().getFilled()).isTrue();
        assertThat(actual.get().getCoffee()).isNotNull();
        assertThat(actual.get().getCoffee().getColor()).isEqualToIgnoringCase("black");
        assertThat(actual.get().getCoffee().getSomethingElse()).isEqualToIgnoringCase("bla");
        assertThat(actual.get().getCoffee().getTemperature()).isNull();
    }

    @Test
    void givenCoffeeMugWithAllPropertiesSet_whenFindById_thenDeserializationIsSuccess() {
        // GIVEN
        final Coffee coffee = new Coffee("black", "bla", List.of(1,2,3));

        final ObjectId id = ObjectId.get();
        final CoffeeMug coffeeMug = new CoffeeMug(id, "large", true, null, coffee);
        repository.save(coffeeMug);

        // WHEN
        final Optional<CoffeeMug> actual = repository.findById(id);

        // THEN
        assertThat(actual).isPresent();
        assertThat(actual.get().getName()).isNull();
        assertThat(actual.get().getSize()).isEqualToIgnoringCase("large");
        assertThat(actual.get().getFilled()).isTrue();
        assertThat(actual.get().getCoffee()).isNotNull();
        assertThat(actual.get().getCoffee().getColor()).isEqualToIgnoringCase("black");
        assertThat(actual.get().getCoffee().getSomethingElse()).isEqualToIgnoringCase("bla");
        assertThat(actual.get().getCoffee().getTemperature()).isEqualTo(List.of(1,2,3));
    }
}
