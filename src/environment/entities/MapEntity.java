package environment.entities;

import environment.map.Tile;

public abstract class MapEntity {
    private Tile location;

    public MapEntity(Tile startingLocation) {
        startingLocation.addEntity(this);
        this.location = startingLocation;
    }

    public final void setLocation(Tile newLocation) {
        location.removeEntity(this);
        newLocation.addEntity(this);
        this.location = newLocation;
    }
}
