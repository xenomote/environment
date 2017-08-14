package game.entities.actions.moves;

import game.entities.actions.Action;
import game.map.tiles.Tile;
import game.entities.Entity;

public class Move implements Action {
    private final Entity entity;
    private final Tile start;
    private final Tile destination;

    public Move(Entity entity, Tile destination) {
        this.entity = entity;
        this.start = entity.getLocation();
        this.destination = destination;
    }

    @Override
    public void executeAction() {
        entity.move(destination);
        start.remove(entity);
        destination.add(entity);
    }

    public Entity getEntity() {
        return entity;
    }

    public Tile getStart() {
        return start;
    }

    public Tile getDestination() {
        return destination;
    }
}
