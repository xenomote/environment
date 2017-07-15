import java.util.ArrayList;

public class Tile {
    private final Position position;
    private final ArrayList<MapEntity> entities;

    public Tile(Position position, ArrayList<MapEntity> entities) {
        this.position = position;
        this.entities = entities;
    }

    public Position getPosition() {
        return position;
    }

    public ArrayList<MapEntity> getEntities() {
        return entities;
    }
}
