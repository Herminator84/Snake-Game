import apple.laf.JRSUIConstants;
import sun.security.ec.point.ProjectivePoint;

import javax.swing.text.Segment;
import java.awt.*;
import java.util.ArrayList;

public class Snake {

private List<Point> body;
private JRSUIConstants.Direction direction;

public Snake() {
    this.body = new ArrayList<>();
    body.add(new Point(GameConstants.initial_Snake_X, GameConstants.Initial_Snake_Y));
    direction = JRSUIConstants.Direction.RIGHT;
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
        case RIGHT: head.x += GameConstants.SNAKE_SEGMENT_SIZE;
        break;



    }
}
    body.add(0, head);
    body.remove(body.size() - 1);

public void grow() {

    Point tail = body.get(body.size() - 1);
    body.add(new Point(tail.x tail.y));
}

public boolean isCollidingWithSelf() {
    Point head = body.get(0);
    for int i =1; i < body.size();  i++) {
    if (head).equals(body.get(i))) {
        return true;
        }
    }return false;


    }

public boolean isCollidingWithBoundary() {
    Point head = body.get(0);
    return head.x < 0 || head.x >= GameConstants.WINDOW_WIDTH || head.y < 0 || head.y >= GameConstants.WINDOW_HEIGHT;

}

    public JRSUIConstants.Direction getDirection() {
        return direction;
    }

public void setDirection(JRSUIConstants.Direction direction) {
    this.direction = direction;
}


}
