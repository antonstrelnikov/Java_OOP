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
                new Triangle(2, 1, 3, 50, 7, 0),
                new Circle(5.1),
                new Rectangle(2, 5),
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);
        Shape secondLargestPerimeterShape = getSecondLargestPerimeterShape(shapes);

        if (maxAreaShape == null || secondLargestPerimeterShape == null) {
            System.out.println("Массив фигур пуст");

            return;
        }

        System.out.println("Фигура с максимальной площадью: ");
        System.out.println("    Класс: " + maxAreaShape.getClass());
        System.out.println("    Площадь: " + maxAreaShape.getArea());
        System.out.println("    Периметр: " + maxAreaShape.getPerimeter());
        System.out.println("    Ширина: " + maxAreaShape.getWidth());
        System.out.println("    Высота: " + maxAreaShape.getHeight());
        System.out.println();
        System.out.println("Фигура со вторым по величине периметром: ");
        System.out.println("    Класс: " + secondLargestPerimeterShape.getClass());
        System.out.println("    Площадь: " + secondLargestPerimeterShape.getArea());
        System.out.println("    Периметр: " + secondLargestPerimeterShape.getPerimeter());
        System.out.println("    Ширина: " + secondLargestPerimeterShape.getWidth());
        System.out.println("    Высота: " + secondLargestPerimeterShape.getHeight());
        System.out.println();
    }

    private static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondLargestPerimeterShape(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[shapes.length - 2];
    }
}
