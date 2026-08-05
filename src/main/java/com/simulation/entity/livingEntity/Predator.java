package com.simulation.entity.livingEntity;

import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.field.Field;

public class Predator extends LivingEntity {
    private int attackPower;

    public Predator(int hp,
                    int speed,
                    Class<? extends LivingEntity> target,
                    int attackPower) {
        super(hp, speed, Herbivore.class);
        this.attackPower = attackPower;
    }



    @Override
    public void interactWithTarget(Field field, Coordinate targetPosition) {
        Entity target = field.getEntityByCoordinate(targetPosition).orElse(null);
        if (target instanceof Herbivore herbivore) {
            herbivore.takeDamage(attackPower);
            if (herbivore.getHp() <= 0) {
                field.removeEntity(targetPosition);
            }
        }
    }
}
