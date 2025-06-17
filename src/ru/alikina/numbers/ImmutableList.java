package ru.alikina.numbers;

import java.util.Arrays;

/**
 * Класс, представляющий неизменяемый список целых чисел.
 * При любой модификации создается новый объект списка.
 * 
 * // FIXME: Оптимизация: Добавить кэширование хеш-кода, так как объекты неизменяемые
 * // FIXME: Оптимизация: Использовать System.arraycopy вместо ручного копирования массива
 * // FIXME: Структура: Добавить методы для работы с подсписками (slice)
 * // FIXME: Структура: Добавить методы для функциональных операций (map, filter, reduce)
 * // FIXME: Структура: Реализовать интерфейс Iterable для поддержки for-each
 */
public class ImmutableList {
    /** Массив значений списка */
    private final int[] values;

    /**
     * Создает список с указанными значениями
     * @param values массив значений
     */
    public ImmutableList(int... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    /**
     * Создает список, копируя значения из другого списка
     * @param list список для копирования
     */
    public ImmutableList(ImmutableList list) {
        this.values = Arrays.copyOf(list.values, list.values.length);
    }

    /**
     * Возвращает значение по индексу
     * @param index индекс элемента
     * @return значение элемента
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     */
    public int getValue(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы списка");
        }
        return values[index];
    }

    /**
     * Создает новый список с измененным значением по индексу
     * @param index индекс элемента
     * @param value новое значение
     * @return новый список с измененным значением
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     */
    public ImmutableList setValue(int index, int value) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы списка");
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = value;
        return new ImmutableList(newValues);
    }

    /**
     * Возвращает строковое представление списка
     * @return строковое представление в формате "[v1, v2, ..., vn]"
     */
    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    /**
     * Проверяет, пуст ли список
     * @return true если список пуст, false в противном случае
     */
    public boolean isEmpty() {
        return values.length == 0;
    }

    /**
     * Возвращает размер списка
     * @return количество элементов в списке
     */
    public int size() {
        return values.length;
    }

    /**
     * Возвращает копию массива значений
     * @return копия массива значений
     */
    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }
}
