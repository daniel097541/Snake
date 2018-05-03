package View;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel{

    private Integer id;

    public StartView(Integer id){
        this.id = id;
        //GameView g = new GameView();
        ImageIcon icon = new ImageIcon("src/Images/snake.png");
        int input = JOptionPane.showConfirmDialog(null, "Te has conectado al servidor, tu id es "+id+" ¿Deseas comenzar a jugar?", "Snake", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        //0=si, 1=no, 2=cancelar
        switch (input){
            case 0: break;//g.setVisible(true);
            case 1: break;
            case 2: break;
        }
    }

}
