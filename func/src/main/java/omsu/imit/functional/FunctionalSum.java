package omsu.imit.functional;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.Function;

/**
 * Created by Таня on 21.06.2017.
 */
public class FunctionalSum implements Functional {
    public double f(Function o, int n) throws OverstepException, ZeroException {
        double sum = 0;
        sum += o.f(o.getA());
        sum += o.f(o.getB());
        double mid = (o.getA() + o.getB()) / 2;
        sum += o.f(mid);
        return sum;
    }
}
