package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<People> peopleList = new ArrayList<>();

    default void add(People people) {
        peopleList.add(people);
    }

    default void remove(People people) {
        peopleList.remove(people);
    }

    void update();
}
