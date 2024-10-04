import java.awt.Point; // Import for Point class
import java.util.ArrayList; // Import for ArrayList
import java.util.List; // Import for List interface



public class Snake {
    private List<Point> body; // List to store the body of the snake
    private Direction direction; // Current direction of the snake
    private boolean isGrowing; // Flag to check if the snake is growing

    public Snake() {
        this.body = new ArrayList<>(); // Initialize the snake's body
        body.add(new Point(GameConstants.INITIAL_SNAKE_X, GameConstants.INITIAL_SNAKE_Y)); // Set the initial position
        direction = Direction.RIGHT; // Set initial direction
        isGrowing = false; // Snake is not growing initially
    }

    public void move() {
        Point head = new Point(body.get(0)); // Get the current head position
        switch (direction) {
            case UP:
                head.y -= GameConstants.SNAKE_SEGMENT_SIZE; // Move up
                break;
            case DOWN:
                head.y += GameConstants.SNAKE_SEGMENT_SIZE; // Move down
                break;
            case LEFT:
                head.x -= GameConstants.SNAKE_SEGMENT_SIZE; // Move left
                break;
            case RIGHT:
                head.x += GameConstants.SNAKE_SEGMENT_SIZE; // Move right
                break;
        }

        body.add(0, head); // Add the new head position

        if (!isGrowing) {
            body.remove(body.size() - 1); // Remove the last segment if not growing
        } else {
            isGrowing = false; // Reset growing status
        }
    }

    public void grow() {
        isGrowing = true; // Set to grow on next move
    }

    public List<Point> getBody() {
        return body; // Get the current body of the snake
    }

    public Direction getDirection() {
        return direction; // Get the current direction
    }

    public void setDirection(Direction direction) {
        this.direction = direction; // Set the current direction
    }

    public boolean isCollidingWithSelf() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true; // Collision detected
            }
        }
        return false; // No collision
    }

    public boolean isCollidingWithBoundary() {
        Point head = body.get(0);
        return head.x < 0 || head.x >= GameConstants.WINDOW_WIDTH || head.y < 0 || head.y >= GameConstants.WINDOW_HEIGHT; // Check for boundary collisions
    }
}
