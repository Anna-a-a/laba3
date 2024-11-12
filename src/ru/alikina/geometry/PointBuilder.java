package ru.alikina.geometry;

public class PointBuilder {
    private double x = 0.0;
    private double y = 0.0;
    private double z = 0.0;
    private String color = "";
    private String time = "";

    public PointBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public PointBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public PointBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    public PointBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PointBuilder setTime(String time) {
        this.time = time;
        return this;
    }

    public Point buildPoint() {
        return new Point(x, y);
    }

    public Point3D buildPoint3D() {
        return new Point3D(x, y, z);
    }

}