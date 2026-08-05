package com.simulation.pathFinder;

import com.simulation.coordinate.Coordinate;
import com.simulation.coordinate.SquareDirection;
import com.simulation.entity.Entity;
import com.simulation.field.Field;

import java.util.*;

public class BFSPathFinder implements PathFinder {
    private final SquareDirection direction = new SquareDirection();

    @Override
    public List<Coordinate> findPath(Field field, Coordinate start, Class<? extends Entity> target) {
        Queue<Coordinate> queue = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.remove();

            if (!current.equals(start)) {
                Entity entity = field.getEntityByCoordinate(current).orElse(null);

                if (target.isInstance(entity)) {
                    return pathReconstruction(parentMap, start, current);
                }
            }

            for (Coordinate c : direction.getDirection()) {
                Coordinate neighbour = current.coordinateShift(c);
                if (!field.isInBounds(neighbour) || visited.contains(neighbour)) {
                    continue;
                }

                Entity neighbourEntity = field.getEntityByCoordinate(neighbour).orElse(null);
                if (target.isInstance(neighbourEntity) || field.isCoordinateEmpty(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                    parentMap.put(neighbour, current);
                }

            }
        }
        return Collections.emptyList();
    }

    public List<Coordinate> pathReconstruction(Map<Coordinate, Coordinate> parentMap,
                                               Coordinate start, Coordinate finish) {
        List<Coordinate> path = new LinkedList<>();
        Coordinate current = finish;

        while (!current.equals(start)) {
            path.addFirst(current);
            current = parentMap.get(current);
        }

        path.addFirst(start);
        return path;
    }
}
