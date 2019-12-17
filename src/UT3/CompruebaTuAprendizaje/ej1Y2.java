package UT3.CompruebaTuAprendizaje;

public class ej1Y2 {

    public static void main(String[] args) {

        //hilo hilo1 = new hilo();
        //hilo1.start();

        for (int i=0; i<5;i++) {
            Thread h = new Thread(new hilo2("H"+i));
            h.start();
        }

    }


    static class hilo2 implements Runnable{
        String cadena;

        public hilo2(String cadena){
            this.cadena = cadena;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(Thread.currentThread().getId());
                System.out.println("Hola mundo \n"+this.cadena+" ID:"+Thread.currentThread().getId());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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