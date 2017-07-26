package game.displays;

import game.map.Area;
import game.map.Map;
import game.map.Position;
import game.map.tiles.Tile;

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

    private char iconise(Tile tile) {
        return tile != null ? '#' : ' ';

    }


}
