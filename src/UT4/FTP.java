package UT4;

import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FTP implements ActionListener {

    private static FTP app;
    FTPClient client;

    public FTP(){

    }

    public static FTP getApp(){
        if (app == null){
            app = new FTP();
        }
        return app;
    }


    public static void main(String[] args) {
        getApp();

        String servidor = "localhost";
        String user = "usuario1";
        String pasw = "usuario1";

        try {
            app.client = new FTPClient();
            app.client.enterLocalPassiveMode();
            app.client.connect(servidor);
            boolean login = app.client.login(user, pasw);

            if (login){
                System.out.println("CONECTADO");

                View view = new View(app);
            }else{
                //ventana
                JOptionPane.showMessageDialog(null,
                        "No se ha podido conectar con el servidor",
                        "SERVER ERROR",
                        JOptionPane.WARNING_MESSAGE);
            }



//            app.client.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (Exception e) { e.printStackTrace();
        }



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (actionEvent.getActionCommand()){

            case "subir":

                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.showOpenDialog(new JFrame("Selcciona un fichero"));


                File selectedFile = chooser.getSelectedFile();
                if (selectedFile == null) {
                    JOptionPane.showMessageDialog(null,
                            "No se ha seleccionado ningun fichero",
                            "Selecciona un Fichero.",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("No file selected!");
                }
                else {
                    try {
                        String directorio = selectedFile.getParent().replaceAll("C:","");

                        if (!(app.client.changeWorkingDirectory(directorio))){
                            System.out.println(directorio);
                            if (client.makeDirectory(directorio)){
                                client.changeWorkingDirectory(directorio);

                            }else {
                                System.out.println("ERROR AL  CREAR EL DIRECTORIO");
                                JOptionPane.showMessageDialog(null,
                                        "Error al crear el directorio",
                                        "ERROR.",
                                        JOptionPane.WARNING_MESSAGE);

                                //ventana no se ha podido crear el directorio
                                System.exit(0);
                            }
                        }

                        BufferedInputStream in = new BufferedInputStream(new FileInputStream(selectedFile));
                        if (client.storeFile(selectedFile.getName()+" NUEVO",in)){
                            System.out.println("SUBIDO");

                            JOptionPane.showMessageDialog(null,
                                    "Fichero subido con exito",
                                    "",
                                    JOptionPane.WARNING_MESSAGE);
                            //ventana se ha subido
                        }else {
                            System.out.println("ERROR AL SUBIR");
                            //ventana no se ha subido
                        }
                        in.close();

                    } catch (IOException e) {e.printStackTrace();}
                }



                break;

            case "bajar":
                System.out.println("entras");

                chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.showOpenDialog(new JFrame("Selcciona un fichero"));

                selectedFile = chooser.getSelectedFile();
                if (selectedFile == null) {
                    JOptionPane.showMessageDialog(null,
                            "No se ha seleccionado ningun fichero",
                            "Selecciona un Fichero.",
                            JOptionPane.WARNING_MESSAGE);

                    System.out.println("No file selected!");
                }
                else {
                    try {
                        client.changeWorkingDirectory(selectedFile.getParent().replaceAll("C:",""));
                        BufferedOutputStream out = new BufferedOutputStream(
                                new FileOutputStream(selectedFile+" NUEVO"));

                        if (client.retrieveFile(selectedFile.getName(),out)){
                            JOptionPane.showMessageDialog(null,
                                    "Fichero descargado con exito",
                                    "",
                                    JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "No se ha podido descargar el fichero",
                                    "ERROR",
                                    JOptionPane.WARNING_MESSAGE);
                        }

                        out.close();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,
                                "Error al cambiar de directorio",
                                "ERROR.",
                                JOptionPane.WARNING_MESSAGE);
                        e.printStackTrace();
                    }


                }



                break;
        }

    }
}
