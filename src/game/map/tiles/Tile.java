package game.map.tiles;

import game.map.Direction;
import game.map.tiles.entities.StaticEntity;
import game.map.tiles.entities.moves.Move;

import java.util.HashMap;
import java.util.HashSet;

public class Tile {
    private final HashSet<StaticEntity> entities;
    private final HashMap<Direction, Tile> links;

    public Tile() {
        this.entities = new HashSet<>();
        this.links = new HashMap<>();
    }

    public HashSet<StaticEntity> getEntities() {
        return new HashSet<>(entities);
    }

    public final void transferTo(Move move) {
        if (move.inProgress()) {
            entities.add(move.getEntity());
            move.hasReceived();
            move.getEntity().move(move);
        }
    }

    public final void transferFrom(Move move) {
        if (move.inProgress()) {
            entities.remove(move.getEntity());
            move.hasLeft();
            move.getTo().transferTo(move);
        }
    }

    public void addLink(Tile tile, Direction direction) {
        links.put(direction, tile);
    }

    public void removeLink(Direction direction) {
        links.remove(direction);
    }

    public Tile getAdjacent(Direction direction) {
        return links.getOrDefault(direction, this);
    }

    public HashMap<Direction, Tile> getAdjacents() {
        return new HashMap<>(links);
    }
}
