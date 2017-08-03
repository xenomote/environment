package game.entities.mobiles.controllables.controllers;

import game.entities.actions.Action;

import java.util.Set;

public interface Controller {
    public Set<Action> getAction();
}
