package game.entities.mobiles;

import game.description.Name;
import game.map.Direction;
import game.entities.Entity;
import game.entities.actions.moves.Move;
import game.map.tiles.Tile;

public abstract class MovableEntity extends Entity {
    public MovableEntity(Tile startingLocation) {
        super(startingLocation);
    }

    public MovableEntity(Name name, Tile startingLocation) {
        super(name, startingLocation);
    }

    public void move(Direction direction) {
        move(getLocation().getAdjacentOrThis(direction));
    }
}