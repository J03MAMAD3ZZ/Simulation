package com.simulation.field;

import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;

import java.util.*;


public class Field {
    private int height;
    private int width;
    private final Map<Coordinate, Entity> entities = new HashMap<>();

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Map<Coordinate, Entity> toMap() {
        return new HashMap<>(entities);
    }

    public boolean isInBounds(Coordinate coordinate) {
        boolean isXInBounds = coordinate.x() >= 0 && coordinate.x() < height;
        boolean isYInBounds = coordinate.y() >= 0 && coordinate.y() < width;
        return isXInBounds && isYInBounds;
    }

    public Optional<Entity> getEntityByCoordinate(Coordinate coordinate){
        return Optional.ofNullable(entities.get(coordinate));
    }

    public Optional<Coordinate> getEntityCoordinate(Entity entity) {
        for (var e : toMap().entrySet()) {
            if (e.getValue().equals(entity)) {
                return Optional.of(e.getKey());
            }
        }
        return Optional.empty();
    }

    public void addEntity(Coordinate coordinate, Entity entity) {
        entities.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        entities.remove(coordinate);
    }

    public boolean isCoordinateEmpty(Coordinate coordinate) {
        return entities.get(coordinate) == null;
    }

}
