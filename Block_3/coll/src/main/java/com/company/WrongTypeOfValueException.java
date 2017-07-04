package com.company;

/**
 * Created by Таня on 04.07.2017.
 */
public class WrongTypeOfValueException extends Exception {
    public WrongTypeOfValueException(String message, Exception e) {
        super(message, e);
    }

    public WrongTypeOfValueException(String message) {
        super(message);
    }

    public WrongTypeOfValueException(Exception e) {
        super(e);
    }
}
