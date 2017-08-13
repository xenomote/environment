package game.entities;

import game.entities.actions.Action;

import java.util.HashSet;
import java.util.Set;

public class EntityManager extends HashSet<Entity>{
    public void executeTurn() {
        executeActions(gatherActions());
    }

    private void executeActions(Set<Action> actions) {
        for (Action action : actions) {
            action.executeAction();
        }
    }

    private HashSet<Action> gatherActions() {
        HashSet<Action> actions = new HashSet<>();
        for (Entity entity : this) {
            actions.addAll(entity.generateActions());
        }
        return actions;
    }
}