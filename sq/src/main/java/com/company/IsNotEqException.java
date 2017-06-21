package com.company;

/**
 * Created by Таня on 07.06.2017.
 */
public class IsNotEqException  extends Exception {


    public IsNotEqException(String message, Exception e) {
        super(message, e);
    }

    public IsNotEqException(String message) {
        super(message);
    }

    public IsNotEqException(Throwable e) {
        super(e);
    }

}
