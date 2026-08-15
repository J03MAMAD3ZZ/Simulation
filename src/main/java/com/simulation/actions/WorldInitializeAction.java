package com.simulation.actions;


import com.simulation.config.SimulationConfig;
import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.entity.EntityFactory;
import com.simulation.entity.EntityType;
import com.simulation.field.Field;

import java.util.*;

public class WorldInitializeAction implements Action {
    private final SimulationConfig config;

    public WorldInitializeAction(SimulationConfig config) {
        this.config = config;
    }

    @Override
    public void makeAction(Field field) {
        int index = 0;
        List<Coordinate> freeCoordinates = generateGrid(field);
        Map<EntityType, Integer> entitySpawnAmount = config.mapCopy();

        for (EntityType type : EntityType.values()) {
            for (int i = 0; i < entitySpawnAmount.get(type); i++) {
                Entity entity = EntityFactory.createEntity(type);
                field.addEntity(freeCoordinates.get(index), entity);
                index++;
            }
        }
    }

    private static List<Coordinate> generateGrid(Field field) {
        int height = field.getHeight();
        int width = field.getWidth();
        List<Coordinate> freeCoordinates = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Coordinate coordinate = new Coordinate(j, i);
                freeCoordinates.add(coordinate);
            }
        }
        Collections.shuffle(freeCoordinates);
        return freeCoordinates;
    }
}
