package com.antonstrelnikov.range_main;

import com.antonstrelnikov.range.Range;

import java.util.Scanner;

public class RangeUsing {
    public static final String infoCommand = "info";
    public static final String setCommand = "set";
    public static final String checkCommand = "check";
    public static final String exitCommand = "exit";
    public static final String unionCommand = "union";
    public static final String intersectionCommand = "intersection";
    public static final String differenceCommand = "difference";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите певрое число диапазона: ");
        double rangeFirstNumber = scanner.nextDouble();

        System.out.println("Введите последнее число диапазона: ");
        double rangeLastNumber = scanner.nextDouble();
        scanner.nextLine();

        Range range = new Range(rangeFirstNumber, rangeLastNumber);

        System.out.println("Допустимые команды: ");
        System.out.println("info - получение информации о диапазоне");
        System.out.println("check - проверка принадлежности числа диапазону");
        System.out.println("set - для изменения начального и конечного чисел диапазона");
        System.out.println("union - объединение диапазона с другим");
        System.out.println("intersection - пересечение диапазона с другим");
        System.out.println("difference - разность диапазона с другим");
        System.out.println("exit - для выхода из программы");
        System.out.println();

        while (true) {
            System.out.println("Введите команду: ");
            String command = scanner.nextLine();

            if (command.equals(exitCommand)) {
                return;
            }

            if (command.equals(infoCommand)) {
                System.out.println("Длина диапазона: " + range.getLength());
                System.out.println("Первое число диапазона: " + range.getFrom());
                System.out.println("Последнее число диапазона: " + range.getTo());
                System.out.println();

                continue;
            }

            if (command.equals(checkCommand)) {
                System.out.println("Введите число для проверки: ");
                double number = scanner.nextDouble();
                scanner.nextLine();

                if (range.isInside(number)) {
                    System.out.printf("Число %.2f принадлежит диапазону от %.2f до %.2f%n", number, range.getFrom(), range.getTo());
                } else {
                    System.out.printf("Число %.2f не принадлежит диапазону от %.2f до %.2f%n", number, range.getFrom(), range.getTo());
                }

                System.out.println();

                continue;
            }

            if (command.equals(setCommand)) {
                System.out.println("Введите певрое число диапазона: ");
                rangeFirstNumber = scanner.nextDouble();

                System.out.println("Введите последнее число диапазона: ");
                rangeLastNumber = scanner.nextDouble();
                scanner.nextLine();

                range.setFrom(rangeFirstNumber);
                range.setTo(rangeLastNumber);

                System.out.println("Дианазон задан успешно: ");

                System.out.println();

                continue;
            }

            if (command.equals(unionCommand)) {
                System.out.println("Введите певрое число для второго диапазона: ");
                double from = scanner.nextDouble();

                System.out.println("Введите последнее число для второго диапазона: ");
                double to = scanner.nextDouble();

                Range range2 = new Range(from, to);

                scanner.nextLine();

                Range[] union = range.getUnion(range2);
                StringBuilder unionResult = new StringBuilder();

                for (Range unionRange : union) {
                    unionResult.append(unionRange.toString()).append(" ");
                }

                System.out.println("Результат объединения: " + unionResult);

                System.out.println();

                continue;
            }

            if (command.equals(intersectionCommand)) {
                System.out.println("Введите певрое число для второго диапазона: ");
                double from = scanner.nextDouble();

                System.out.println("Введите последнее число для второго диапазона: ");
                double to = scanner.nextDouble();

                Range range2 = new Range(from, to);

                scanner.nextLine();

                Range intersection = range.getIntersection(range2);

                if (intersection != null) {
                    System.out.println("Результат пересечения: " + intersection.toString());
                } else {
                    System.out.println("Диапазоны не пересекаются!");
                }

                System.out.println();

                continue;
            }

            if (command.equals(differenceCommand)) {
                System.out.println("Введите певрое число для вычитаемого диапазона: ");
                double from = scanner.nextDouble();

                System.out.println("Введите последнее число для вычитаемого диапазона: ");
                double to = scanner.nextDouble();

                Range subtractedRange = new Range(from, to);

                scanner.nextLine();

                Range[] difference = range.getDifference(subtractedRange);

                if (difference.length == 0) {
                    System.out.println("Результат вычитания - пустое множество");

                    System.out.println();

                    continue;
                }

                StringBuilder differenceResult = new StringBuilder();

                for (Range differenceRange : difference) {
                    differenceResult.append(differenceRange.getFrom()).append(" ");
                }

                System.out.println("Результат вычитания: " + differenceResult);

                System.out.println();

                continue;
            }

            System.out.println("Неизвестная команда. Попробуйте еще раз.");
        }
    }
}
