package com.example;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.function.aws.MicronautRequestHandler;

public class FunctionRequestHandler extends MicronautRequestHandler<SQSEvent, Void> {

    @Override
    public Void execute(final SQSEvent input) {
        return null;
    }
}