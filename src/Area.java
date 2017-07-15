public class Area {
    int width;
    int height;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

    public Area withWidth(int width) {
        return new Area(width, getHeight());
    }

    public Area withHeight(int height) {
        return new Area(getWidth(), height);
    }
}
