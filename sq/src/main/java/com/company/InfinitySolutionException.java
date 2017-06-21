package com.company;

/**
 * Created by Таня on 07.06.2017.
 */
public class InfinitySolutionException  extends Exception {


    public InfinitySolutionException(String message, Exception e) {
        super(message, e);
    }

    public InfinitySolutionException(String message) {
        super(message);
    }

    public InfinitySolutionException(Throwable e) {
        super(e);
    }

}
