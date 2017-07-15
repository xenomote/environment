public abstract class MapEntity {
    private Tile location;

    public MapEntity(Tile startingLocation) {
        this.location = startingLocation;
    }

    public final void setLocation(Tile newLocation) {
        location.removeEntity(this);
        newLocation.addEntity(this);
        this.location = newLocation;
    }
}
