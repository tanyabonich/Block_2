package com.company;

/**
 * Created by Таня on 07.06.2017.
 */
public class DisIsNegException extends Exception {


    public DisIsNegException(String message, Exception e) {
        super(message, e);
    }

    public DisIsNegException(String message) {
        super(message);
    }

    public DisIsNegException(Exception e) {
        super(e);
    }
}