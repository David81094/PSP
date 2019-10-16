package UT2.CajeraEjercicio;

public class Persona extends Thread{

    // Propiedades
    private String nombre;
    private int numCliente;
    private Cuenta cuenta;

    // Constructor
    public Persona(String nombre, int numCliente, Cuenta cuenta){
        this.nombre = nombre;
        this.numCliente = numCliente;
        this.cuenta = cuenta;
    }

    // Métodos
    public void run(){
        while(true){
            try {
                cuenta.ingresar(generarCifra(), numCliente, this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                Thread.sleep(300);
            }
            catch(InterruptedException e){}

            try {
                cuenta.retirar(generarCifra(), numCliente, this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                Thread.sleep(300);
            }
            catch(InterruptedException e){}
        } // Fin while
    } // Fin run

    public int generarCifra(){
        return (int) (Math.random()*500+1);
    }

    public String getNombre(){
        return nombre;
    }
}

