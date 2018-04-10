package Model;

import java.util.ArrayList;

public class SnakePanel {

    private ArrayList<Player> players;
    private ArrayList<Bonus> bonuses;

    public SnakePanel(){
        this.players = new ArrayList<>();
        this.bonuses = new ArrayList<>();
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

}
