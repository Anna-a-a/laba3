package ru.alikina.geometry;

public class Point3D extends Point {
    private double z;

    // Конструктор по умолчанию
    public Point3D() {
        super();
        this.z = 0.0;
    }

    // Конструктор копирования
    public Point3D(Point3D point) {
        super(point.getX(), point.getY());
        this.z = point.z;
    }

    // Конструктор с параметрами
    public Point3D(double x, double y, double z) {
        super(x, y);
        if (!isValidInput(z)) {
            throw new IllegalArgumentException("Некорректные координаты");
        }
        this.z = z;
    }

    private boolean isValidInput(double value) {
        return (Double.isFinite(value));
    }

    // Геттеры и сеттеры
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }


}

