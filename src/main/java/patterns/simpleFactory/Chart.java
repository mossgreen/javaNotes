package patterns.simpleFactory;

public interface Chart {
    public void display();
}

class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("creating histogram chart");
    }

    @Override
    public void display() {
        System.out.println("displaying histogram chart");
    }
}

class PieChart implements Chart{

    public PieChart() {
        System.out.println("creating pi chart");
    }

    @Override
    public void display() {
        System.out.println("displaying pie chart");
    }
}

class LineChart implements Chart {
    public LineChart() {
        System.out.println("creating line chart");
    }

    @Override
    public void display() {
        System.out.println("displaying line chart");
    }
}



