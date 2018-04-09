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

        String hostName= "localhost";
        Socket dataShocket = null;
        PrintWriter serverWrrite = null;
        BufferedReader serverRead = null;

        try {
            String serverAddress = JOptionPane.showInputDialog("Por favor introduzca la IP del servidor al que te quieres conectar");
            dataShocket = new Socket(serverAddress, 2000);
            serverWrrite = new PrintWriter(dataShocket.getOutputStream(), true);
            serverRead = new BufferedReader(new InputStreamReader(dataShocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("No encuentro el host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No puedo enlazar la entrada/salida " + "en la conexión a: " + hostName);
            System.exit(1);
        }

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print ("entrada cliente 2: ");
            String linea = input.readLine();

            while (!(linea.equals("x"))) {
                serverWrrite.println(linea);
                System.out.println("eco: " + serverRead.readLine());
                System.out.print ("entrada cliente 2: ");
                linea = input.readLine();
            }

            System.out.println("Terminando el cliente");

            serverWrrite.close();
            serverRead.close();
            input.close();
            dataShocket.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
