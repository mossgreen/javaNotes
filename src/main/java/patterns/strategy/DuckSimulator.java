package patterns.strategy;

public class DuckSimulator {

    public static void main(String[] args) {
        final MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly(); //flying with wings
        mallardDuck.performQuack(); //real Quack

        FlyBehavior flyBehavior = () -> System.out.println("I cannot fly");
        QuackBehavior quackBehavior = () -> System.out.println("I cannot quack");

        final RubberDuck rubberDuck = new RubberDuck(flyBehavior, quackBehavior);
        rubberDuck.performFly();
        rubberDuck.performQuack();

        final DecoyDuck decoyDuck = new DecoyDuck();
        decoyDuck.performFly();
        decoyDuck.performQuack();
        decoyDuck.setFlyBehavior(new FlyRocketPowered());
        decoyDuck.performFly();
    }
}
