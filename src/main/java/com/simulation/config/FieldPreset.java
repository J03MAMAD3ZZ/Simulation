package com.simulation.config;

public enum FieldPreset {
    SMALL(10, 10),
    MEDIUM(15, 15),
    LARGE(20, 20);

    private final int height;
    private final int width;

    FieldPreset(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
