package game;

import game.displays.*;
import game.map.*;

public class Game {
    public static void main(String[] args) {
        Map map = new Map();
        Display display = new TextDisplay();

        for (int i = 0; i < 10; i++) {
            map.addTile(new Position(i, i));
        }

        System.out.println(map.getTopLeft());
        System.out.println(map.getBottomRight());
        System.out.println(map.getArea());

        display.display(map);
    }
}
