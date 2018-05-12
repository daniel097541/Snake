package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import Model.Player;
import Model.SnakePanel;
import View.GameView;
import View.ServerIPView;
import View.StartView;

public class Client {

    public static void main(String[] args){

        String hostName= "localhost";
        Socket dataShocket = null;
        PrintWriter serverWrrite = null;
        BufferedReader serverRead = null;
        
        
        try {
            ServerIPView ipView = new ServerIPView();
            dataShocket = new Socket(ipView.getIp(), 7000);
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
            //Habria que mandar el jugador al SnakePanel del servidor snakepanel.getPlayers.add(player);
            //StartView view = new StartView(3);
            //SnakePanel s = new SnakePanel();
            //s.start();
            String linea = "bla";
            while (!(linea.equals("x"))) {
                /*
                if(linea.equals("pausar")){
                    s.setPausa(true);
                }
                if(linea.equals("reanudar")){
            
                s.setPausa(false);
                }
                */
                serverWrrite.println("hola");
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
