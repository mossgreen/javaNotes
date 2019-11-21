package com.patterns;


import com.patterns.template.Cook;
import com.patterns.template.Gardener;
import com.patterns.template.Worker;

public class Main {

    public static void main(String[] args) {
	    //template pattern

        Worker gardener = new Gardener();
        gardener.work();

        Worker cook = new Cook();
        cook.work();
    }
}
