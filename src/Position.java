public class Position {
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
}
