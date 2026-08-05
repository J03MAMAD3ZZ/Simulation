package com.simulation.pathFinder;

import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.field.Field;

import java.util.List;

public interface PathFinder{
    List<Coordinate> findPath(Field field, Coordinate start, Class<? extends Entity> target);
}
