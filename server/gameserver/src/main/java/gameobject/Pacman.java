package gameobject;

public class Pacman extends GameObject {
    public Pacman(int x, int y, int height, int width, int speed) {
        super(x, y, height, width, speed);
    }

    @Override
    public void update() {
        Vector2 velocity = getDirection().scale(this.getSpeed());
        Vector2 pos = getPosition();
        int newX = pos.x() + velocity.x();
        int newY = pos.y() + velocity.y();
        if (!CollisionSystem.collidesWithWall(newX, pos.y(), getWidth(), getHeight())) {
            pos = new Vector2(newX, pos.y());
        }
        if (!CollisionSystem.collidesWithWall(pos.x(), newY, getWidth(), getHeight())) {
            pos = new Vector2(pos.x(), newY);
        }
        setPosition(pos);
    }

    public static Pacman createDefaultPacman(int x, int y) {
        return new Pacman(
            x * GameConstants.TILE_SIZE,
            y * GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.TILE_SIZE,
            GameConstants.PACMAN_SPEED
        );
    }
}
