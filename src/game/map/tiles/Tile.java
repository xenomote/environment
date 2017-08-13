package game.map.tiles;

import game.entities.EntityManager;
import game.map.Direction;
import game.entities.Entity;
import game.entities.actions.moves.Move;

import java.util.HashMap;
import java.util.HashSet;

public class Tile{
    private final EntityManager entities;
    private final HashMap<Direction, Tile> links;

    public Tile() {
        this.entities = new EntityManager();
        this.links = new HashMap<>();
    }

    public HashSet<Entity> getEntities() {
        return new HashSet<>(entities);
    }

    public final void transferTo(Move move) {
        if (move.inProgress()) {
            entities.add(move.getEntity());
            move.hasArrived();
            move.getStart().transferFrom(move);
        }
    }

    public final void transferFrom(Move move) {
        if (move.inProgress()) {
            entities.remove(move.getEntity());
            move.hasLeft();
            move.getDestination().transferTo(move);
        }
    }

    public void addLink(Tile tile, Direction direction) {
        links.put(direction, tile);
    }

    public void removeLink(Direction direction) {
        links.remove(direction);
    }

    public Tile getAdjacentOrThis(Direction direction) {
        return links.getOrDefault(direction, this);
    }

    public HashMap<Direction, Tile> getAdjacents() {
        return new HashMap<>(links);
    }
}
