package UT2;

public class PinPong {
    public static void main(String[] args) {
        Ping p = new Ping();
        Pong po = new Pong();
        p.start();
        po.start();
    }
}

class Ping extends Thread {

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("Ping");
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


class Pong extends Thread {

    @Override
    public void run() {
        while (true){
            try {

                System.out.println("Pong");
                sleep(1000);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

