package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaFunc {

    public double square(double value) {
        return value * value;
    }

    public double line(double value) {
        return value;
    }

    public double log(double value) {
        return Math.log10(value);
    }

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }

}
