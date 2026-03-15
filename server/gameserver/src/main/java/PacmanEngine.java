import gameobject.*;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class PacmanEngine {
    private final GameState gameState;
    private final Queue<Direction> inputQueue = new ArrayDeque<>();

    private static final int TICKS_PER_SECOND = 64;
    private static final long NS_PER_TICK = 1_000_000_000L / TICKS_PER_SECOND;

    public PacmanEngine(GameState gameState) {
        this.gameState = gameState;
        CollisionSystem.init(gameState);
    }

    public void queueInput(Direction dir) {
        inputQueue.offer(dir);
    }

    public void tick() {
        processInputQueue();
        for (GameObject obj : gameState.getPacmen()) {
            obj.update();
        }
        CollisionSystem.handlePacmanCollisions();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void run() {
        long nextTick = System.nanoTime();
        while (true) {
            tick();
            nextTick += NS_PER_TICK;
            long sleepTimeNs = nextTick - System.nanoTime();
            if (sleepTimeNs > 0) {
                try {
                    Thread.sleep(sleepTimeNs / 1_000_000, (int) (sleepTimeNs % 1_000_000));
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                nextTick = System.nanoTime();
            }
        }
    }

    private void processInputQueue() {
        while (!inputQueue.isEmpty()) {
            Direction dir = inputQueue.poll();
            for (GameObject obj : gameState.getPacmen()) {
                if (obj instanceof Pacman pacman) {
                    pacman.setDirection(dir);
                }
            }
        }
    }
}