package ru.job4j.concurrency;

public class ConsoleProgress implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
        progress.interrupt(); //
    }

    public void run() {
        String process = "\\|/";
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            i++;
            System.out.print("\r load: " + process.charAt(i % 3));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
