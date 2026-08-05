package com.simulation.entity.livingEntity;


import com.simulation.pathFinder.BFSPathFinder;
import com.simulation.coordinate.Coordinate;
import com.simulation.entity.Entity;
import com.simulation.field.Field;

import java.util.List;

public abstract class LivingEntity extends Entity {
    private int hp;
    private int speed;
    private Class<? extends Entity> target;

    public LivingEntity(int hp, int speed, Class<? extends Entity> target) {
        this.hp = hp;
        this.speed = speed;
        this.target = target;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void makeMove(Field field, BFSPathFinder finder) {
        Coordinate start = field.getEntityCoordinate(this)
                .orElseThrow();
        BFSPathFinder pathFinder = new BFSPathFinder();
        List<Coordinate> path = pathFinder.findPath(field, start, target);

        int stepsTaken = 0;
        for (int i = 1; i < path.size() && stepsTaken < getSpeed(); i++) {
            Coordinate nextPosition = path.get(i);
            Entity entityAtNextPosition = field.getEntityByCoordinate(nextPosition).orElse(null);

            if (target.isInstance(entityAtNextPosition)) {
                interactWithTarget(field, nextPosition);
                break;
            }

            field.removeEntity(start);
            field.addEntity(nextPosition, this);
            start = nextPosition;
            stepsTaken++;
        }
    }

    public abstract void interactWithTarget(Field field, Coordinate targetPosition);
}
