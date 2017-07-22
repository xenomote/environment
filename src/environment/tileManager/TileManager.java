package environment.tileManager;

import environment.map.Position;
import environment.map.Tile;
import environment.tileGenerator.TileGenerator;

import java.util.HashMap;

public class TileManager {
    private final TileGenerator generator;
    private final HashMap<Position, Tile> activeTiles;

    public TileManager(TileGenerator generator) {
        this.generator = generator;
        this.activeTiles = new HashMap<>();
    }

    public Tile getTile(Position position) {
        return activeTiles.getOrDefault(
                position,
                activeTiles.put(
                        position,
                        generator.generateTile(position)
                )
        );
    }

    public HashMap<Position, Tile> getActiveTiles() {
        return new HashMap<>(activeTiles);
    }
}
