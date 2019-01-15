package ru.job4j.concurrency;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 16.01.2019
 */
public class ConcurrencyWrapperTest {

    public class ThreadList extends Thread {
        private final ConcurrencyWrapper<Integer> cw;

        public ThreadList(ConcurrencyWrapper cw) {
            this.cw = cw;
        }

        @Override
        public void run() {
            for (int i = 0; i < 25; i++) {
                cw.add((int) (Math.random() * 100));
            }
        }
    }

    @Test
    public void concurrencyAddingTest() throws InterruptedException {
        ConcurrencyWrapper<Integer> cw = new ConcurrencyWrapper<>();
        Thread t1 = new ThreadList(cw);
        Thread t2 = new ThreadList(cw);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertThat(cw.size(), is(50));
    }

    @Test
    public void concurrencyIteratorTest() throws InterruptedException {
        ConcurrencyWrapper<Integer> cw = new ConcurrencyWrapper<>();
        Thread t1 = new ThreadList(cw);
        Thread t2 = new ThreadList(cw);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Iterator<Integer> it = cw.iterator();
        for (int i = 0; i < 50; i++) {
            it.next();
        }

        assertThat(it.hasNext(), is(false));
    }

}