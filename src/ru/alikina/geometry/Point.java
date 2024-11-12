package ru.alikina.geometry;

import java.lang.Double;
import java.util.Objects;

public class Point {
    private double x;
    private double y;

    // Конструктор
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public Point(double x, double y) {
        if (!isValidInput(x) || !isValidInput(y)) {
            throw new IllegalArgumentException("Некорректные координаты");
        }
        this.x = x;
        this.y = y;
    }

    private boolean isValidInput(double value) {
        return (Double.isFinite(value));
    }

    // Геттеры и сеттеры
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
}
}
