package entity;

import java.util.Objects;
import java.util.UUID;

public class GameObject {
    private final UUID id;
    private Vector2 position;
    private Vector2 direction;
    private int speed;
    private final int height;
    private final int width;

    public GameObject(int x, int y, int height, int width, int speed) {
        this.height = height;
        this.width = width;
        this.id = UUID.randomUUID();
        this.position = new Vector2(x, y);
        this.speed = speed;
        this.direction = Direction.NONE.toVector2();
    }
    public UUID getId() {
        return this.id;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vector2 getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction.toVector2();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "gameobject.GameObject{" +
                "id=" + id +
                ", position=" + position +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
