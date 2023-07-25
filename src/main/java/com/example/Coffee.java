package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Embeddable;
import io.micronaut.serde.annotation.Serdeable;

@Embeddable
@Serdeable
public class Coffee {
    private String color;
    private String somethingElse;

    @Nullable
    private Object temperature;

    public Coffee(final String color, final String somethingElse, final @Nullable Object temperature) {
        this.color = color;
        this.somethingElse = somethingElse;
        this.temperature = temperature;
    }

    public String getColor() {
        return color;
    }

    public String getSomethingElse() {
        return somethingElse;
    }

    public Object getTemperature() {
        return temperature;
    }
}