package UT2.CajeraEjercicio;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(2000, 10000);
        Persona p = new Persona("Ana", 1, cuenta);
        p.start();
    }
}
