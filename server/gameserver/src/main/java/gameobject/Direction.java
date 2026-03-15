package gameobject;

public enum Direction {
    UP(0,1),
    DOWN(0,-1),
    LEFT(-1,0),
    RIGHT(1,0),
    NONE(0,0);

    private final int x;
    private final int y;

    Direction(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2 toVector2() {
        return new Vector2(x, y);
    }
}
