import javax.swing.JFrame;

public class Game {
    private Snake snake;
    private Food food;
    private GamePanel gamePanel;
    private boolean isRunning;
    private int highScore;

    public Game() {
        snake = new Snake();
        food = new Food();
        gamePanel = new GamePanel(this);
        isRunning = true;
        highScore = 0;
    }

    private void loadHighScore() {
        highScore = 100; // Placeholder for loading from a file or other source
    }

    private void saveHighScore() {
        System.out.println("New high score: " + highScore);
    }

    public int getHighScore() {
        return highScore;
    }

    public void start() {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gameLoop();
    }

    private void gameLoop() {
        while (isRunning) {
            update();
            render();
            try {
                Thread.sleep(GameConstants.GAME_SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        snake.move();

        // Check if the snake has eaten the food
        if (snake.getBody().get(0).equals(food.getPosition())) {
            snake.grow(); // Snake grows after eating food
            food.generateNewPosition(); // Generate a new food position
        }

        // Check for collisions with self or boundary
        if (snake.isCollidingWithSelf() || snake.isCollidingWithBoundary()) {
            isRunning = false; // Stop the game if there's a collision
            if (snake.getBody().size() > highScore) {
                highScore = snake.getBody().size();
                saveHighScore();
            }
        }
    }

    private void render() {
        gamePanel.repaint(); // Trigger repainting of the game panel
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}
