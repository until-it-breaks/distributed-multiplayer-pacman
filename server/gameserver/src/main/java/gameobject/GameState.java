package gameobject;

import java.util.*;

public class GameState {
    private final List<Pacman> pacmen;
    private final List<Ghost> ghosts;
    private final List<Wall> walls;
    private final List<Food> food;

    public GameState(List<Wall> walls, List<Food> food, List<Pacman> gameObjects, List<Ghost> ghosts) {
        this.walls = walls;
        this.food = food;
        this.pacmen = gameObjects;
        this.ghosts = ghosts;
    }

    public List<Pacman> getPacmen() {
        return Collections.unmodifiableList(pacmen);
    }

    public List<Ghost> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public void removePacman(Pacman pacman) {
        this.pacmen.remove(pacman);
    }

    public void removeFood(Food food) {
        this.food.remove(food);
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Food> getFood() {
        return food;
    }
}
