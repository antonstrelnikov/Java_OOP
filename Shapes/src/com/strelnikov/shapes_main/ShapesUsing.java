package com.strelnikov.shapes_main;

import com.strelnikov.shapes.*;

import java.util.Arrays;

public class ShapesUsing {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(2.3, 5.8),
                new Rectangle(3, 5),
                new Circle(8),
                new Square(5.8),
                new Triangle(2,1,3,4,7,0),
                new Circle(5.1),
                new Rectangle(2, 5),
        };

        Shape ShapeWithMaxArea = getShapeWithMaxArea(shapes);
    }

    private static Shape getShapeWithMaxArea(Shape[] shapes) {
        return null;
    }


}
