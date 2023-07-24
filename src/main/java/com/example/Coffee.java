package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Embeddable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@Serdeable
public class Coffee {
    private String color;
    private String somethingElse;

    @Nullable
    private Object temperature;
}