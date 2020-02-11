package UT4;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

import java.io.IOException;

public class EnviarCorreo {


    public static void main(String[] args) {

        String server;
        String username;
        String password;
        int puerto;
        String remitente;
        String destinatario;


        server = "smtp.gmail.com";
        username = "usu1";
        password = "usu1";
        puerto  = 587;
        remitente = "usu1@localhost";
        destinatario = "alexisruizgomez96@gmail.com";


       /* System.out.println("Introduce servidor SMTP.........:");
        System.out.println("Necesita negociación TLS (S, N)?:");
        System.out.println("Introduce usuario...............:");
        System.out.println("Introduce password..............:");
        System.out.println("Introduce puerto................:");
        System.out.println("Introduce correo del remitente..:");
        System.out.println("Introduce correo destinatario...:");
        System.out.println("Introduce asunto................:");
        System.out.println("Introduce el mensaje, finalizará cuando se introduzca un * :");*/


        SMTPClient c = new SMTPClient();

        try {
            c.connect("localhost");
            int respuesta = c.getReplyCode();

            if (!SMTPReply.isPositiveCompletion(respuesta)){
                c.disconnect();
                System.out.println("CONEXION RECHAZADA");
                System.exit(1);
            }
            c.login();

            if (c.sendSimpleMessage(remitente,destinatario,"prueba de mensaje")){
                System.out.println("Mensaje enviado a "+destinatario);
            }else {
                System.out.println("No se ha podido enviar");
            }

            c.logout();

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
