package Model;

import java.util.Random;

public class Bonus {

    private Integer bonus;

    public Bonus(){
        this.bonus = generateRandomNumber();
    }

    public Integer generateRandomNumber(){
        Random rand = new Random();
        int n = rand.nextInt(50)+1;
        return n;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
