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
        int result = 0;
        if (this.age > o.age) {
            result = 1;
        } else if (this.age < o.age) {
            result = -1;
        }
        return result;
    }
}
