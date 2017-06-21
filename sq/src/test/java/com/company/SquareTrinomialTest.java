package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Таня on 07.06.2017.
 */
public class SquareTrinomialTest {

    @Test
    public void testSolveST1() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(1, 2, 1);
        double[] act = squareTrinomial.solveST();
        double[] exp = {-1.0};
        assertArrayEquals(exp, act,0.00001);
    }

    @Test
    public void testSolveST2() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(1, -6, 9);
        double[] act = squareTrinomial.solveST();
        double[] exp = {3};
        assertArrayEquals(exp, act,0.00001);
    }

    @Test
    public void testSolveST3() throws IsNotEqException, InfinitySolutionException,DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(1, 1, 0);
        double[] act = squareTrinomial.solveST();
        double[] exp = {-1, 0};
        assertArrayEquals(exp, act,0.00001);
    }

    @Test(expected = DisIsNegException.class)
    public void testSolvingEquationNegativeDiscriminant() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(1, 0, 1);
        double[] act = squareTrinomial.solveST();
        fail();
    }

    @Test(expected = IsNotEqException.class)
    public void testSolvingEquationIsNotEquation() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(0, 0, 1);
        double[] act = squareTrinomial.solveST();
        fail();
    }

    @Test(expected = InfinitySolutionException.class)
    public void testSolvingEquationInfinityCountOfSolutions() throws IsNotEqException, InfinitySolutionException, DisIsNegException {
        SquareTrinomial squareTrinomial = new SquareTrinomial(0, 0, 0);
        double[] act = squareTrinomial.solveST();
        fail();
    }

}