package patterns.observer;

public class NewsSubject implements Subject {
    @Override
    public void update() {
        for (People p : peopleList) {
            News news = new News();
            news.setContent("Covid-19 is here");
            news.setTitle("Covid-19 news");
            p.update(news);
        }
    }
}
