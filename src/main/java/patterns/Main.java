package patterns;

import patterns.template.Cook;
import patterns.template.Gardener;
import patterns.template.Worker;

public class Main {

    public static void main(String[] args) {
	    //template pattern

        Worker gardener = new Gardener();
        gardener.work();

        Worker cook = new Cook();
        cook.work();
    }
}
