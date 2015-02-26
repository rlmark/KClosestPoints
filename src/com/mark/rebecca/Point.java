package com.mark.rebecca;

/**
 * Created by rebeccamark on 2/25/15.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int distanceSquaredToOrigin() {
        return (x * x) + (y * y);
        // in terms of sorting squrt doesn't matter
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
