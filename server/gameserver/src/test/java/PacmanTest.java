import gameobject.Pacman;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanTest {
    private static final int STARTING_X = 0;
    private static final int STARTING_Y = 0;

    private Pacman pacman;

    //@BeforeEach
    //public void init() {
    //    pacman = new Pacman(STARTING_X, STARTING_Y);
    //}

//    @Test
//    public void pacmanMovesUp() {
//        pacman.move(gameobject.Direction.UP);
//        assertEquals(STARTING_X, pacman.getX());
//        assertEquals(STARTING_Y + 1, pacman.getY());
//    }
//
//    @Test
//    public void pacmanMovesDown() {
//        pacman.move(gameobject.Direction.DOWN);
//        assertEquals(STARTING_X, pacman.getX());
//        assertEquals(STARTING_Y - 1, pacman.getY());
//    }
//
//    @Test
//    public void pacmanMovesLeft() {
//        pacman.move(gameobject.Direction.LEFT);
//        assertEquals(STARTING_X - 1, pacman.getX());
//        assertEquals(STARTING_Y, pacman.getY());
//    }
//
//    @Test
//    public void pacmanMovesRight() {
//        pacman.move(gameobject.Direction.RIGHT);
//        assertEquals(STARTING_X + 1, pacman.getX());
//        assertEquals(STARTING_Y, pacman.getY());
//    }
//
//    @Test void pacmanMovesThreeStepsToTheRight() {
//        int steps = 3;
//        for (int i = 0; i < steps; i++) {
//            pacman.move(gameobject.Direction.RIGHT);
//        }
//        assertEquals(steps, pacman.getX());
//    }
//
//    @Test
//    public void pacmanReturnsToStartingPosition() {
//        pacman.move(gameobject.Direction.UP);
//        pacman.move(gameobject.Direction.DOWN);
//        pacman.move(gameobject.Direction.LEFT);
//        pacman.move(gameobject.Direction.RIGHT);
//        assertEquals(STARTING_X, pacman.getX());
//        assertEquals(STARTING_Y, pacman.getY());
//    }
}
