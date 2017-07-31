package game.turns;

import game.entities.Entity;
import game.entities.actions.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Turn {
    private HashMap<Entity, Set<Action>> actions;
    private boolean complete;

    public Turn(Set<Entity> entities) {
        this.complete = false;
        this.actions = gatherActions(entities);
    }

    private HashMap<Entity,Set<Action>> gatherActions(Set<Entity> entities) {
        HashMap<Entity, Set<Action>> actions = new HashMap<>();

        for(Entity entity : entities) {
            actions.put(entity, entity.generateActions());
        }

        return actions;
    }


    public ArrayList<Set<Action>> getActions() {
        return new ArrayList<>(actions.values());
    }

    public void execute() {
        if (!complete) {
            for (Set<Action> intentionSet : actions.values()) {
                for (Action intent : intentionSet) {
                    intent.executeAction();
                }
            }

            complete = true;
        }
    }

    public Turn getNextTurn() {
        if (!complete) return this;
        else return new Turn(actions.keySet());
    }
}
