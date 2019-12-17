package patterns.template;

import patterns.template.Worker;

public class Gardener extends Worker {

    @Override
    void init() {
        System.out.println("Hi, I'm a gardener.");
    }

    @Override
    void startWorking() {
        System.out.println("A gardener starts gardening.");
    }

    @Override
    void finishWorking() {
        System.out.println("A gardener completes his work.");
    }
}
