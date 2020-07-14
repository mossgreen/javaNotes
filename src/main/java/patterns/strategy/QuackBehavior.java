package patterns.strategy;

import java.util.function.DoubleToIntFunction;

public interface QuackBehavior {
    public void quack();
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("silent quack");
    }
}

class FakeQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quaeeeeawk");
    }
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("real Quack");
    }
}

