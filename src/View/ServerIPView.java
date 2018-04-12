package View;

import javax.swing.*;

public class ServerIPView extends JPanel {

    private String ip;

    public ServerIPView(){
        this.ip = JOptionPane.showInputDialog(null,"Por favor introduce la ip del servidor");
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
