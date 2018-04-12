package Model;

public class Player {

    private Integer id;
    private Snake snake;
    private Integer points;

    public Player(Integer id){
        this.id = id;
        this.snake = new Snake();
        this.points = 0;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
