import gameobject.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacmanSwingView extends JPanel {
    private final PacmanEngine engine;
    public PacmanSwingView(PacmanEngine engine) {
        this.engine = engine;
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        JFrame frame = new JFrame("Pacman");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Direction dir = switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> Direction.UP;
                    case KeyEvent.VK_S -> Direction.DOWN;
                    case KeyEvent.VK_A -> Direction.LEFT;
                    case KeyEvent.VK_D -> Direction.RIGHT;
                    default -> null;
                };
                if (dir != null) engine.queueInput(dir);
            }
        });
        frame.setVisible(true);
        new Timer(1000 / 60, ev -> repaint()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GameState state = engine.getGameState();
        float worldWidth = 240;
        float worldHeight = 240;
        float scaleX = getWidth() / worldWidth;
        float scaleY = getHeight() / worldHeight;
        float scale = Math.min(scaleX, scaleY);
        g2.translate(0, getHeight());
        g2.scale(scale, -scale);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);
        for (Wall wall : state.getWalls()) {
            g2.fillRect(
                    wall.getPosition().x(),
                    wall.getPosition().y(),
                    wall.getWidth(),
                    wall.getHeight()
            );
        }
        g2.setColor(Color.ORANGE);
        for (Food food : state.getFood()) {
            int size = food.getWidth() / 2;
            int offset = (food.getWidth() - size) / 2;
            g2.fillRect(
                    food.getPosition().x() + offset,
                    food.getPosition().y() + offset,
                    size,
                    size
            );
        }
        g2.setColor(Color.YELLOW);
        for (GameObject pacman : state.getPacmen()) {
            g2.fillOval(
                    pacman.getPosition().x(),
                    pacman.getPosition().y(),
                    pacman.getWidth(),
                    pacman.getHeight()
            );
        }
        g2.setColor(Color.PINK);
        for (GameObject ghost : state.getGhosts()) {
            g2.fillOval(
                    ghost.getPosition().x(),
                    ghost.getPosition().y(),
                    ghost.getWidth(),
                    ghost.getHeight()
            );
        }
    }
}