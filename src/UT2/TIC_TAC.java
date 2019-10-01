package UT2;

public class TIC_TAC {
    public static void main(String[] args) {
        Tic tic = new Tic(4);
        Tac tac = new Tac(2);
        tic.start();
        tac.start();
    }
}

class Tic extends Thread {

    private int hilo;

    public Tic(int hilo) {
        this.hilo = hilo;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("TIC");
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


class Tac extends Thread {

    private int hilo;

    public Tac(int hilo) {
        this.hilo = hilo;
    }

    @Override
    public void run() {
        while (true){
            try {

                System.out.println("TAC");
                sleep(1000);
                yield();

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
