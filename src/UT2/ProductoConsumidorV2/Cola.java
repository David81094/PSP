package UT2.ProductoConsumidorV2;

public class Cola {
    private int numero;
    private boolean disponible = false;
    private int turno = 1;

    public synchronized int get(int i, int n){
        while (!disponible || n != turno) {
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        disponible = false;

        if(turno == 1) {
            turno = 2;
        } else {
            turno = 1;
        }

        notifyAll();
        System.out.println(i + " => Consumidor: " + n + ", consume: " + numero);
        return numero;
    }

    public synchronized void put(int valor, int n){
        while (disponible || n != turno){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        numero = valor;
        System.out.println(numero + " => Productor: " + n + ", produce: " + numero);

        disponible = true;
        notifyAll();
    }
}
