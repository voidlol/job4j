package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void levelOf() {
        List<Student> list = new ArrayList<>();
        Student vasya = new Student("Vasya", 41);
        Student petya = new Student("Petya", 20);
        Student masha = new Student("Masha", 50);
        list.add(vasya);
        list.add(null);
        list.add(petya);
        list.add(masha);
        assertThat(masha.levelOf(list, 40).get(0), is(vasya));
    }
}