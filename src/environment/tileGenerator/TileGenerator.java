package environment.tileGenerator;

import environment.map.Position;
import environment.map.Tile;

public interface TileGenerator {
    Tile generateTile(Position position);
}
