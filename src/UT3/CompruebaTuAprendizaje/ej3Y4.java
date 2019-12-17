package UT3.CompruebaTuAprendizaje;

import java.io.*;
import java.util.ArrayList;

public class ej3Y4 {

    public static void main(String[] args) throws IOException {

        ArrayList<File> ficheros = new ArrayList<>();
        File f1 = new File("prueba1.txt");
        File f2 = new File("prueba2.txt");
        File f3 = new File("prueba3.txt");


        ficheros.add(f1);
        ficheros.add(f2);
        ficheros.add(f3);


        for (File i : ficheros){
            procesoLibro x = new procesoLibro(i);
            x.start();
        }


    }


    static class procesoLibro extends Thread{
        File f;
        int cuenta = 0;
        long comienzo = 0;
        long fin = 0;
        long tiempo = 0;

        procesoLibro(File f){
            this.f = f;
        }

        @Override
        public void run() {
            try {

                this.comienzo = System.currentTimeMillis();

                FileReader fr = new FileReader(f);
                int i;
                while ((i=fr.read()) != -1)
                    if((char)i == ' ' || (char)i == '\n')
                        cuenta++;

                if(cuenta == 0){
                    fr = new FileReader(f);
                    if (fr.read()!=-1)cuenta++;
                }

                this.fin = System.currentTimeMillis();
                System.out.println("El proceso "+getId()+" a tardado "+(this.fin-this.comienzo)+" milisegudos el fichero "+f.getName()+" tiene "+cuenta+" caracteres");
            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }




}
