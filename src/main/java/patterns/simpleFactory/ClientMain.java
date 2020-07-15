package patterns.simpleFactory;

public class ClientMain {

    public static void main(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram");
        chart.display();

        chart = ChartFactory.getChart("pie");
        chart.display();

        chart = ChartFactory.getChart("line");
        chart.display();
    }
}
