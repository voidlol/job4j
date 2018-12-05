package ru.job4j.set;

public class User implements Comparable<User>{

    private int age;
    private String name;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
