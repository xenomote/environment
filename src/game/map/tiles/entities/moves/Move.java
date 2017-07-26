package game.map.tiles.entities.moves;

import game.map.tiles.Tile;
import game.map.tiles.entities.StaticEntity;

public class Move {
    private final StaticEntity entity;
    private final Tile from;
    private final Tile to;
    private boolean left;
    private boolean received;
    private boolean updated;

    public Move(StaticEntity entity, Tile from, Tile to) {
        this.entity = entity;
        this.from = from;
        this.to = to;

        left = received = updated = false;
    }

    public StaticEntity getEntity() {
        return entity;
    }

    public Tile getFrom() {
        return from;
    }

    public Tile getTo() {
        return to;
    }

    public void hasLeft() {
        left = true;
    }

    public void hasReceived() {
        received = true;
    }

    public void hasUpdated() {
        updated = true;
    }

    public boolean inProgress() {
        return !(left && received && updated);
    }
}
