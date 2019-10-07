package EjemploSupermercadoThread;

public class CajeraThread extends Thread {

    private String nombre;
    private ClienteThread c;
    private long time;

    public CajeraThread(String nombre, ClienteThread c, long time) {
        this.nombre = nombre;
        this.c = c;
        this.time = time;
    }


    public void run() {
        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del cliente: " + c.getNombre() + ", en el tiempo " + (System.currentTimeMillis() - time) / 1000 + "seg");

        for (int i = 0; i < c.getCarroCompra().length; i++) {
            this.esperarXSegundos(c.getCarroCompra()[i]);
            System.out.println("Procesado el producto: " + (i + 1) + " del cliente: " + c.getNombre() + ", tiempo: " + (System.currentTimeMillis() - time) / 1000 + "seg");
        }

        System.out.println("La cajera: " + this.nombre + " ha terminado de procesar, " + c.getNombre() + " en el tiempo " + (System.currentTimeMillis() - time) / 1000 + "seg");

    }

    private void esperarXSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
