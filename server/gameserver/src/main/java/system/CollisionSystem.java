package gamesystem;

import gameobject.*;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem implements GameSystem {

    @Override
    public void update(GameState state) {
        handlePacmanCollisions(state);
    }

    private void handlePacmanCollisions(GameState state) {
        List<Food> eatenFoods = new ArrayList<>();
        List<Pacman> eatenPacmen = new ArrayList<>();
        for (Pacman pacman : state.getPacmen()) {
            for (Food food : state.getFood()) {
                if (collides(pacman, food)) {
                    eatenFoods.add(food);
                }
            }
            for (GameObject ghost : state.getGhosts()) {
                if (collides(pacman, ghost)) {
                    eatenPacmen.add(pacman);
                }
            }
        }
        for (Food food : eatenFoods) {
            state.removeFood(food);
        }
        for (Pacman pacman : eatenPacmen) {
            System.out.println("Pac-Man " + pacman.getId() + " has been eaten by a ghost!");
            state.removePacman(pacman);
        }
    }

    private boolean collides(GameObject a, GameObject b) {
        return a.getPosition().x() < b.getPosition().x() + b.getWidth() &&
                a.getPosition().x() + a.getWidth() > b.getPosition().x() &&
                a.getPosition().y() < b.getPosition().y() + b.getHeight() &&
                a.getPosition().y() + a.getHeight() > b.getPosition().y();
    }
}
