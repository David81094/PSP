package SincronizeHilos;

public class HiloB extends Thread{

    private ContadorSincronizado contador;

    public HiloB(String n, ContadorSincronizado c){
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 300; j++){
            contador.decrementa();
            try {
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "contador vale " + contador.valor());
    }
}
