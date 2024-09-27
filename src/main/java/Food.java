import java.awt.*;

public class Food {

private Point position;

public Food() {
    generateNewPosition();
}

public void generateNewPosition() {
    position = new  Point((int) (Math.random() * GameConstants.WINDOW_WIDTH / GameConstants.SNAKE_SEGMENT_SIZE) * GameConstants.SNAKE_SEGMENT_SIZE;
                        (int)   (Math.random() * GameConstants.WINDOW_HEIGHT / GameConstants.SNAKE_SEGMENT_SIZE * GameConstants.SNAKE_SEGMENT_SIZE;
}


public Point getPosition() {
    return position;
}


}