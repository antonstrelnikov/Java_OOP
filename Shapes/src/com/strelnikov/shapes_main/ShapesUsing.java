package com.strelnikov.shapes_main;

import com.strelnikov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class ShapesUsing {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(2.3, 5.8),
                new Rectangle(3, 5),
                new Circle(8),
                new Square(9.8),
                new Triangle(2, 1, 3, 4, 7, 0),
                new Circle(5.1),
                new Rectangle(2, 5),
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);

        System.out.println("Фигура с максимальной площадью: ");
        System.out.println("    Класс: " + maxAreaShape.getClass());
        System.out.println("    Площадь: " + maxAreaShape.getArea());
        System.out.println("    Периметр: " + maxAreaShape.getPerimeter());
        System.out.println("    Ширина: " + maxAreaShape.getWidth());
        System.out.println("    Высота: " + maxAreaShape.getHeight());
        System.out.println();

        Shape secondLargestAreaShape = getSecondLargestPerimeterShape(shapes);

        System.out.println("Фигура со вторым по величине периметром: ");
        System.out.println("    Класс: " + secondLargestAreaShape.getClass());
        System.out.println("    Площадь: " + secondLargestAreaShape.getArea());
        System.out.println("    Периметр: " + secondLargestAreaShape.getPerimeter());
        System.out.println("    Ширина: " + secondLargestAreaShape.getWidth());
        System.out.println("    Высота: " + secondLargestAreaShape.getHeight());
        System.out.println();
    }

    private static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(
                shapes,
                new Comparator<Shape>() {
                    @Override
                    public int compare(Shape shape1, Shape shape2) {
                        return (int) (shape1.getArea() - shape2.getArea());
                    }
                });

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondLargestPerimeterShape(Shape[] shapes) {
        Arrays.sort(
                shapes,
                new Comparator<Shape>() {
                    @Override
                    public int compare(Shape shape1, Shape shape2) {
                        return (int) (shape1.getPerimeter() - shape2.getPerimeter());
                    }
                });

        return shapes[shapes.length - 2];
    }
}
