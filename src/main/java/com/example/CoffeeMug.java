package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.core.annotation.Nullable;
import org.bson.types.ObjectId;

@MappedEntity(value = CoffeeMug.COFFEE_MUG_COLLECTION_NAME)
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

    public CoffeeMug(final ObjectId id, final String size, final Boolean filled, final @Nullable String name, final Coffee coffee) {
        this.id = id;
        this.size = size;
        this.filled = filled;
        this.coffee = coffee;
    }

    public ObjectId getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Boolean getFilled() {
        return filled;
    }

    public String getName() {
        return name;
    }

    public Coffee getCoffee() {
        return coffee;
    }
}
