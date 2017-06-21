package omsu.imit.function;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;

/**
 * Created by Таня on 07.06.2017.
 */
public class FunctionDiv implements Function {
    private final double eps = 0.000001;
    private double a;
    private double b;
    private double A;
    private double B;
    private double C;
    private double D;

    public FunctionDiv(double a, double b, double A, double B, double C, double D ){
        this.a = a;
        this.b = b;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public double getA() {
        return a;
    }


    public double getB() {
        return b;
    }


    public double f(double x) throws OverstepException {
        double denominator = C * x + D;
        if (Math.abs(denominator) < eps){
            try {
                throw new ZeroException("denominator is zero");
            } catch (ZeroException e) {
                e.printStackTrace();
            }
        }
        if (x >= a && x <= b){
            return (A * x + B) / denominator;
        } else {
            throw new OverstepException("x is overstepping");
        }

    }
}

