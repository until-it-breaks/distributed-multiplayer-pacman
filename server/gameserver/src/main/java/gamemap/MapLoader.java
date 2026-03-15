package gamemap;

import gameobject.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapLoader {
    public static GameState loadTiles(JSONObject jsonMap) {
        List<Wall> walls = new ArrayList<>();
        List<Food> food = new ArrayList<>();
        List<Pacman> pacmen = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        JSONArray rows = jsonMap.getJSONArray("tiles");
        for (int y = 0; y < rows.length(); y++) {
            JSONArray cols = rows.getJSONArray(y);
            for (int x = 0; x < cols.length(); x++) {
                String tile = cols.getString(x);
                switch (tile) {
                    case "W" -> walls.add(Wall.createDefaultWall(x, y));
                    case "E" -> food.add(Food.createDefaultWall(x, y));
                    case "P" -> pacmen.add(Pacman.createDefaultPacman(x, y));
                    case "G" -> ghosts.add(Ghost.createDefaultGhost(x, y));
                }
            }
        }
        return new GameState(walls, food, pacmen, ghosts);
    }

    public static JSONObject loadMap(String filename) throws Exception {
        try (InputStream is = MapLoader.class.getClassLoader().getResourceAsStream(filename)) {
            Objects.requireNonNull(is, "Map file not found: " + filename);
            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return new JSONObject(json);
        }
    }
}
