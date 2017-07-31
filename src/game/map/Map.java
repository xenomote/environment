package game.map;

import game.map.tiles.Tile;

import static game.map.Position.*;

import java.util.HashMap;
import java.util.HashSet;

public class Map {
    private final HashMap<Position, Tile> map;
    private Position topLeft;
    private Position bottomRight;

    public Map() {
        this.map = new HashMap<>();
        this.topLeft = ORIGIN;
        this.bottomRight = ORIGIN;
    }

    public Tile addTile(Position position) {
        updateBoundaries(position);
        return map.put(position, new Tile());
    }

    /**
     * Updates the topLeft and bottomRight markers to include the new position
     * @param position The new position to include
     */
    private void updateBoundaries(Position position) {
        if (position.upperLeftOf(topLeft)) {
            topLeft = position;
        }

        else if (position.lowerRightOf(bottomRight)) {
            bottomRight = position;
        }

        else if (position.above(topLeft)) {
            topLeft = topLeft.withY(position.getY());
        }

        else if (position.below(bottomRight)) {
            bottomRight = bottomRight.withY(position.getY());
        }

        else if (position.leftOf(topLeft)) {
            topLeft = topLeft.withX(position.getX());
        }

        else if (position.rightOf(bottomRight)) {
            bottomRight = bottomRight.withX(position.getX());
        }
    }

    /**
     * Joins all tiles in the map to all their adjacent neighbors
     */
    public void joinTiles() {
        for(Position position : map.keySet()) {
            joinTile(position);
        }
    }

    /**
     * Joins a tile to all of its immediate neighbours and vice versa
     * @param position The tile to join
     */
    public void joinTile(Position position) {
        for (Direction direction : Direction.values()) {
            joinTile(position, direction);
        }
    }

    /**
     * Joins a tile to its neighbour tile in the given direction
     * @param position The tile to join
     * @param direction The direction to the neighbor tile
     */
    public void joinTile(Position position, Direction direction) {
        joinTiles(position, direction, position.plus(direction));
    }

    /**
     *
     * @param first
     * @param direction
     * @param second
     */
    public void joinTiles(Position first, Direction direction, Position second) {
        if (hasTile(first) && hasTile(second)) {
            Tile from = getTile(first);
            Tile to = getTile(second);

            from.addLink(to, direction);
            to.addLink(from, direction.getOpposite());
        }
    }

    public boolean hasTile(Position position) {
        return map.containsKey(position);
    }

    public Tile getTile(Position position) {
        return map.get(position);
    }

    public HashSet<Tile> getTiles() {
        return new HashSet<>(map.values());
    }

    public Position getTopLeft() {
        return topLeft;
    }

    private Position getTopRight() {
        return new Position(bottomRight.getX(), topLeft.getY());
    }

    public Position getBottomRight() {
        return bottomRight;
    }

    private Position getBottomLeft() {
        return new Position(topLeft.getX(), bottomRight.getY());
    }

    public Area getArea() {
        return new Area(bottomRight.minus(topLeft).plus(ONE));
    }
}
