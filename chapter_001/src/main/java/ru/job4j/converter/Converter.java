package ru.job4j.converter;

/**
 * Конвертер валюты
 */
public class Converter {
    /**
     * Рубли в евро
     * @param value - рубли
     * @return - евро
     */
    public int rubToEuro(int value) {
        return value / 76;
    }

    /**
     * Рубли в доллары
     * @param value - рубли
     * @return - доллары
     */
    public int rubToUsd(int value) {
        return value / 68;
    }

    /**
     * Евро в рубли
     * @param value - евро
     * @return - рубли
     */
    public int euroToRub(int value) {
        return value * 76;
    }

    /**
     * Доллары в рубли
     * @param value - доллары
     * @return - рубли
     */
    public int usdToRub(int value) {
        return value * 68;
    }
}
