package com.strelnikov.shapes;

public class Square implements Shape {
    private double sideLength;
    private static final int sideNumber = 4;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideNumber * sideLength;
    }

    @Override
    public String toString() {
        return "Square. SideLength: " + sideLength;
    }

    @Override
    public boolean equals(Object shape) {
        if (shape == this) {
            return true;
        }

        if (shape == null || shape.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) shape;

        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }


}
