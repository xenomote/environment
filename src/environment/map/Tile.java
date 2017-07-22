package environment.map;

import environment.entities.MapEntity;

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
        return new ArrayList<>(entities);
    }

    public void addEntity(MapEntity entity) {
        entities.add(entity);
    }

    public void removeEntity(MapEntity entity) {
        entities.remove(entity);
    }
}
