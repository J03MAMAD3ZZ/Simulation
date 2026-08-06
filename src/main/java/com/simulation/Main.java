package com.simulation;


import com.simulation.field.Field;
import com.simulation.field.fieldRenderer.ConsoleFieldRender;
import com.simulation.field.fieldRenderer.FieldRenderer;
import com.simulation.simulation.Simulation;


public class Main {
    Field field = new Field(10,10);
    FieldRenderer renderer = new ConsoleFieldRender();
    Simulation simulation = new Simulation(field, renderer);

    void main() {
        simulation.startSimulation(field);
        simulation.nextTurn(field);
    }
}
