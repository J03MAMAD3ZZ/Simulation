package com.simulation.actions;

import com.simulation.entity.Entity;
import com.simulation.entity.EntityType;
import com.simulation.field.Field;

import java.util.EnumMap;
import java.util.Map;

public class MaintainPopulaceAction implements Action {
    private static final double PREDATOR_PERCENT = 0.02;
    private static final double HERBIVORE_PERCENT = 0.05;
    private static final double GRASS_PERCENT = 0.10;
    private static final double ROCK_PERCENT = 0.05;
    private static final double TREE_PERCENT = 0.05;

    @Override
    public void makeAction(Field field) {
        int area = field.getHeight() * field.getWidth();


    }

//    private int populationFormula(Field field) {
//        Map<EntityType, Double> entitySpawnAmount = new EnumMap<>(EntityType.class);
//
//        for (Entity e : field.toMap().values()) {
//            if ()
//        }
//    }
}
