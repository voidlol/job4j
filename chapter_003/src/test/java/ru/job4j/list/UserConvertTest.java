package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserConvertTest {
    @Test
    public void processTest() {
        User u1 = new User("Vasya", "Moscow", 15);
        User u2 = new User("Petya", "StPeter", 33);
        List<User> list = new ArrayList<>(List.of(u1, u2));
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> expected = new HashMap<>(Map.of(15, u1, 33, u2));
        assertThat(uc.process(list), is(expected));
    }
}