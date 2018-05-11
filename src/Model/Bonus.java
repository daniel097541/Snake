package Model;

import java.util.Random;

public class Bonus {

    private Integer bonusX;
    private Integer bonusY;

    public Bonus() {
        //this.bonusX = generateRandomNumberX();
        //this.bonusY = generateRandomNumberY();
    }

    public Integer generateRandomNumberX() {
        Random rand = new Random();
        int n = rand.nextInt(40);
        return n;
    }

    public Integer generateRandomNumberY() {
        Random rand = new Random();
        int n = rand.nextInt(60);
        return n;
    }

}
