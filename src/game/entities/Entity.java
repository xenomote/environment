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
        this.location = startingLocation;
        startingLocation.add(this);
    }

    public Set<Action> generateActions() {
        return new HashSet<>();
    }

    public void move(Tile location) {
        this.location = location;
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