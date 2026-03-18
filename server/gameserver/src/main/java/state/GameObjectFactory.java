package state;

import entity.Food;
import entity.Ghost;
import entity.Pacman;
import entity.Wall;

public class GameObjectFactory {
    public static Food createFood(int x, int y) {
        return new Food(
            toGameUnit(x),
            toGameUnit(y),
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.NO_SPEED
        );
    }

    public static Ghost createGhost(int x, int y) {
        return new Ghost(
            toGameUnit(x),
            toGameUnit(y),
            GameConstants.ACTIVE_ENTITY_SIZE,
            GameConstants.ACTIVE_ENTITY_SIZE,
            GameConstants.GHOST_SPEED);
    }

    public static Pacman createPacman(int x, int y) {
        return new Pacman(
            toGameUnit(x),
            toGameUnit(y),
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.PACMAN_SPEED
        );
    }

    public static Wall createWall(int x, int y) {
        return new Wall(
            toGameUnit(x),
            toGameUnit(y),
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.NO_SPEED
        );
    }

    private static int toGameUnit(int tile) {
        return tile * GameConstants.TILE_SIZE;
    }
}
