package omsu.imit.function;

import omsu.imit.exceptions.OverstepException;

/**
 * Created by Таня on 07.06.2017.
 */
public class FunctionSin implements Function {

    private double a;
    private double b;
    private double A;
    private double B;

    public FunctionSin(double a, double b, double A, double B ){
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
            return A * Math.sin(B * x);
        } else {
            throw new OverstepException("x is overstepping");
        }

    }
}
