import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

private Game game;

public GamePanel(Game game) {
    this.game = game;
    setBackground((Color.BLACK));
}

protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GREEN);

    for (Point point : game.getSnake().getBody()) {
        g.fillOval(point.x, point.y GameConstants.SNAKE_SEGMENT_SIZE, GameConstants.SNAKE_SEGMENT_SIZE;
    }
    g.setColor(Color.RED);
    g.fillOval(game.getFood().getPosition().x, game.getFood().getPosition().y, GameConstants.FOOD_SIZE, GameConstants.FOOD_SIZE);


        g.setColor(Color.WHITE;
        g.setFont(new Font("Arial", Font.BOLD), 18));
        g.drawString("High Score:) " + game.getHighScore(), 10, 20);


    }


}




