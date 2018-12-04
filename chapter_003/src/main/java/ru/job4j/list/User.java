package ru.job4j.list;

public class User {

    private String name;
    private String city;
    private int id;

    public User(String name, String city, int id) {
        this.city = city;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }
}
