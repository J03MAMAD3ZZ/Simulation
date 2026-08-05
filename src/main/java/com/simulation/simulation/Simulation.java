package com.simulation.simulation;

import com.simulation.actions.Action;
import com.simulation.actions.MaintainPopulaceAction;
import com.simulation.actions.MoveAction;
import com.simulation.actions.WorldInitializeAction;
import com.simulation.field.Field;
import com.simulation.field.fieldRenderer.ConsoleFieldRender;

import java.util.List;

public class Simulation {
    private final ConsoleFieldRender renderer = new ConsoleFieldRender();
    private int turnCounter = 1;
    private final Action initAction = new WorldInitializeAction();
    private final Object lock = new Object();
    private final List<Action> turnActions = List.of(
            new MoveAction(),
            new MaintainPopulaceAction()
    );

    public void startSimulation(Field field) {
        initAction.makeAction(field);
    }

    public void nextTurn(Field field) {
        while (turnCounter < 5) {
            renderer.renderField(field);
            printCurrentTurn();
            for (Action action : turnActions) {
                action.makeAction(field);
            }
            turnCounter++;
        }
        renderer.renderField(field);
        printCurrentTurn();
    }

    private void printCurrentTurn() {
        System.out.println("Turn: " + turnCounter);
    }

    public void pauseSimulation() {
    }
}
