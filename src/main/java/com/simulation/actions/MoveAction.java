package com.simulation.actions;

import com.simulation.pathFinder.BFSPathFinder;
import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.entity.livingEntity.LivingEntity;
import com.simulation.field.Field;

import java.util.Optional;

public class MoveAction implements Action {
    private final BFSPathFinder pathFinder = new BFSPathFinder();

    @Override
    public void makeAction(Field field) {
        for (Coordinate coordinate : field.toMap().keySet()) {
            Optional<Entity> entity = field.getEntityByCoordinate(coordinate);
            if (entity.isEmpty()) {
                continue;
            }

            if (entity.get() instanceof LivingEntity e) {
                e.makeMove(field, pathFinder);
            }
        }
    }
}

