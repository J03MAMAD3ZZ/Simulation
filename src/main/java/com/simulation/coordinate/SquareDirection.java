package com.simulation.coordinate;

import java.util.List;

public class SquareDirection implements Direction{
    private final Coordinate UP = new Coordinate(0,1);
    private final Coordinate DOWN = new Coordinate(0,-1); // down
    private final Coordinate RIGHT = new Coordinate(1,0);// right
    private final Coordinate LEFT = new Coordinate(-1,0); // left
//    private final Coordinate RIGHT_UP = new Coordinate(1,1);// right-up
//    private final Coordinate LEFT_UP = new Coordinate(-1,1); // left-up
//    private final Coordinate RIGHT_DOWN = new Coordinate(1,-1); // right-down
//    private final Coordinate LEFT_DOWN = new Coordinate(-1,-1); // left-down

    private final List<Coordinate> SHIFT_DIRECTIONS = List.of(
            UP,
            DOWN,
            RIGHT,
            LEFT
//            RIGHT_UP,
//            LEFT_UP,
//            RIGHT_DOWN,
//            LEFT_DOWN
    );

    public SquareDirection() {
    }

    @Override
    public List<Coordinate> getDirection() {
        return SHIFT_DIRECTIONS;
    }
}
