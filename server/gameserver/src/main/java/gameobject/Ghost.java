package gameobject;

public class Ghost extends GameObject {
    public Ghost(int x, int y, int height, int width, int speed) {
        super(x, y, height, width, speed);
    }

    public static Ghost createDefaultGhost(int x, int y) {
        return new Ghost(
            x * GameConstants.ACTIVE_ENTITY_SIZE,
            y * GameConstants.ACTIVE_ENTITY_SIZE,
            GameConstants.ACTIVE_ENTITY_SIZE,
            GameConstants.ACTIVE_ENTITY_SIZE,
            GameConstants.GHOST_SPEED);
    }
}
