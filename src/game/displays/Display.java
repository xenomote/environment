package game.displays;

import game.map.Area;
import game.map.Map;
import game.map.Position;

public interface Display {
    void display(Map map);
    void display(Map map, Area area, Position anchor);
    void examine(Map map, Position position);
}