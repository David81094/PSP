package UT2.ProductoConsumidor;

public class Productor extends Thread {

    private Cola cola;
    private int n;

    public Productor(Cola cola, int n) {
        this.cola = cola;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            cola.put(i);
            System.out.println(i + " => Productor: " + n + ", produce: " + i);
        }
    }
}
