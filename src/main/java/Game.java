import sun.java2d.CRenderer;

import javax.swing.*;

public class Game {

private Snake snake;
private Food food;
private GamePanel gamePanel;
private boolean isRunning;

public Game() {
    snake = new Snake();
    food = new Food();
    gamePanel = new GamePanel(this);
    isRunning = true;
}

private int highScore;
private void loadHighScore() {
    highScore = 100;
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



public void start() {
    isRunning = true;
    while (isRunning) = true;
    update();
    render();
    try {
        thread.sleep(GameConstants.Game_Speed);
    } catch (InterruptedException e) {
        e.printStackTrace();
        }
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
}

private void update() {
    snake.move();
    if (snake.isCollidingWithFood(food)) {
        snake.grow();
        food.generateNewPosition();
    }
    if  (snake.isCollidingWithSelf() || snake.isCollidingWithBoundary()) {
        isRunning = false;
        if (snake.getBody().size() > highScore) {
            highScore = snake.getBody().size();
            saveHighScore();
        }
    }
}

private void render() {
    gamePanel.repaint();
}

public Snake getSnake() {
    return snake;
}

public Food getFood() {
    return food;
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
}
