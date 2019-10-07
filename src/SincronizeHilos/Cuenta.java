package SincronizeHilos;

public class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    int getSaldo(){
        return saldo;
    }

    void restart(int cantidad){
        saldo = saldo - cantidad;
    }

    synchronized void retirarDiner(int cant, String nombre){
        if(getSaldo() >= cant){
            System.out.println("Se va a retirar saldo, (ACTUAL ES: " + getSaldo() + ")");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restart(cant);

            System.out.println("\t" + nombre + " retira: " + cant + " ACTUAL: " + getSaldo());
        } else {
            System.out.println(nombre + " No puede retirar dinero, no hay saldo: " + getSaldo());
        }

        if(getSaldo() < 0 ){
            System.out.println("Saldo negativo: " + getSaldo());
        }
    }
}
