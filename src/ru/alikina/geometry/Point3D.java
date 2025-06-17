package ru.alikina.geometry;

import java.util.Objects;

/**
 * Класс, представляющий точку в трехмерном пространстве.
 * Расширяет класс Point, добавляя координату z.
 * 
 * // FIXME: Оптимизация: Добавить кэширование хеш-кода, так как объекты неизменяемые
 * // FIXME: Структура: Вынести константы (например, формат вывода toString) в отдельные статические поля
 * // FIXME: Структура: Создать отдельный класс для валидации входных данных
 * // FIXME: Структура: Добавить методы для работы с трехмерными векторами (скалярное произведение, векторное произведение)
 */
public class Point3D extends Point {
    private double z;

    /**
     * Создает точку с координатами (0,0,0)
     */
    public Point3D() {
        super();
        this.z = 0;
    }

    /**
     * Создает точку, копируя координаты из другой точки
     * @param point точка для копирования
     */
    public Point3D(Point3D point) {
        super(point);
        this.z = point.z;
    }

    /**
     * Создает точку с указанными координатами
     * @param x координата x
     * @param y координата y
     * @param z координата z
     * @throws IllegalArgumentException если координаты некорректны
     */
    public Point3D(double x, double y, double z) {
        super(x, y);
        if (!isValidInput(z)) {
            throw new IllegalArgumentException("Некорректная координата z: " + z);
        }
        this.z = z;
    }

    /**
     * Проверяет корректность входных данных
     * @param value проверяемое значение
     * @return true если значение корректно, false в противном случае
     */
    private boolean isValidInput(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    /**
     * Возвращает координату z точки
     * @return координата z
     */
    public double getZ() {
        return z;
    }

    /**
     * Устанавливает координату z точки
     * @param z новая координата z
     * @throws IllegalArgumentException если координата некорректна
     */
    public void setZ(double z) {
        if (!isValidInput(z)) {
            throw new IllegalArgumentException("Некорректная координата z: " + z);
        }
        this.z = z;
    }

    /**
     * Возвращает строковое представление точки
     * @return строковое представление в формате "{x;y;z}"
     */
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}

