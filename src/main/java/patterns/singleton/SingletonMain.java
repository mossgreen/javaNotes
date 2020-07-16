package patterns.singleton;

public class SingletonMain {

    public static void main(String args[]) {

        EagerSingleTon instance1 = EagerSingleTon.getInstance();
        EagerSingleTon instance2 = EagerSingleTon.getInstance();

        System.out.println(instance1 == instance2); // true

        IoDHSingleton instance3 = IoDHSingleton.getInstance();
        IoDHSingleton instance4 = IoDHSingleton.getInstance();

        System.out.println(instance3 == instance4); // true
    }
}
