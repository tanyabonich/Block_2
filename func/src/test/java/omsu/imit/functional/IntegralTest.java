package omsu.imit.functional;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.FunctionSin;
import omsu.imit.function.FunctionSum;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Таня on 21.06.2017.
 */
public class IntegralTest {

    @Test
    public void testIntegralSum() throws OverstepException, ZeroException {
        Integral integ = new Integral();
        FunctionSum fSum = new FunctionSum(0,2,4,8);
        double solution = integ.f(fSum,100);
        double expected = 24.0;
        Assert.assertEquals(solution, expected,1e-10);
    }
    @Test
    public void testIntegralSin() throws OverstepException, ZeroException {
        Integral integ = new Integral();
        FunctionSin sin = new FunctionSin(0,2,9,1);
        double solution = integ.f(sin,100);
        double expected = 12.745533953428058;
        Assert.assertEquals(solution, expected,1e-10);
    }


}