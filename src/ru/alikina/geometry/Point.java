package ru.alikina.geometry;

import java.lang.Double;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс, представляющий точку на двумерной плоскости.
 * Хранит координаты x и y точки и предоставляет методы для работы с ними.
 * 
 * // FIXME: Оптимизация: Добавить кэширование хеш-кода, так как объекты неизменяемые
 * // FIXME: Структура: Вынести константы (например, формат вывода toString) в отдельные статические поля
 */
public class Point {
    private double x;
    private double y;

    /**
     * Создает точку с координатами (0,0)
     */
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Создает точку с координатами, равными координатам переданной точки
     * @param point точка, координаты которой копируются
     */
    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    /**
     * Создает точку с заданными координатами
     * @param x координата x
     * @param y координата y
     * @throws IllegalArgumentException если координаты некорректны
     */
    public Point(double x, double y) {
        if (!isValidInput(x) || !isValidInput(y)) {
            throw new IllegalArgumentException("Некорректные координаты");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Проверяет корректность входного значения координаты
     * @param value проверяемое значение
     * @return true если значение корректно, false в противном случае
     */
    private boolean isValidInput(double value) {
        return (Double.isFinite(value));
    }

    /**
     * Возвращает координату x точки
     * @return координата x
     */
    public double getX() {
        return x;
    }

    /**
     * Устанавливает координату x точки
     * @param x новое значение координаты x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Возвращает координату y точки
     * @return координата y
     */
    public double getY() {
        return y;
    }

    /**
     * Устанавливает координату y точки
     * @param y новое значение координаты y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Возвращает строковое представление точки в формате {x;y}
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает текущую точку с указанным объектом
     * @param obj объект для сравнения
     * @return true если точки равны, false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    /**
     * Возвращает хеш-код точки
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Устанавливает цвет объекта.
     *
     * @param color строка, представляющая цвет в поддерживаемом формате
     * (например, HEX, название цвета и т.д.)
     * @throws IllegalArgumentException если переданный цвет некорректен
     *                                  или не поддерживается
     */
    public void setColor(String color) {
    }

    /**
     * Устанавливает время для объекта.
     *
     * @param time объект {@link LocalDateTime}, представляющий дату и время.
     *             Если передано null, время сбрасывается в значение по умолчанию.
     */
    public void setTime(LocalDateTime time) {
    }
}
