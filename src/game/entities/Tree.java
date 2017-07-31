package game.entities;

import game.description.Name;
import game.map.tiles.Tile;


public class Tree extends Entity {
    public Tree(Tile startingLocation) {
        super(new Name("a", "tree", "trees"), startingLocation);
    }
}
