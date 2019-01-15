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
    private final int limitY;

    public RectangleMove(final Rectangle rect, final int limitX, final int limitY) {
        this.rect = rect;
        this.limitX = limitX - (int) rect.getWidth();
        this.limitY = limitY - (int) rect.getHeight();
    }

    @Override
    public void run() {
        int dx = 1;
        int dy = 1;
        while (!Thread.currentThread().isInterrupted()) {
            if (this.rect.getX() <= 0 || this.rect.getX() >= this.limitX) {
                dx = -dx;
            }
            if (this.rect.getY() <= 0 || this.rect.getY() >= this.limitY) {
                dy = -dy;
            }
            this.rect.setX(this.rect.getX() + dx);
            this.rect.setY(this.rect.getY() + dy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
