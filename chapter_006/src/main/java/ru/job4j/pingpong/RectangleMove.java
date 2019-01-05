package ru.job4j.pingpong;


import javafx.scene.shape.Rectangle;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 05.01.2019
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private final int limitX;

    public RectangleMove(final Rectangle rect, final int limitX) {
        this.rect = rect;
        this.limitX = limitX;
    }

    @Override
    public void run() {
        int dx = 1;
        while (true) {
            if (this.rect.getX() == 0 || this.rect.getX() == this.limitX - this.rect.getWidth()) {
                dx = -dx;
            }
            this.rect.setX(this.rect.getX() + dx);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
