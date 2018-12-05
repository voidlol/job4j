package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void sortTest() {
        List<User> list = new ArrayList<>();
        User u1 = new User("Vasya", 15);
        User u2 = new User("Petya", 11);
        User u3 = new User("Masha", 19);
        User u4 = new User("Dasha", 17);
        list.addAll(Arrays.asList(u1, u2, u3, u4));
        SortUser su = new SortUser();
        Set<User> result = su.sort(list);
        Set<User> expected = new TreeSet<>(Arrays.asList(u2, u1, u4, u3));
        assertThat(result, is(expected));
    }

}