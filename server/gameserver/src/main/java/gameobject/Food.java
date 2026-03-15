package gameobject;

public class Food extends GameObject {
    public Food(int x, int y, int height, int width, int speed) {
        super(x, y, height, width, speed);
    }

    public static Food createDefaultWall(int tileX, int tileY) {
        return new Food(
            tileX * GameConstants.TILE_SIZE,
            tileY * GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            0
        );
    }
}
