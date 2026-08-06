package com.simulation.simulation;

import com.simulation.actions.Action;
import com.simulation.actions.MaintainPopulaceAction;
import com.simulation.actions.MoveAction;
import com.simulation.actions.WorldInitializeAction;
import com.simulation.entity.Entity;
import com.simulation.entity.livingEntity.Herbivore;
import com.simulation.field.Field;
import com.simulation.field.fieldRenderer.FieldRenderer;

import java.util.List;

public class Simulation {
    private final Field field;
    private final FieldRenderer renderer;
    private int turnCounter = 1;
    private final Action initAction = new WorldInitializeAction();
    private final List<Action> turnActions = List.of(
            new MoveAction(),
            new MaintainPopulaceAction()
    );

    public Simulation(Field field, FieldRenderer renderer) {
        this.field = field;
        this.renderer = renderer;
    }

    public void startSimulation(Field field) {
        initAction.makeAction(field);
    }

    public void nextTurn(Field field) {
        while (!endSimulation()) {
            renderer.renderField(field);
            printCurrentTurn();
            for (Action action : turnActions) {
                action.makeAction(field);
            }
            turnCounter++;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        renderer.renderField(field);
        printCurrentTurn();
        System.out.println("Game Over!");
    }

    private void printCurrentTurn() {
        System.out.println("Turn: " + turnCounter);
    }

    private boolean endSimulation() {
        for (Entity entity : field.toMap().values()) {
            if (entity instanceof Herbivore) {
                return false;
            }
        }
        return true;
    }
}
