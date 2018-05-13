package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import View.ServerIPView;

public class Client extends Thread{


    private static Socket dataSoket;
    private static InputStream input;
    private static OutputStream output;
    private final String HOST_NAME = "localhost";
    private PrintWriter serverWrrite = null;
    BufferedReader serverRead = null;

    public static void main(String[] args){
        new Client();
    }


    private Client() {
        try {
            ServerIPView ipView = new ServerIPView();
            dataSoket = new Socket(ipView.getIp(), 7000);
            input = dataSoket.getInputStream();
            output = dataSoket.getOutputStream();
            serverWrrite = new PrintWriter(output, true);
            serverRead = new BufferedReader(new InputStreamReader(input));
        } catch (UnknownHostException e) {
            System.err.println("No encuentro el host: " + HOST_NAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No puedo enlazar la entrada/salida " + "en la conexión a: " + HOST_NAME);
            System.exit(1);
        }
        run();
    }

    public void run(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
                linea = reader.readLine();
            }

            System.out.println("Terminando el cliente");

            serverWrrite.close();
            serverRead.close();
            reader.close();
            dataSoket.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
