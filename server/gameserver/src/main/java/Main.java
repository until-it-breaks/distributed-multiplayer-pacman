import gamemap.MapLoader;
import gameobject.GameState;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        GameState state = MapLoader.loadTiles(MapLoader.loadMap("maps/map.json"));
        PacmanEngine engine = new PacmanEngine(state);
        new Thread(engine::run).start();
        SwingUtilities.invokeLater(() -> new PacmanSwingView(engine));
    }
}
