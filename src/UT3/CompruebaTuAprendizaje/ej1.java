package UT3.CompruebaTuAprendizaje;

public class ej1 {

    public static void main(String[] args) {

        hilo hilo1 = new hilo();
        hilo1.start();

        for (int i=0; i<5;i++) {
            Thread h = new Thread(new ej1.hilo());
            h.start();
        }

    }

    static class hilo extends Thread {

        @Override
        public void run() {
            for (int i=0;i<5; i++)
                System.out.println("Hola mundo "+this.getId());
        }
    }
}
