package game;

import game.displays.*;
import game.entities.Tree;
import game.map.*;

import static game.map.Position.*;

public class Game {
    public static void main(String[] args) {
        Map map = new Map();
        Display display = new TextDisplay();

        for (int i = 0; i < 10; i++) {
            map.addTile(new Position(i, i));
        }

        map.joinTiles();

        Tree tree = new Tree(map.getTile(ORIGIN));
        Tree tree2 = new Tree(map.getTile(ORIGIN));

        System.out.println(tree.getName().hashCode());
        System.out.println(tree2.getName().hashCode());

        System.out.println(map.getTopLeft());
        System.out.println(map.getBottomRight());
        System.out.println(map.getArea());

        display.examine(map, ORIGIN);

        display.display(map);
    }
}
