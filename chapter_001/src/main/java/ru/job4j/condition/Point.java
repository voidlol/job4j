package ru.job4j.condition;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисляет расстояние между точками в системе координат
     * @param that - точка, расстояние до которой необходимо вычислить
     * @return - расстояние
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

}
