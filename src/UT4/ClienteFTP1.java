package UT4;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class ClienteFTP1 {

    public static void main(String[] args) throws IOException {

        FTPClient cliente = new FTPClient();

        // Servidor FTP
        String servFTP = "ftp.rediris.es";
        System.out.println("Nos conectamos a: " + servFTP);
        cliente.connect(servFTP);

        // Respuesta del servidor FTP
        System.out.println(cliente.getReplyString());

        // Codigo de respuesta
        int respuesta = cliente.getReplyCode();
        System.out.println("Respuesta:" + respuesta);

        // Comprobacion del codigo de respuesta
        if(!FTPReply.isPositiveCompletion(respuesta)) {
            cliente.disconnect();
            System.out.println("Conexion rechazada: " + respuesta);
            System.exit(0);
        }

        // Desconexion del servidor FTP
        cliente.disconnect();
        System.out.println("Conexion finalizada");
    }

}
