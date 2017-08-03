package game.displays;

import game.description.Name;
import game.entities.Entity;
import game.map.Area;
import game.map.Map;
import game.map.Position;
import game.map.tiles.Tile;

import java.util.*;

public class TextDisplay implements Display {
    public static void main(String[] args) {

    }

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
                System.out.print(iconify(map.getTile(anchor.plus(delta))));
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
            return "There is nothing here";
        }

        HashSet<Entity> entities = tile.getEntities();

        if (entities.isEmpty()) {
            return "This area is empty";
        }

        else {
            return itemise(entities);
        }
    }

    private String itemise(Set<Entity> entities) {
        HashMap<Name, Integer> items = new HashMap<>();
        entities.forEach(entity -> items.put(entity.getName(), items.getOrDefault(entity.getName(), 0) + 1));
        String[] itemisation = new String[items.keySet().size() * 2 - 1];

        int i = 0;
        for (Name name : items.keySet()) {
            itemisation[i] = name.getFullName(items.get(name));
            i += 2;
        }



        for (int j = i - 3; j > 0; j -= 2) {
            itemisation[j] = ", ";
        }
        //if (entities.size() > 2) itemisation[i] = " and ";

        return String.join("", itemisation);
    }

    private char iconify(Tile tile) {
        if (tile == null) {
            return ' ';
        }

        else if (tile.getEntities().isEmpty()) {
            return '_';
        }

        else {
            return '#';
        }
    }
}
