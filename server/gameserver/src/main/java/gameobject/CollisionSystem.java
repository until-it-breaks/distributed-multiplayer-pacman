package gameobject;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {
    private static GameState gameState;

    public static void init(GameState state) {
        gameState = state;
    }

    public static boolean collidesWithWall(float x, float y, int width, int height) {
        for (Wall wall : gameState.getWalls()) {
            if (x < wall.getPosition().x() + wall.getWidth() &&
                    x + width > wall.getPosition().x() &&
                    y < wall.getPosition().y() + wall.getHeight() &&
                    y + height > wall.getPosition().y()) {
                return true;
            }
        }
        return false;
    }

    public static void handlePacmanCollisions() {
        List<Food> eatenFoods = new ArrayList<>();

        for (GameObject obj : gameState.getPacmen()) {
            if (!(obj instanceof Pacman pacman)) continue;

            for (Food food : gameState.getFood()) {
                if (CollisionSystem.collides(pacman, food)) {
                    eatenFoods.add(food);
                }
            }

            for (GameObject ghost : gameState.getGhosts()) {
                if (CollisionSystem.collides(pacman, ghost)) {
                    System.out.println("Pac-Man " + pacman.getId() + " eaten by a ghost!");
                    gameState.removePacman(pacman);
                    break;
                }
            }
        }

        for (Food food : eatenFoods) {
            gameState.removeFood(food);
        }
    }

    public static boolean collides(GameObject a, GameObject b) {
        return a.getPosition().x() < b.getPosition().x() + b.getWidth() &&
                a.getPosition().x() + a.getWidth() > b.getPosition().x() &&
                a.getPosition().y() < b.getPosition().y() + b.getHeight() &&
                a.getPosition().y() + a.getHeight() > b.getPosition().y();
    }
}
