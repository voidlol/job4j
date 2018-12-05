package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    private final List<User> list = new ArrayList<>();
    private final User u1 = new User("Alexander", 15);
    private final User u2 = new User("Andrey", 11);
    private final User u3 = new User("Viktor", 19);
    private final User u4 = new User("Diana", 17);
    private final SortUser su = new SortUser();

    @Test
    public void sortTest() {
        list.addAll(Arrays.asList(u1, u2, u3, u4));
        Set<User> result = su.sort(list);
        Set<User> expected = new TreeSet<>(Arrays.asList(u2, u1, u4, u3));
        assertThat(result, is(expected));
    }

    @Test
    public void sortByNameTest() {
        list.addAll(Arrays.asList(u1, u2, u3, u4));
        List<User> result = su.sortByNameLength(list);
        List<User> expected = new ArrayList<>(Arrays.asList(u4, u2, u3, u1));
        assertThat(result, is(expected));
    }

    @Test
    public void sortByAllFieldTest() {
        list.addAll(Arrays.asList(u1, u2, u3, u4));
        List<User> result = su.sortByAllFields(list);
        List<User> expected = new ArrayList<>(Arrays.asList(u1, u2, u4, u3));
        assertThat(result, is(expected));
    }

}