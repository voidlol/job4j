package ru.job4j.maps;

import org.junit.Test;

import java.util.GregorianCalendar;


import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 25.12.2018
 */
public class UserTest {

    private User u1 = new User("Vasya", 2, new GregorianCalendar(1980, 11, 25));
    private User u2 = new User("Vasya", 2, new GregorianCalendar(1980, 11, 25));

    @Test
    public void mapTest() {

    }

}