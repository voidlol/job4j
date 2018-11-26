package ru.job4j.loop;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Построение правого треугольника
     * @param height - высота
     * @return - треугольник
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Построение левого треугольника
     * @param height - высота
     * @return - треугольник
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= height - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Построение пирамиды
     * @param height - высота
     * @return - пирамида
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
