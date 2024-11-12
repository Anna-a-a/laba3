package ru.alikina.geometry;

import java.util.Objects;
public class Line implements Cloneable{
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // Геттеры и сеттеры
    public Point getStart() {
        return new Point(start);
    }

    public void setStart(Point start) {
        this.start = new Point(start);
    }

    public Point getEnd() {
        return new Point(end);
    }

    public void setEnd(Point end) {
        this.end = new Point(end);
    }

    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }

    public int getDistance() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return (start.equals(line.start) && end.equals(line.end)) ||
                (start.equals(line.end) && end.equals(line.start));
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line clonedLine = (Line) super.clone();
        clonedLine.start = new Point(this.start);
        clonedLine.end = new Point(this.end);
        return clonedLine;
    }


}

