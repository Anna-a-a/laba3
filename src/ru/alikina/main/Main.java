package ru.alikina.main;

import ru.alikina.geometry.Line;
import ru.alikina.geometry.Point;
import ru.alikina.numbers.SumCalculator;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main <X> <Y>");

        }

        try {
            double result = Math.pow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка , введите корректные данные.");
        }
        Scanner scanner = new Scanner(System.in);
        // Пример 1: Создание линий и проверка, что они не ссылаются на один и тот же объект точки
        ru.alikina.geometry.Point start1 = new ru.alikina.geometry.Point(1, 3);
        ru.alikina.geometry.Point end1 = new ru.alikina.geometry.Point(23, 8);
        ru.alikina.geometry.Point start2 = new ru.alikina.geometry.Point(5, 10);
        ru.alikina.geometry.Point end2 = new ru.alikina.geometry.Point(25, 10);

        ru.alikina.geometry.Line line1 = new ru.alikina.geometry.Line(start1, end1);
        ru.alikina.geometry.Line line2 = new ru.alikina.geometry.Line(start2, end2);
        ru.alikina.geometry.Line line3 = new ru.alikina.geometry.Line(start1, end2);

        System.out.println("Линия 1: " + line1.toString());
        System.out.println("Линия 2: " + line2.toString());
        System.out.println("Линия 3: " + line3.toString());

        // Пример 2: Изменение координат начала и конца линии
        ru.alikina.geometry.Point newStart1 = new ru.alikina.geometry.Point(3, 3);
        ru.alikina.geometry.Point newEnd1 = new ru.alikina.geometry.Point(5, 5);
        line1.setStart(newStart1);
        line1.setEnd(newEnd1);

        System.out.println("Линия 1 после изменения: " + line1.toString());
        System.out.println("Линия 2 после изменения: " + line2.toString());
        System.out.println("Линия 3 после изменения: " + line3.toString());

        // Пример 3: Запрос координат начала и конца линии
        System.out.println("Начало линии 1: " + line1.getStart().toString());
        System.out.println("Конец линии 1: " + line1.getEnd().toString());

        // Пример 4: Создание новой линии и вывод ее длины
        ru.alikina.geometry.Line line = new ru.alikina.geometry.Line(new ru.alikina.geometry.Point(1, 1), new ru.alikina.geometry.Point(10, 15));
        System.out.println(line);
        System.out.println("Длина линии: " + line.getDistance());


        //2
        System.out.println("Введите список чиселразделенный пробелами:");
        int[] userValues = readIntArray(scanner);
        ru.alikina.numbers.ImmutableList list1 = new ru.alikina.numbers.ImmutableList(userValues);
        System.out.println("Список : " + list1);

        System.out.println("Введите индекс элемента для замены");
        int index = readInt(scanner);
        System.out.println("Введите число :");
        int newValue = readInt(scanner);
        ru.alikina.numbers.ImmutableList updatedList = list1.setValue(index, newValue);
        System.out.println("Обновленный список: " + updatedList);


        // Определяем размер массива
        System.out.println("Введите размер списка:");
        int size = readInt(scanner);

        // Создаем массив заданного размера
        int[] array = new int[size];

        // Наполняем массив значениями, введенными пользователем
        for (int i = 0; i < array.length; i++) {
            System.out.println("введите элемент " + (i + 1) + ":");
            array[i] = readInt(scanner);
        }

        ru.alikina.numbers.ImmutableList list2 = new ru.alikina.numbers.ImmutableList(array);
        System.out.println(list2);

        ru.alikina.numbers.ImmutableList list3 = new ru.alikina.numbers.ImmutableList(list1);
        System.out.println(list3);

        System.out.println(list1.getValue(2));

        ru.alikina.numbers.ImmutableList list4 = list1.setValue(2, 10);
        System.out.println(list4);

        System.out.println(list1.isEmpty());
        System.out.println(list1.size());

        int[] array1 = list1.toArray();
        System.out.println(Arrays.toString(array1));

        //3
        ru.alikina.geometry.Point3D point3D = new ru.alikina.geometry.Point3D(1.0, 2.0, 3.0);
        System.out.println(point3D);

        //4
        ru.alikina.geometry.Point point1 = new ru.alikina.geometry.PointBuilder()
                .setX(3)
                .setColor("red")
                .buildPoint();
        System.out.println(point1);

        ru.alikina.geometry.Point3D point2 = new ru.alikina.geometry.PointBuilder()
                .setX(4)
                .setY(2)
                .setZ(5)
                .setTime("11:00")
                .buildPoint3D();
        System.out.println(point2);

        ru.alikina.geometry.Point point3 = new ru.alikina.geometry.PointBuilder()
                .setX(7)
                .setY(7)
                .setTime("15:35")
                .setColor("yellow")
                .buildPoint();
        System.out.println(point3);

        //5

        System.out.println("Введите писок элементов суммы в таком виде (2 3/5 2.3):");
        String input = scanner.nextLine();

        Double sum = SumCalculator.sum(input);
        System.out.println("Сумма: " + sum);

        //6
        // Создаем две линии с одинаковыми точками начала и конца
        Line line1_1 = new Line(new Point(1, 2), new Point(3, 4));
        Line line2_1 = new Line(new Point(1, 2), new Point(3, 4));

        // Создаем линию с обратными точками начала и конца
        Line line3_1 = new Line(new Point(3, 4), new Point(1, 2));

        // Создаем линию с другими точками
        Line line4_1 = new Line(new Point(5, 6), new Point(7, 8));

        // Проверяем равенство линий
        System.out.println("line1 равна line2: " + line1.equals(line2_1)); // true
        System.out.println("line1 равна line3: " + line1.equals(line3_1)); // true
        System.out.println("line1 равна line4: " + line1.equals(line4_1)); // false

        // Выводим информацию о линиях
        System.out.println(line1_1);
        System.out.println(line2_1);
        System.out.println(line3_1);
        System.out.println(line4_1);

        // Выводим длину линий
        System.out.println("длина линии line1: " + line1_1.getDistance());
        System.out.println("длина линии line2: " + line2_1.getDistance());
        System.out.println("длина линии line3: " + line3_1.getDistance());
        System.out.println("длина линии line4: " + line4_1.getDistance());

        //8
        Line originalLine = new Line(new Point(1, 2), new Point(3, 4));
        Line clonedLine = null;
        try {
            clonedLine = (Line) originalLine.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("оригинальная Line: " + originalLine);
        System.out.println("клон Line: " + clonedLine);

        // Проверка, что это действительно разные объекты
        System.out.println("Равны ли линии? " + originalLine.equals(clonedLine));
        System.out.println("Линии один и тот же обьект? " + (originalLine == clonedLine));
    }


    private static int[] readIntArray(Scanner scanner) {
        while (true) {
            System.out.println("Введите числа через пробел:");
            String input = scanner.nextLine();
            String[] inputValues = input.split(" ");
            int[] values = new int[inputValues.length];
            try {
                for (int i = 0; i < inputValues.length; i++) {
                    values[i] = Integer.parseInt(inputValues[i]);
                }
                return values;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, ведите корректные данные.");
            }
        }
    }

    // Метод для чтения одного целого числа с клавиатуры
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, ведите корректные данные.");
            }
        }
    }

    public static double inputCoordinate(Scanner scanner, String coordinateName) {
        while (true) {
            System.out.print("Введите " + coordinateName + ": ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }
}
