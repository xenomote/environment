package game.map;

import static game.map.Position.*;

public class Area {
    Position dimensions;

    public Area(int width, int height) {
        this.dimensions = new Position(width, height);
    }

    public Area(Position dimensions) {
        this.dimensions = dimensions;
    }

    public int getWidth() {
        return dimensions.getX();
    }

    public int getHeight() {
        return dimensions.getY();
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

    public Position getDimensions() {
        return dimensions;
    }

    public Area withWidth(int width) {
        return new Area(width, getHeight());
    }

    public Area withHeight(int height) {
        return new Area(getWidth(), height);
    }

    public boolean contains(Position position) {
        return position.lowerRightOf(ORIGIN.minus(ONE)) &&
                position.upperLeftOf(dimensions);
    }

    @Override
    public String toString() {
        return "" + getWidth() + "x" + getHeight();
    }
}
