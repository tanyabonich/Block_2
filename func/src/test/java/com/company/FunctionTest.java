package com.company;

import omsu.imit.exceptions.OverstepException;
import omsu.imit.exceptions.ZeroException;
import omsu.imit.function.FunctionDiv;
import omsu.imit.function.FunctionExp;
import omsu.imit.function.FunctionSin;
import omsu.imit.function.FunctionSum;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Таня on 21.06.2017.
 */
public class FunctionTest {
    @Test
    public void testCalc1() throws OverstepException, ZeroException {
        FunctionDiv divF = new FunctionDiv(1, 2, 1, 1, 1, 1);
        double solution = divF.f(1);
        double expected = 1;
        Assert.assertEquals(solution, expected,1e-10);
    }
    @Test
    public void testCalc2() throws OverstepException, ZeroException {
        FunctionExp expF = new FunctionExp(1,1,1,0);
        double solution = expF.f(1);
        double expected = Math.exp(1);
        Assert.assertEquals(solution, expected,1e-10);
    }@Test
    public void testCalc3() throws OverstepException, ZeroException {
        FunctionSin sinF = new FunctionSin(1,1,1,1);
        double solution = sinF.f(1);
        double expected = Math.sin(1);
        Assert.assertEquals(solution, expected,1e-10);
    }
    @Test
    public void testCalc4() throws OverstepException, ZeroException {
        FunctionSum sumF = new FunctionSum(1,1,1,0);
        double solution = sumF.f(1);
        double expected = 1;
        Assert.assertEquals(solution, expected,1e-10);
    }





}