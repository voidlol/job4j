package ru.job4j.concurrency;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 24.01.2019
 */
public class SimpleBlockingQueueTest {

    private SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>();
    private Thread customer;
    private Thread producer;

    @Before
    public void prepare() {
        customer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    try {
                        assertThat(sbq.poll(), is(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    try {
                        sbq.offer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    @Test
    public void simpleBlockingQueueTest() throws InterruptedException {
        producer.start();
        customer.start();
        producer.join();
        customer.join();
    }

}