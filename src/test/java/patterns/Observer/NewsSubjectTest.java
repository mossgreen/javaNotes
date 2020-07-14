package patterns.Observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsSubjectTest {

    @Test
    public void testObserver() {
        Subject subject = new NewsSubject();
        subject.add(new PeopleA());
        subject.add(new PeopleB());
        subject.add(new PeopleC());
        subject.update();
    }

}
