package ru.alikina.main;

import ru.alikina.geometry.Line;
import ru.alikina.geometry.Point;
import ru.alikina.geometry.Point3D;
import ru.alikina.geometry.PointBuilder;
import ru.alikina.numbers.ImmutableList;
import ru.alikina.numbers.SumCalculator;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Главный класс приложения.
 * Демонстрирует работу с геометрическими фигурами, неизменяемыми списками и калькулятором сумм.
 * 
 * // FIXME: Оптимизация: Добавить кэширование результатов вычислений
 * // FIXME: Оптимизация: Использовать try-with-resources для Scanner
 * // FIXME: Структура: Вынести демонстрационные примеры в отдельные методы
 * // FIXME: Структура: Создать отдельный класс для работы с пользовательским вводом
 * // FIXME: Структура: Добавить обработку ошибок ввода/вывода
 */
public class Main {
    /**
     * Точка входа в приложение.
     * Демонстрирует различные примеры использования классов геометрии,
     * работы с неизменяемыми списками и вычисления сумм.
     *
     * @param args аргументы командной строки (X и Y для возведения в степень)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Демонстрация работы с точками
        System.out.println("Демонстрация работы с точками:");
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);

        // Демонстрация работы с линиями
        System.out.println("\nДемонстрация работы с линиями:");
        Line line = new Line(point1, point2);
        System.out.println("Линия: " + line);
        System.out.println("Длина линии: " + line.getDistance());

        // Демонстрация работы с трехмерными точками
        System.out.println("\nДемонстрация работы с трехмерными точками:");
        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println("Трехмерная точка: " + point3D);

        // Демонстрация работы с PointBuilder
        System.out.println("\nДемонстрация работы с PointBuilder:");
        PointBuilder builder = new PointBuilder()
                .setX(5)
                .setY(6)
                .setZ(7)
                .setColor("red")
                .setTime(LocalDateTime.now());
        Point3D builtPoint = builder.buildPoint3D();
        System.out.println("Построенная точка: " + builtPoint);

        // Демонстрация работы с ImmutableList
        System.out.println("\nДемонстрация работы с ImmutableList:");
        ImmutableList list = new ImmutableList(1, 2, 3, 4, 5);
        System.out.println("Исходный список: " + list);
        ImmutableList newList = list.setValue(2, 10);
        System.out.println("Новый список: " + newList);
        System.out.println("Исходный список не изменился: " + list);

        // Демонстрация работы с SumCalculator
        System.out.println("\nДемонстрация работы с SumCalculator:");
        String numbers = "1 2.5 3/4 -5.5";
        System.out.println("Строка с числами: " + numbers);
        System.out.println("Сумма: " + SumCalculator.sum(numbers));

        // Работа с пользовательским вводом
        System.out.println("\nВведите два числа для возведения в степень:");
        int x = readInt(scanner, "Введите основание (X): ");
        int y = readInt(scanner, "Введите показатель степени (Y): ");
        System.out.printf("%d ^ %d = %d%n", x, y, (int) Math.pow(x, y));

        scanner.close();
    }

    /**
     * Читает целое число из консоли
     * @param scanner объект Scanner для чтения
     * @param prompt приглашение для ввода
     * @return введенное целое число
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число");
            }
        }
    }
}
