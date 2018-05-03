package Model;

import View.GameView;
import java.util.ArrayList;

public class SnakePanel extends Thread {

    private ArrayList<Player> players;
    private ArrayList<Bonus> bonuses;
    public GameView g;
    public int velocidad;
    boolean pausa;

    public SnakePanel() {
        this.players = new ArrayList<>();
        this.bonuses = new ArrayList<>();
        g = new GameView();
        g.setVisible(true);
        velocidad = 500;
        pausa = false;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(ArrayList<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public void run() {
        
        while (true) {
            try {
                sleep(velocidad);
            } catch (InterruptedException ex) {
            }
            if (!pausa) {
                g.actualizarPosicion();
            }
        }
    }

}
