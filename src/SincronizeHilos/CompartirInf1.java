package SincronizeHilos;

public class CompartirInf1 {

    public static void main(String[] args) {
        ContadorSincronizado c = new ContadorSincronizado(100);
        HiloA a = new HiloA("HiloA", c);
        HiloB b = new HiloB("HiloB", c);

        a.start();
        b.start();

    }
}
