package ru.job4j.chess;

public class ImposibleMoveException extends RuntimeException {

    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
