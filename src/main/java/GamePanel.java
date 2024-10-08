import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;


public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setBackground(Color.BLACK);

        // Add KeyListener to capture keyboard input for snake movement
        setFocusable(true); // Needed for KeyListener to work
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (game.getSnake().getDirection() != Direction.DOWN) {
                            game.getSnake().setDirection(Direction.UP);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (game.getSnake().getDirection() != Direction.UP) {
                            game.getSnake().setDirection(Direction.DOWN);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (game.getSnake().getDirection() != Direction.RIGHT) {
                            game.getSnake().setDirection(Direction.LEFT);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (game.getSnake().getDirection() != Direction.LEFT) {
                            game.getSnake().setDirection(Direction.RIGHT);
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);

        // Draw snake body
        for (Point point : game.getSnake().getBody()) {
            g.fillOval(point.x, point.y, GameConstants.SNAKE_SEGMENT_SIZE, GameConstants.SNAKE_SEGMENT_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillOval(game.getFood().getPosition().x, game.getFood().getPosition().y, GameConstants.FOOD_SIZE, GameConstants.FOOD_SIZE);

        // Display high score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("High Score: " + game.getHighScore(), 10, 20);
    }
}
