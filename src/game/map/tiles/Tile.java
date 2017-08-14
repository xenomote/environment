package game.map.tiles;

import game.entities.EntityManager;
import game.map.Direction;
import game.entities.Entity;
import game.entities.actions.moves.Move;

import java.util.HashMap;
import java.util.HashSet;

public class Tile extends EntityManager{
    private final HashMap<Direction, Tile> links;

    public Tile() {
        this.links = new HashMap<>();
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
