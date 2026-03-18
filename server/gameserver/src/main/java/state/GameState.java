package state;

import entity.Food;
import entity.Ghost;
import entity.Pacman;
import entity.Wall;

import java.util.*;

import static state.GameConstants.DEFAULT_GAME_TIME_IN_MILLISECONDS;

public class GameState {
    private final List<Pacman> pacmen;
    private final List<Ghost> ghosts;
    private final List<Wall> walls;
    private final List<Food> food;

    private long remainingTimeInMilliseconds = DEFAULT_GAME_TIME_IN_MILLISECONDS;

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

    public List<Wall> getWalls() {
        return Collections.unmodifiableList(walls);
    }

    public List<Food> getFood() {
        return Collections.unmodifiableList(food);
    }

    public void removePacman(Pacman pacman) {
        this.pacmen.remove(pacman);
    }

    public void removeFood(Food food) {
        this.food.remove(food);
    }

    public long getRemainingTimeInMilliseconds() {
        return remainingTimeInMilliseconds;
    }

    public void decreaseTime(long deltaInMilliseconds) {
        this.remainingTimeInMilliseconds -= deltaInMilliseconds;
    }
}
