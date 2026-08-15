package com.simulation.simulation;

import com.simulation.actions.Action;
import com.simulation.actions.MoveAction;
import com.simulation.actions.WorldInitializeAction;
import com.simulation.config.SimulationConfig;
import com.simulation.entity.Entity;
import com.simulation.entity.livingEntity.Herbivore;
import com.simulation.field.Field;

import java.util.List;

public class Simulation {
    private final SimulationConfig config;
    private int turnCounter = 1;
    private final Action initAction;
    private final List<Action> turnActions = List.of(new MoveAction());

    public Simulation(SimulationConfig config) {
        this.config = config;
        this.initAction = new WorldInitializeAction(config);
    }

    public void startSimulation(SimulationConfig config) {
        initAction.makeAction(config.field());
        nextTurn(config);
    }

    public void nextTurn(SimulationConfig config) {
        Field field = config.field();
        while (!endSimulation()) {
            config.renderer().renderField(field);
            printCurrentTurn();
            for (Action action : turnActions) {
                action.makeAction(field);
            }
            turnCounter++;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        config.renderer().renderField(field);
        printCurrentTurn();
        System.out.println("Game Over! All the herbivores are gone!");
    }

    private void printCurrentTurn() {
        System.out.println("Turn: " + turnCounter);
    }

    private boolean endSimulation() {
        Field field = config.field();
        for (Entity entity : field.toMap().values()) {
            if (entity instanceof Herbivore) {
                return false;
            }
        }
        return true;
    }
}
