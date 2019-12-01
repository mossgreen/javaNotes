package com.serverless.controller;

import com.serverless.model.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class Controller {

    @Bean
    public Function<String, String> function() {
        return input -> input;
    }

    @Bean
    public Consumer<String> consume() {
        return input -> System.err.println("Input-" + input);
    }

    @Bean
    public Supplier<String> supply() {
        return () -> "Hello from supplier";
    }

    @Bean
    public Function<Model, Model> reverseString() {
        return model -> {
            String reverseString = new StringBuilder(model.getValue()).reverse().toString();
            model.setValue(reverseString);
            return model;
        };
    }
}
