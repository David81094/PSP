package UT4;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

import java.io.IOException;
import java.net.SocketException;

public class ClienteSMTP {

    public static void main(String[] args) {
        SMTPClient client = new SMTPClient();
        try {
            int respuesta;

            client.connect("localhost");
            System.out.print(client.getReplyString());
            respuesta = client.getReplyCode();

            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                System.err.println("CONEXION RECHAZADA.");
                System.exit(1);
            }

            client.disconnect();

        } catch (IOException e) {
            System.err.println("NO SE PUEDE CONECTAR AL SERVIDOR.");
            e.printStackTrace();
            System.exit(2);
        }

    }
}
