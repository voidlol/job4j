package ru.job4j.calculate;

/**
 * Calculator
 * @author Andrey Savelov (udroguedozed@gmail.com)
 */

public class Calculator {

    private double result;

    /**
     * Add method
     * @param first - first number
     * @param second - second number
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract method
     * @param first - first number
     * @param second - second number
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Multiply method
     * @param first - first number
     * @param second - second number
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Division method
     * @param first - dividend
     * @param second - divider
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Get Result method
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
