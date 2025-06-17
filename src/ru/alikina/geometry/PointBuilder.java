package ru.alikina.geometry;

import java.time.LocalDateTime;

/**
 * Строитель для создания объектов Point и Point3D.
 * Позволяет пошагово устанавливать параметры точки.
 * 
 * // FIXME: Оптимизация: Добавить валидацию значений при установке, а не только при создании объекта
 * // FIXME: Структура: Создать отдельный класс для работы с цветами точек
 * // FIXME: Структура: Добавить поддержку других типов точек (например, Point4D)
 * // FIXME: Структура: Добавить методы для создания точек с предустановленными значениями (например, начало координат)
 */
public class PointBuilder {
    private double x;
    private double y;
    private double z;
    private String color;
    private LocalDateTime time;

    /**
     * Устанавливает координату x
     * @param x значение координаты x
     * @return текущий объект строителя
     */
    public PointBuilder setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Устанавливает координату y
     * @param y значение координаты y
     * @return текущий объект строителя
     */
    public PointBuilder setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Устанавливает координату z
     * @param z значение координаты z
     * @return текущий объект строителя
     */
    public PointBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Устанавливает цвет точки
     * @param color цвет точки
     * @return текущий объект строителя
     */
    public PointBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Устанавливает время создания точки
     * @param time время создания
     * @return текущий объект строителя
     */
    public PointBuilder setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    /**
     * Создает объект Point с текущими параметрами
     * @return новый объект Point
     */
    public Point buildPoint() {
        Point point = new Point(x, y);
        if (color != null) {
            point.setColor(color);
        }
        if (time != null) {
            point.setTime(time);
        }
        return point;
    }

    /**
     * Создает объект Point3D с текущими параметрами
     * @return новый объект Point3D
     */
    public Point3D buildPoint3D() {
        Point3D point = new Point3D(x, y, z);
        if (color != null) {
            point.setColor(color);
        }
        if (time != null) {
            point.setTime(time);
        }
        return point;
    }
}