package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.core.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@MappedEntity(value = CoffeeMug.COFFEE_MUG_COLLECTION_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
public class CoffeeMug {

    protected static final String COFFEE_MUG_COLLECTION_NAME = "CoffeeMug";


    @Id
    ObjectId id;

    private String size;
    private Boolean filled;

    @Nullable
    private String name;

    private Coffee coffee;
}
