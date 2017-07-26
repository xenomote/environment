package game.map.tiles.entities.moves;

import game.map.tiles.Tile;
import game.map.tiles.entities.StaticEntity;

public class CreationPlacement extends Move {
    public CreationPlacement(StaticEntity entity, Tile startingLocation) {
        super(entity, startingLocation, startingLocation);
    }

}
