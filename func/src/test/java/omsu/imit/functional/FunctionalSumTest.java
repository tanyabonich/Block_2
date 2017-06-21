package omsu.imit.functional;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.FunctionDiv;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Таня on 21.06.2017.
 */
public class FunctionalSumTest {

    @Test
    public void testCalc1() throws OverstepException, ZeroException {
        FunctionalSum fs = new FunctionalSum();
        FunctionDiv fd = new FunctionDiv(0, 2, 1, 1, 1, 1);
        double solution = fs.f(fd,1);
        double expected = 3.0;
        Assert.assertEquals(solution, expected,1e-10);
    }

}