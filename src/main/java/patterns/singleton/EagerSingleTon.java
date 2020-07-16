package patterns.singleton;

public class EagerSingleTon {
    private static final EagerSingleTon instance = new EagerSingleTon();

    private EagerSingleTon() { }

    public static EagerSingleTon getInstance() {
        return instance;
    }
}
