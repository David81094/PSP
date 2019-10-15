package UT2.EjemploSupermercadoThread;

public class ClienteThread {

    private String nombre;
    private int[] carroCompra;

    public ClienteThread(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }
}
