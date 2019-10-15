package UT2.ProductoConsumidor;

public class Cola {
    private int numero;
    private boolean disponible = false;

    public synchronized int get(){
        while (!disponible){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        disponible = false;
        notify();
        return numero;
    }

    public synchronized void put(int valor){
        while (disponible){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        numero = valor;
        disponible = true;
        notify();
    }
}
