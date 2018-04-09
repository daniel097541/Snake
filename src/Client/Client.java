package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args){

        String NombreHost= "localhost";
        Socket socketDatos = null;
        PrintWriter escribirServidor = null;
        BufferedReader leerServidor = null;

        try {
            String serverAddress = JOptionPane.showInputDialog("Por favor introduzca la IP del servidor al que te quieres conectar");
            socketDatos = new Socket(serverAddress, 2000);
            escribirServidor = new PrintWriter(socketDatos.getOutputStream(), true);
            leerServidor = new BufferedReader(new InputStreamReader(socketDatos.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("No encuentro el host: " + NombreHost);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No puedo enlazar la entrada/salida " + "en la conexión a: " + NombreHost);
            System.exit(1);
        }

        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print ("entrada cliente 2: ");
            String linea = teclado.readLine();

            while (!(linea.equals("x"))) {
                escribirServidor.println(linea);
                System.out.println("eco: " + leerServidor.readLine());
                System.out.print ("entrada cliente 2: ");
                linea = teclado.readLine();
            }

            System.out.println("Terminando el cliente");

            escribirServidor.close();
            leerServidor.close();
            teclado.close();
            socketDatos.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
