package game.map;

public class Position {
    private static final int HASH_FACTOR = 17;

    public static final Position ORIGIN = new Position(0, 0);
    public static final Position ONE = new Position(1, 1);

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position withX(int x) {
        return new Position(x, getY());
    }

    public Position withY(int y) {
        return new Position(getX(), y);
    }

    public Position plus(Position other) {
        return new Position(getX() + other.getX(), getY() + other.getY());
    }

    public Position plus(Direction direction) {
        return plus(direction.relativePosition);
    }

    public Position minus(Position other) {
        return plus(other.negated());
    }

    public Position minus(Direction direction) {
        return minus(direction.relativePosition);
    }

    public Position negated() {
        return new Position(-getX(), -getY());
    }

    public boolean above(Position other) {
        return getY() < other.getY();
    }

    public boolean below(Position other) {
        return getY() > other.getY();
    }

    public boolean leftOf(Position other) {
        return getX() < other.getX();
    }

    public boolean rightOf(Position other) {
        return getX() > other.getX();
    }

    public boolean upperLeftOf(Position other) {
        return above(other) && leftOf(other);
    }

    public boolean upperRightOf(Position other) {
        return above(other) && rightOf(other);
    }

    public boolean lowerLeftOf(Position other) {
        return below(other) && leftOf(other);
    }

    public boolean lowerRightOf(Position other) {
        return below(other) && rightOf(other);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        else if (obj instanceof Position) {
            Position other = (Position) obj;
            return other.getX() == getX() && other.getY() == getY();
        }

        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + getX() + ":" + getY();
    }

    @Override
    public int hashCode() {
        return (getX() * HASH_FACTOR) ^ getY();
    }
}
