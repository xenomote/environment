package game.displays;

import game.entities.Entity;
import game.map.Area;
import game.map.Map;
import game.map.Position;
import game.map.tiles.Tile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TextDisplay implements Display {
    public TextDisplay() {

    }

    @Override
    public void display(Map map) {
        display(map, map.getArea(), map.getTopLeft());
    }

    @Override
    public void display(Map map, Area area, Position anchor) {
        for (int y = 0; y < area.getHeight(); y++) {
            for (int x = 0; x < area.getWidth(); x++) {
                Position delta = new Position(x, y);
                System.out.print(iconise(map.getTile(anchor.plus(delta))));
            }
            System.out.println();
        }
    }

    @Override
    public void examine(Map map, Position position) {
        System.out.println(describe(map.getTile(position)));
    }

    private String describe(Tile tile) {
        if (tile == null) {
            return "This area is unknown";
        }

        HashSet<Entity> entities = tile.getEntities();

        if (entities.isEmpty()) {
            return "There is nothing here";
        }

        else {
            return itemise(entities);
        }
    }

    private String itemise(Set<Entity> entities) {
        HashMap<String, Integer> items = new HashMap<>();
        entities.forEach(entity -> items.put(entity.getName(), items.getOrDefault(entity.getName(), 0) + 1));
        String itemisation = "";
        // TODO: 30/07/2017 fix
        return null;
    }

    private char iconise(Tile tile) {
        return tile != null ? '#' : ' ';

    }


}
