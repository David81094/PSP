package UT2.EjemploSupermercado;

public class Cajera {

    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del cliente: " + cliente.getNombre() + ", en el tiempo " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto: " + (i + 1) + ", tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }

        System.out.println("La cajera: " + this.nombre + " ha terminado de procesar, " + cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
