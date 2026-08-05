package com.simulation.entity;

public enum EntityType {
    PREDATOR("\uD83D\uDC3A"),
    HERBIVORE("\uD83E\uDD8C"),
    GRASS("\uD83C\uDF31"),
    ROCK("\uD83E\uDEA8"),
    TREE("\uD83C\uDF32");

    EntityType(String sprite) {
        this.sprite = sprite;
    }

    private final String sprite;

    public String getSprite() {
        return sprite;
    }
}
