package omsu.imit.function;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;

public interface Function {
    double getA();
    double getB();
    double f(double x) throws  ZeroException, OverstepException;
}
