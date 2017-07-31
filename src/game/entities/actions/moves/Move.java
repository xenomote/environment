package game.entities.actions.moves;

import game.entities.actions.Action;
import game.map.tiles.Tile;
import game.entities.Entity;

public class Move implements Action {
    private final Entity entity;
    private final Tile start;
    private final Tile destination;
    private boolean left;
    private boolean arrived;
    private boolean updated;

    public Move(Entity entity, Tile destination) {
        this.entity = entity;
        this.start = entity.getLocation();
        this.destination = destination;

        left = arrived = updated = false;
    }

    @Override
    public void executeAction() {
        entity.move(this);
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

    public void hasLeft() {
        left = true;
    }

    public void hasArrived() {
        arrived = true;
    }

    public void hasUpdated() {
        updated = true;
    }

    public boolean inProgress() {
        return !(left && arrived && updated);
    }
}
