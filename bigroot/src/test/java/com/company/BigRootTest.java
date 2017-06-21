package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Таня on 07.06.2017.
 */
public class BigRootTest {
    @Test
    public void testSolvingSquareEquation1() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        BigRoot maxRoot = new BigRoot(1, 2, 1);
        double solution = maxRoot.getMaxRoot();
        double expected = -1.0;
        Assert.assertEquals(solution, expected,1e-10);
    }

    @Test
    public void testSolvingSquareEquation2() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        BigRoot maxRoot = new BigRoot(1, 2*Math.sqrt(2), 2);
        double solution = maxRoot.getMaxRoot();
        double expected = -Math.sqrt(2);
        Assert.assertEquals(solution, expected,1e-10);
    }

    @Test
    public void testSolvingSquareEquation3() throws IsNotEqException, InfinitySolutionException,DisIsNegException {
        BigRoot maxRoot = new BigRoot(1, -2, -3);
        double solution = maxRoot.getMaxRoot();
        double expected = 3;
        Assert.assertEquals(solution, expected,1e-10);
    }

    @Test(expected = DisIsNegException.class)
    public void testSolvingEquationNegativeDiscriminant() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        BigRoot maxRoot = new BigRoot(1, 0,1);
        double solution = maxRoot.getMaxRoot();
        fail();
    }

    @Test(expected = IsNotEqException.class)
    public void testSolvingEquationIsNotEquation() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        BigRoot maxRoot = new BigRoot(0,0,1);
        double solution = maxRoot.getMaxRoot();
        fail();
    }

    @Test(expected = InfinitySolutionException.class)
    public void testSolvingEquationInfinityCountOfSolutions() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        BigRoot maxRoot = new BigRoot(0,0,0);
        double solution = maxRoot.getMaxRoot();
        fail();
    }
}