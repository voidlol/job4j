package ru.job4j.calculate;

/**
 * Рассчет идеального веса
 */

public class Fit {
    /**
     * Вес для мужчины
     * @param height - рост
     * @return - вес
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Вес для женщины
     * @param height - рост
     * @return - вес
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
