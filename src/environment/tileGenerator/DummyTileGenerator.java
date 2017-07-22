package environment.tileGenerator;

import environment.map.Position;
import environment.map.Tile;

import java.util.ArrayList;

public class DummyTileGenerator implements TileGenerator {
    @Override
    public Tile generateTile(Position position) {
        return new Tile(position, new ArrayList<>());
    }
}
