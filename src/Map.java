import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private final Area area;
    private final HashMap<Position, Tile> activeTiles;
    private final MapGenerator generator;

    public Map(Area area, MapGenerator generator) {
        this.area = area;
        this.activeTiles = new HashMap<>();
        this.generator = generator;
    }

    public Area getArea() {
        return area;
    }

    public Tile getTile(Position position) {
        if (activeTiles.containsKey(position)) {
            return activeTiles.get(position);
        }

        else {
            Tile tile = generator.generateTile(position);
            activeTiles.put(position, tile);
            return tile;
        }
    }
}
