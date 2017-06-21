package omsu.imit.function;

import omsu.imit.exceptions.OverstepException;

/**
 * Created by Таня on 07.06.2017.
 */
public class FunctionExp implements Function {
    private double a;
    private double b;
    private double A;
    private double B;

    public FunctionExp(double a, double b, double A, double B ){
        this.a = a;
        this.b = b;
        this.A = A;
        this.B = B;
    }

    public double getA() {
        return a;
    }


    public double getB() {
        return b;
    }


    public double f(double x) throws OverstepException {
        if (x >= a && x <= b){
            return A * Math.exp(x) + B;
        } else {
            throw new OverstepException("x is overstepping");
        }

    }
}