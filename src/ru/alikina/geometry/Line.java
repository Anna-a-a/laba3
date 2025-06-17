package ru.alikina.geometry;

import java.util.Objects;

/**
 * Класс, представляющий линию на двумерной плоскости.
 * Линия определяется двумя точками: началом и концом.
 * 
 * // FIXME: Оптимизация: Добавить кэширование длины линии, так как она вычисляется часто
 * // FIXME: Оптимизация: Добавить кэширование хеш-кода, так как объекты неизменяемые
 * // FIXME: Структура: Вынести константы (например, формат вывода toString) в отдельные статические поля
 * // FIXME: Структура: Создать отдельный класс для вычисления геометрических операций (расстояние, угол и т.д.)
 */
public class Line implements Cloneable {
    private Point start;
    private Point end;

    /**
     * Создает линию по двум точкам
     * @param start начальная точка
     * @param end конечная точка
     */
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    /**
     * Создает линию по координатам начальной и конечной точек
     * @param x1 координата x начальной точки
     * @param y1 координата y начальной точки
     * @param x2 координата x конечной точки
     * @param y2 координата y конечной точки
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Возвращает копию начальной точки линии
     * @return начальная точка
     */
    public Point getStart() {
        return new Point(start);
    }

    /**
     * Устанавливает начальную точку линии
     * @param start новая начальная точка
     */
    public void setStart(Point start) {
        this.start = new Point(start);
    }

    /**
     * Возвращает копию конечной точки линии
     * @return конечная точка
     */
    public Point getEnd() {
        return new Point(end);
    }

    /**
     * Устанавливает конечную точку линии
     * @param end новая конечная точка
     */
    public void setEnd(Point end) {
        this.end = new Point(end);
    }

    /**
     * Возвращает строковое представление линии
     * @return строковое представление в формате "Линия от {x1;y1} до {x2;y2}"
     */
    @Override
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }

    /**
     * Вычисляет длину линии
     * @return длина линии в целых числах (округленная)
     */
    public int getDistance() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }

    /**
     * Сравнивает текущую линию с указанным объектом
     * @param obj объект для сравнения
     * @return true если линии равны (с учетом направления), false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return (start.equals(line.start) && end.equals(line.end)) ||
                (start.equals(line.end) && end.equals(line.start));
    }

    /**
     * Возвращает хеш-код линии
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    /**
     * Создает копию текущей линии
     * @return копия линии
     * @throws CloneNotSupportedException если клонирование не поддерживается
     */
    @Override
    public Line clone() throws CloneNotSupportedException {
        Line clonedLine = (Line) super.clone();
        clonedLine.start = new Point(this.start);
        clonedLine.end = new Point(this.end);
        return clonedLine;
    }
}

