package ru.alikina.numbers;

/**
 * Класс для вычисления суммы чисел из строки.
 * Поддерживает целые числа, десятичные дроби и обыкновенные дроби.
 * 
 * // FIXME: Оптимизация: Добавить кэширование результатов парсинга для часто используемых строк
 * // FIXME: Оптимизация: Использовать StringBuilder вместо конкатенации строк
 * // FIXME: Структура: Вынести регулярные выражения в отдельные константы
 * // FIXME: Структура: Создать отдельный класс для парсинга чисел разных форматов
 * // FIXME: Структура: Добавить поддержку других форматов чисел (например, римские числа)
 */
public class SumCalculator {
    /**
     * Вычисляет сумму чисел из строки.
     * Поддерживает следующие форматы:
     * - Целые числа: "123", "-456"
     * - Десятичные дроби: "123.456", "-456.789"
     * - Обыкновенные дроби: "123/456", "-456/789"
     * 
     * @param input строка с числами, разделенными пробелами
     * @return сумма всех чисел
     * @throws IllegalArgumentException если строка содержит некорректные числа
     * @throws ArithmeticException если происходит переполнение при вычислении
     */
    public static double sum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0.0;
        }

        String[] numbers = input.trim().split("\\s+");
        double result = 0.0;

        for (String number : numbers) {
            result += parseNumber(number);
        }

        return result;
    }

    /**
     * Преобразует строку в число.
     * Поддерживает те же форматы, что и метод sum.
     * 
     * @param input строка для преобразования
     * @return число
     * @throws IllegalArgumentException если строка не соответствует поддерживаемым форматам
     */
    private static double parseNumber(String input) {
        // Целое число
        if (input.matches("-?\\d+")) {
            return Long.parseLong(input);
        }

        // Десятичная дробь
        if (input.matches("-?\\d+\\.\\d+")) {
            return Double.parseDouble(input);
        }

        // Обыкновенная дробь
        if (input.matches("-?\\d+/\\d+")) {
            String[] parts = input.split("/");
            double numerator = Long.parseLong(parts[0]);
            double denominator = Long.parseLong(parts[1]);
            
            if (denominator == 0) {
                throw new IllegalArgumentException("Деление на ноль: " + input);
            }
            
            return numerator / denominator;
        }

        throw new IllegalArgumentException("Неподдерживаемый формат числа: " + input);
    }
}
