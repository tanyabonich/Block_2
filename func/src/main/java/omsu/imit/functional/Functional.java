package omsu.imit.functional;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.Function;

/**
 * Created by Таня on 21.06.2017.
 */

public interface Functional  {
    double f (Function func, int n) throws ZeroException, OverstepException;
}