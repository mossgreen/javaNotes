package com.serverless.function;

import com.serverless.model.Model;

import java.util.function.Function;

public class Uppercase implements Function<Model, Model> {
    @Override
    public Model apply(Model model) {
        String upperCase = model.getValue().toUpperCase();
        model.setValue(upperCase);
        return model;
    }
}
