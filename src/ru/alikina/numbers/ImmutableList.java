package ru.alikina.numbers;

import java.util.Arrays;

public class ImmutableList {
    private final int[] values;

    // Конструктор с указанием значений в виде массива целых чисел или перечня чисел как независимых значений
    public ImmutableList(int... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    // Конструктор с указанием другого Списка
    public ImmutableList(ImmutableList other) {
        this.values = Arrays.copyOf(other.values, other.values.length);
    }

    // Получение значения из позиции N
    public int getValue(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return values[index];
    }

    // Замена значения в позиции N на новое значение
    public ImmutableList setValue(int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = newValue;
        return new ImmutableList(newValues);
    }

    // Приведение к строке
    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    // Проверка, пуст ли список
    public boolean isEmpty() {
        return values.length == 0;
    }

    // Получение текущего размера
    public int size() {
        return values.length;
    }

    // Получение всех хранящихся значений в виде стандартного массива
    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }


}
