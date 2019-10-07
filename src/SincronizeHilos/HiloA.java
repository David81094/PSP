package SincronizeHilos;

public class HiloA extends Thread{

    private ContadorSincronizado contador;

    public HiloA(String n, ContadorSincronizado c){
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 300; j++){
            contador.incrementa();
            try {
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "contador vale " + contador.valor());
    }
}
