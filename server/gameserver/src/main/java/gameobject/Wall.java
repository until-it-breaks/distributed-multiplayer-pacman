package gameobject;

public class Wall extends GameObject {
    public Wall(int x, int y, int height, int width, int speed) {
        super(x, y, height, width, speed);
    }

    public static Wall createDefaultWall(int tileX, int tileY) {
        return new Wall(
            tileX * GameConstants.TILE_SIZE,
            tileY * GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            0
        );
    }
}
