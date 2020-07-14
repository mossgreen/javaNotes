package patterns.strategy;

public interface FlyBehavior {
    public void fly();
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I cannot fly");
    }
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("flying with wings");
    }
}

class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}

