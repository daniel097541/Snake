package Server;

import Model.SnakePanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server extends Thread{

    private Socket dataShocket;
    private SnakePanel snakePanel = new SnakePanel();
    
    public static void main(String[] args) {
        ServerSocket serverShocket = null;
        try {
            serverShocket = new ServerSocket(8000);
            System.out.println ("Creado el Socket del servidor");
            try {
                while(true) {
                    System.out.println ("Esperando una conexion");
                    new Server (serverShocket.accept());
                }
            }
            catch (IOException e) {
                System.err.println("Fallo del Accept.");
                System.exit(1);
            }
        }
        catch (IOException e) {
            System.err.println("No puedo escuchar en el puerto: 8000.");
            System.exit(1);
        }
        finally {
            try {
                Objects.requireNonNull(serverShocket).close();
            }
            catch (IOException e){
                System.err.println("No puedo cerrar el puerto");
                System.exit(1);
            }
        }
    }

    private Server(Socket clientSoc) {
        dataShocket = clientSoc;
        start();
    }

    public void run() {
        System.out.println ("Lanzado nuevo Thread");
        try {
            Integer id = generateId();
            //Habria que pasarle el id al jugador player.setId(id);
            PrintWriter clientWrite = new PrintWriter(dataShocket.getOutputStream(), true);
            BufferedReader clientRead = new BufferedReader(new InputStreamReader( dataShocket.getInputStream()));
            String line;
            while ((line = clientRead.readLine()) != null) {
                System.out.println ("Servidor: " + line);
                clientWrite.println(line);
                if (line.equals("x"))
                    break;
            }
            clientWrite.close();
            clientRead.close();
            dataShocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int generateId(){
        Integer id;
        if(snakePanel.getPlayers().isEmpty()){
            id = 1;
        } else{
            id = snakePanel.getPlayers().size()+1;
        }
        return id;
    }
}
