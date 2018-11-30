package ru.job4j.pseudo;

public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder result = new StringBuilder();
        result.append("####");
        result.append("####");
        result.append("####");
        result.append("####");
        return result.toString();
    }
}
