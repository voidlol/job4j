package ru.job4j.bank;


import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getPassport().equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassport());
    }

    @Override
    public int compareTo(User o) {
        return this.getPassport().compareTo(o.getPassport());
    }
}
