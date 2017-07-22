package environment.map;

import environment.tileGenerator.TileGenerator;
import environment.tileManager.TileManager;

public class Map {
    private final Area area;
    private final TileManager tiles;

    public Map(Area area, TileGenerator generator) {
        this.area = area;
        this.tiles = new TileManager(generator);
    }

    public Area getArea() {
        return area;
    }

    public TileManager getTileManager() {
        return tiles;
    }

    public Tile getTile(Position position) {
        return tiles.getTile(position);
    }
}
