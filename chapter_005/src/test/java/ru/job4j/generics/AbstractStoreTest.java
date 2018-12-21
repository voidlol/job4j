package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 21.12.2018
 */
public class AbstractStoreTest {

    private AbstractStore<User> us = new UserStore(10);
    private AbstractStore<Role> rs = new RoleStore(10);
    private User u1 = new User("u1");
    private User u2 = new User("u2");
    private Role r1 = new Role("r1");
    private Role r2 = new Role("r2");

    @Test
    public void add() {
        us.add(u1);
        rs.add(r1);
        assertThat(us.store.get(0), is(u1));
        assertThat(rs.store.get(0), is(r1));
    }

    @Test
    public void delete() {
        us.add(u1);
        us.add(u2);
        us.delete("u1");
        rs.add(r1);
        rs.add(r2);
        rs.delete("r1");
        assertThat(us.store.get(0), is(u2));
        assertThat(rs.store.get(0), is(r2));
    }

    @Test
    public void findById() {
        us.add(u1);
        us.add(u2);
        User rstU = us.findById("u2");
        rs.add(r1);
        rs.add(r2);
        Role rstR = rs.findById("r1");
        assertThat(rstU, is(u2));
        assertThat(rstR, is(r1));
    }

    @Test
    public void replace() {
        us.add(u1);
        rs.add(r1);
        us.replace("u1", u2);
        rs.replace("r1", r2);
        assertThat(us.store.get(0), is(u2));
        assertThat(rs.store.get(0), is(r2));
    }
}