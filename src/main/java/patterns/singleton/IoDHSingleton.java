package patterns.singleton;

// initialization demand holder
public class IoDHSingleton {
    private IoDHSingleton(){}

    // inner class
    private static class HolderClass{
        private final static IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }
}
