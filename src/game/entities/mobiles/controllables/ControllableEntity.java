package game.entities.mobiles.controllables;

import game.entities.actions.Action;
import game.entities.mobiles.controllables.controllers.Controller;

import java.util.HashSet;
import java.util.Set;

public abstract class ControllableEntity {
    private Controller controller;

    public ControllableEntity(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Set<Action> generateActions() {
        return controller.getAction();
    }
}
