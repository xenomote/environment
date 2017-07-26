package game.map.tiles.entities;

import game.map.tiles.entities.moves.CreationPlacement;
import game.map.tiles.Tile;
import game.map.tiles.entities.moves.Move;

public abstract class StaticEntity {
    private Tile location;

    public StaticEntity(Tile startingLocation) {
        move(new CreationPlacement(this, startingLocation));
    }

    public final void move(Move move) {
        if (move.inProgress()) {
            this.location = move.getTo();
            move.hasUpdated();
            move.getFrom().transferFrom(move);
        }
    }

    public Tile getLocation() {
        return location;
    }
}
