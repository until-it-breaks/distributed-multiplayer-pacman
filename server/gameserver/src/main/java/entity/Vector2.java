package entity;

import java.util.Objects;

public record Vector2(int x, int y) {
    public static final Vector2 ZERO = new Vector2(0,0);

    public Vector2 scale(int scale) {
        return new Vector2(this.x * scale, this.y * scale);
    }

    public Vector2 add(Vector2 vector) {
        return new Vector2(this.x + vector.x, this.y + vector.y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x && y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
