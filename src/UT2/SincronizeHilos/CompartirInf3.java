package UT2.SincronizeHilos;

public class CompartirInf3 {

    public static void main(String[] args) {
        Cuenta c = new Cuenta(50);
        SacarDinero h1 = new SacarDinero("Ana", c);
        SacarDinero h2 = new SacarDinero("Juan", c);

        h1.start();
        h2.start();
    }
}