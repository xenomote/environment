package environment.game;

import environment.map.*;
import environment.tileGenerator.DummyTileGenerator;

import static environment.map.Position.ONE;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class GameDisplay {
    private final Map map;
    private final PrintWriter out;

    public static void main(String[] args) {
        Map gameMap = new Map(
                new Area(10, 10),
                new DummyTileGenerator()
        );

        GameDisplay display = new GameDisplay(gameMap, System.out);

        display.showMap();

        for (int i = 0; i < 10; i++) {
            gameMap.getTile(new Position(i, i));
        }

        gameMap.getTile(new Position(9, 0));

        display.showMap();

        display.showView(
                new Area(4, 4),
                new Position(0, 1)
                );
    }

    public GameDisplay(Map map, OutputStream out) {
        this.map = map;
        this.out = new PrintWriter(out, true);
    }

    public void showMap() {
        display(getMapImage());
    }

    public void showView(Area area, Position topLeft) {
        display(getMapView(area, topLeft));
    }

    private void display(char[][] mapImage) {
        for (int y = 0; y < mapImage[0].length; y++) {
            for (int x = 0; x < mapImage.length; x++) {
                out.print(mapImage[x][y]);
            }
            out.println();
        }
    }

    private char[][] getMapImage() {
        char[][] mapImage = generateBlankImage(map.getArea());
        ArrayList<Tile> tiles = new ArrayList<>(map.getTileManager().getActiveTiles().values());

        for (Tile tile : tiles) {
            Position position = tile.getPosition();
            mapImage[position.getX()][position.getY()] = iconiseTile(tile);
        }

        return mapImage;
    }

    private char[][] getMapView(Area area, Position topLeft) {
        char[][] viewImage = generateBlankImage(area);
        HashMap<Position, Tile> tiles = map.getTileManager().getActiveTiles();

        for (Position position : tiles.keySet()) {
            Position relative = position.minus(topLeft);
            if (area.contains(relative)) {
                System.out.println("" + relative.getX() + "-" + relative.getY() + " within");
                Tile tile = tiles.get(position);
                viewImage[relative.getX()][relative.getY()] = iconiseTile(tile);
            }
        }

        return viewImage;
    }

    private int tileno = 0;
    private char iconiseTile(Tile tile) {
        // TODO: 19/07/2017 proper iconisation
        return Character.forDigit(tile.getPosition().getX(), 10);
    }

    private char[][] generateBlankImage(Area area) {
        return new char[area.getWidth()][area.getHeight()];
    }
}