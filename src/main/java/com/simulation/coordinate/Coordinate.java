package com.simulation.coordinate;

public record Coordinate(int x, int y) {
    public Coordinate coordinateShift(Coordinate coordinate){
        int newX = coordinate.x();
        int newY = coordinate.y();

        return new Coordinate(x + newX, y + newY);
    }
}
