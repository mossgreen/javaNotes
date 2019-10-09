package com.Moss.template;

public abstract class Worker {

    abstract void init();
    abstract void startWorking();
    abstract void finishWorking();

    public final void work(){
        this.init();
        this.startWorking();
        this.finishWorking();
    }
}
