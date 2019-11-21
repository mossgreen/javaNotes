package com.patterns.template;

public class Cook extends Worker {
    @Override
    void init() {
        System.out.println("Hi, I'm a cook.");
    }

    @Override
    void startWorking() {
        System.out.println("A cook starts cooking.");
    }

    @Override
    void finishWorking() {
        System.out.println("A cook completes cooking.");
    }
}
