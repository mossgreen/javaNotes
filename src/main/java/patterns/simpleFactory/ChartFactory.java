package patterns.simpleFactory;

public class ChartFactory {

    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("initializing histogram chart");
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("initializing pie chart");
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("initializing line chart");
        }

        return chart;
    }
}
