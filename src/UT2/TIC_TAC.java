package UT2;

public class TIC_TAC {
    public static void main(String[] args) {
        Tic tic = new Tic();
        Tac tac = new Tac();
        tic.start();
        tac.start();
    }
}

class Tic extends Thread {

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

    @Override
    public void run() {
        while (true){
            try {

                System.out.println("TAC");
                sleep(1000);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
