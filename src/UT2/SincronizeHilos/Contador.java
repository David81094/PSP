package UT2.SincronizeHilos;

public class Contador {

    private int c = 0;

    Contador(int c){
        this.c = c;
    }

    public void incrementa(){
        c += 1;
    }

    public void decrementa(){
        c-= 1;
    }

    public int valor(){
        return c;
    }

}
