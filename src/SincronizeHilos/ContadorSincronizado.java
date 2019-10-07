package SincronizeHilos;

public class ContadorSincronizado {

    private int c = 0;

    public ContadorSincronizado(int c) {
        this.c = c;
    }

    public synchronized void incrementa(){
        c++;
    }

    public synchronized void decrementa(){
        c--;
    }

    public synchronized int valor(){
        return c;
    }
}
