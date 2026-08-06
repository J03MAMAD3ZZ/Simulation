package com.simulation.entity.livingEntity;

import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.entity.inanimateEntity.Grass;
import com.simulation.entity.inanimateEntity.InanimateEntity;
import com.simulation.field.Field;

public class Herbivore extends LivingEntity {

    public Herbivore(
            int hp,
            int speed,
            Class<? extends InanimateEntity> target) {
        super(hp, speed, Grass.class);
    }

    public void eatGrass(Field field, Coordinate targetPosition) {
        field.removeEntity(targetPosition);
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage);
    }

    @Override
    public void interactWithTarget(Field field, Coordinate targetPosition) {
        Entity target = field.getEntityByCoordinate(targetPosition).orElse(null);
        if (target instanceof Grass) {
            eatGrass(field, targetPosition);
        }
    }
}
