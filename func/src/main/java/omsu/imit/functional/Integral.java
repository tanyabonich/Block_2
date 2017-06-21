package omsu.imit.functional;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.Function;

/**
 * Created by Таня on 21.06.2017.
 */
public class Integral implements Functional {
    public double f(Function func, int n) throws ZeroException, OverstepException {
        double res = 0;
        double a = func.getA();
        double b = func.getB();
        double step = b/n;
        double mid;
        b = step;
        for (int i = 0; i < n; i++){
            mid = (a + b)/ 2;
            res += func.f(mid) * (b - a);
            a = b;
            b += step;
        }
        return  res;
    }
}
