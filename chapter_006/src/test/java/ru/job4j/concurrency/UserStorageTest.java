package ru.job4j.concurrency;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 16.01.2019
 */
public class UserStorageTest {

    UserStorage us = new UserStorage();

    private class ThreadStorage extends Thread {
        private final UserStorage us;

        private ThreadStorage(final UserStorage us) {
            this.us = us;
        }

        @Override
        public void run() {
            this.us.add(new User((int) (Math.random() * 100), (int) (Math.random() * 100)));
        }
    }

    @Test
    public void add() {
        User u1 = new User(5, 200);
        assertThat(us.add(u1), is(true));
    }

    @Test
    public void update() {
        User u1 = new User(5, 250);
        User u2 = new User(5, 700);
        us.add(u1);
        assertThat(us.update(u2), is(true));
    }

    @Test
    public void remove() {
        User u1 = new User(5, 250);
        us.add(u1);
        assertThat(us.remove(u1), is(true));
    }

    @Test
    public void transfer() {
        User u1 = new User(1, 250);
        User u2 = new User(2, 700);
        us.add(u1);
        us.add(u2);
        assertThat(us.transfer(2, 1, 400), is(true));
    }

    @Test
    public void concurrencyTest() throws InterruptedException {
        Thread t1 = new ThreadStorage(us);
        Thread t2 = new ThreadStorage(us);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertThat(us.getSize(), is(2));
    }
}