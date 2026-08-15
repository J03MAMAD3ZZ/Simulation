package com.simulation.config;

import com.simulation.entity.EntityType;
import com.simulation.field.Field;
import com.simulation.field.fieldRenderer.ConsoleFieldRender;
import com.simulation.field.fieldRenderer.FieldRenderer;

import java.util.EnumMap;
import java.util.Map;

public record SimulationConfig(
        Field field,
        Map<EntityType, Integer> entitySpawnAmount,
        FieldRenderer renderer
) {

    public Map<EntityType, Integer> mapCopy() {
        return Map.copyOf(entitySpawnAmount);
    }

    public static SimulationConfig fromPreset(FieldPreset preset) {
        Map<EntityType, Integer> amount = new EnumMap<>(EntityType.class);
        int area = preset.getHeight() * preset.getWidth();

        amount.put(EntityType.PREDATOR, Math.max(1, area / 50));
        amount.put(EntityType.HERBIVORE, Math.max(1, area / 25));
        amount.put(EntityType.GRASS, Math.max(1, area / 10));
        amount.put(EntityType.ROCK, Math.max(1, area / 20));
        amount.put(EntityType.TREE, Math.max(1, area / 20));

        return new SimulationConfig(
                new Field(preset.getHeight(), preset.getWidth()),
                amount,
                new ConsoleFieldRender()
        );
    }
}
