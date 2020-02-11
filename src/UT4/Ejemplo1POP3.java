package UT4;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.IOException;

public class Ejemplo1POP3 {


    public static void main(String[] args) {

        String server = "localhost", username = "usu1", password="usu1";
        int puerto = 110;

        POP3Client pop3 = new POP3Client();
        try {
            pop3.connect(server,puerto);
            System.out.println("Conexion realizada al servidor POP3 "+server);

            if (!pop3.login(username,password))
                System.out.println("Error en el login");
            else{
                POP3MessageInfo[] men = pop3.listMessages();

                if (men == null)
                    System.out.println("Imposible recuperar mensajes");
                else
                    System.out.println("Nº de mensajes: "+men.length);

                pop3.logout();
            }


        }catch (IOException e){e.printStackTrace();}

    }
}
