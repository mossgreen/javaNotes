package com.Moss;

import com.Moss.template.Cook;
import com.Moss.template.Gardener;
import com.Moss.template.Worker;

public class Main {

    public static void main(String[] args) {
	    //template pattern

        Worker gardener = new Gardener();
        gardener.work();

        Worker cook = new Cook();
        cook.work();
    }
}
