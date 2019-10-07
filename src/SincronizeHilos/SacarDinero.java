package SincronizeHilos;

public class SacarDinero extends Thread {

    private Cuenta c;
    String nom;

    public SacarDinero(String nom, Cuenta c) {
        this.nom = nom;
        this.c = c;
    }

    @Override
    public void run() {
        for (int x = 0; x <= 4; x++){
            c.retirarDiner(10, getName());
        }
    }
}
