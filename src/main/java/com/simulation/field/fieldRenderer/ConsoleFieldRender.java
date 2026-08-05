package com.simulation.field.fieldRenderer;

import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.entity.EntityType;
import com.simulation.field.Field;

import java.util.Optional;

public class ConsoleFieldRender implements FieldRenderer {
    private static final String GROUND = "\u2B1B";
    private static final String RESET = "\u001B[0m";

    @Override
    public void renderField(Field field) {
        int height = field.getHeight();
        int width = field.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                System.out.print(getSprite(field, coordinate) + RESET);
            }
            System.out.println();
        }
    }

    private static String getSprite(Field field, Coordinate coordinate) {
        Optional<Entity> optionalEntity = field.getEntityByCoordinate(coordinate);
        if (optionalEntity.isEmpty()) {
            return GROUND;
        }
        Entity entity = optionalEntity.get();
        String name = entity.getClass().getSimpleName().toUpperCase();
        return EntityType.valueOf(name).getSprite();
    }
}


