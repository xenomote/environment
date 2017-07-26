package game.map.tiles.entities;

import game.map.Direction;
import game.map.tiles.entities.moves.Move;
import game.map.tiles.Tile;

public abstract class MovableEntity extends StaticEntity {
    public MovableEntity(Tile startingLocation) {
        super(startingLocation);
    }

    public void move(Direction direction) {
        move(
                new Move(
                        this,
                        getLocation(),
                        getLocation().getAdjacent(direction)));
    }
}
