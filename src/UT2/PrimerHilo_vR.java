package UT2;

public class PrimerHilo_vR implements Runnable {
    private int x;

    PrimerHilo_vR (int x)
    {
        this.x=x;
    }

    public void run() {
        for (int i=0; i<x;i++)
            System.out.println("En el Hilo... "+i);
    }
}
