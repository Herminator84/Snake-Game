import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Point> body;
    private Direction direction;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Snake() {
        this.body = new ArrayList<>();
        body.add(new Point(GameConstants.INITIAL_SNAKE_X, GameConstants.INITIAL_SNAKE_Y));
        direction = Direction.RIGHT;
    }

    public void move() {
        Point head = new Point(body.get(0).x, body.get(0).y);
        switch (direction) {
            case UP:
                head.y -= GameConstants.SNAKE_SEGMENT_SIZE;
                break;
            case DOWN:
                head.y += GameConstants.SNAKE_SEGMENT_SIZE;
                break;
            case LEFT:
                head.x -= GameConstants.SNAKE_SEGMENT_SIZE;
                break;
            case RIGHT:
                head.x += GameConstants.SNAKE_SEGMENT_SIZE;
                break;
        }
        body.add(0, head); // Add the new head at the front
    }

    public void grow() {
        // Duplicate the tail position to grow the snake
        Point tail = body.get(body.size() - 1);
        body.add(new Point(tail.x, tail.y)); // Add a new segment at the tail's position
    }

    public boolean isCollidingWithSelf() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithBoundary() {
        Point head = body.get(0);
        return head.x < 0 || head.x >= GameConstants.WINDOW_WIDTH || head.y < 0 || head.y >= GameConstants.WINDOW_HEIGHT;
    }

    public List<Point> getBody() {
        return body; // Method to access the snake's body
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
