package UT2;

public class PrimerHilo_v1 extends Thread {
    private int x;

    PrimerHilo_v1 (int x)
    {
        this.x=x;
    }

    public void run() {
        for (int i=0; i<x;i++)
            System.out.println("En el Hilo... "+i);
    }

    public static void main(String[] args) {
        PrimerHilo_v1 p = new PrimerHilo_v1 (10);
        p.start();
    }
}
