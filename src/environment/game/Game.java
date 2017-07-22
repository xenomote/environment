package environment.game;

import environment.map.Area;
import environment.map.Map;
import environment.map.Position;
import environment.map.Tile;
import environment.tileGenerator.DummyTileGenerator;

public class Game {
    public static void main(String[] args) {
        Map gameMap = new Map(
                new Area(10, 10),
                new DummyTileGenerator()
        );

        Tile tile = gameMap.getTile(new Position(5, 5));
    }
}
