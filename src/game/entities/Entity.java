package game.entities;

import game.description.Name;
import game.entities.actions.Action;
import game.map.tiles.Tile;
import game.entities.actions.moves.Move;

import java.util.HashSet;
import java.util.Set;

public abstract class Entity {
    private Tile location;
    private Name name;

    public Entity(Tile startingLocation) {
        this(new Name("an", "unknown entity", "unknown entities"), startingLocation);
    }

    public Entity(Name name, Tile startingLocation) {
        this.name = name;
        this.location = new Tile();
        move(new Move(this, startingLocation));
    }

    public Set<Action> generateActions() {
        return new HashSet<>();
    };

    public final void move(Move move) {
        if (move.inProgress()) {
            this.location = move.getDestination();
            move.hasUpdated();
            move.getDestination().transferTo(move);
        }
    }

    public Tile getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}