package ru.job4j.concurrency;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 05.01.2019
 */
public class SimpleThread implements Runnable {
    private String name;

    public SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name);
        }
    }

    public static void main(String[] args) {
        new Thread(new SimpleThread("t1")).start();
        new Thread(new SimpleThread("t2")).start();
    }
}
