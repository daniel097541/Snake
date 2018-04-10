package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

    private ArrayList<Point> snakeBody;
    private Integer snakeLenght;

    public Snake(){
        this.snakeLenght = 4;
        this.snakeBody = new ArrayList<>();
        Integer random = generateRandomNumber();
        for(int i=0;i<=snakeLenght;i++){
            snakeBody.add(new Point(random-i,random));
        }
    }

    public Integer generateRandomNumber(){
        Random rand = new Random();
        int n = rand.nextInt(50)+1;
        return n;
    }

    public ArrayList<Point> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(ArrayList<Point> snakeBody) {
        this.snakeBody = snakeBody;
    }
}
