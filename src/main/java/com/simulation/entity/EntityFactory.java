package com.simulation.entity;

import com.simulation.entity.inanimateEntity.Grass;
import com.simulation.entity.inanimateEntity.Rock;
import com.simulation.entity.inanimateEntity.Tree;
import com.simulation.entity.livingEntity.Herbivore;
import com.simulation.entity.livingEntity.Predator;

public class EntityFactory {
    public static Entity createEntity(EntityType type) {
        return switch (type) {
            case PREDATOR -> new Predator(100, 2, Herbivore.class, 50);
            case HERBIVORE -> new Herbivore(100, 1, Grass.class);
            case GRASS -> new Grass();
            case ROCK -> new Rock();
            case TREE -> new Tree();
        };
    }
}
