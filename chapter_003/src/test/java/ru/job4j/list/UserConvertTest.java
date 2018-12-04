package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void processTest() {
        List<User> list = new ArrayList<>();
        User u1 = new User("Vasya", "Moscow", 15);
        User u2 = new User("Petya", "StPeter", 33);
        list.add(u1);
        list.add(u2);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(15, u1);
        expected.put(33, u2);
        assertThat(uc.process(list), is(expected));
    }
}