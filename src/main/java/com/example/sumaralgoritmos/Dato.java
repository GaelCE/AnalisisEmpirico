package com.example.sumaralgoritmos;

public class Dato {
    private int n;
    private long time;
    private long sumatoria;

    public Dato(int n,long time,long sumatoria){
        this.n=n;
        this.time=time;
        this.sumatoria=sumatoria;
    }

    public int getN(){
        return n;
    }

    public long getTime(){
        return time;
    }

    public long getSumatoria(){
        return sumatoria;
    }
}
