package patterns.Observer;

public class PeopleA implements People{
    @Override
    public void update(News news) {
        System.out.println("bad news");
    }
}
