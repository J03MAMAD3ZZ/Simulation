package com.simulation;


import com.simulation.field.Field;
import com.simulation.simulation.Simulation;


public class Main {
    Field field = new Field(10,10);
    Simulation simulation = new Simulation();

    void main() {
        simulation.startSimulation(field);
        simulation.nextTurn(field);
    }
}
