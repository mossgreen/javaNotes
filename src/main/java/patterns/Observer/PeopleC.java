package patterns.Observer;

public class PeopleC implements People{
    @Override
    public void update(News news) {
        System.out.println("doesn't care");
    }
}
