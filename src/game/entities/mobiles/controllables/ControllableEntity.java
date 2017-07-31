package game.entities.mobiles.controllables;

import game.entities.mobiles.controllables.controllers.Controller;

public abstract class ControllableEntity {
    private Controller controller;

    public ControllableEntity(Controller controller) {
        this.controller = controller;
    }

}
