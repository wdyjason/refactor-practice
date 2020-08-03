package com.twu.refactoring;

public class Direction {
    private final char direction;
    public final static char NORTH = 'N';
    public final static char SOUTH = 'S';
    public final static char EAST = 'E';
    public final static char WEST = 'W';


    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        switch (direction) {
            case NORTH:
                return new Direction(EAST);
            case SOUTH:
                return new Direction(WEST);
            case EAST:
                return new Direction(NORTH);
            case WEST:
                return new Direction(SOUTH);
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        switch (direction) {
            case NORTH:
                return new Direction(WEST);
            case SOUTH:
                return new Direction(EAST);
            case EAST:
                return new Direction(NORTH);
            case WEST:
                return new Direction(SOUTH);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction directionAnother = (Direction) o;

        if (direction != directionAnother.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
