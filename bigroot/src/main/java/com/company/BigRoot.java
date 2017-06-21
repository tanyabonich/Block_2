package com.company;

public class BigRoot{
    private SquareTrinomial eq;

    public BigRoot(double a, double b, double c) {
        eq = new SquareTrinomial(a, b, c);
    }

    public double getMaxRoot() throws IsNotEqException, DisIsNegException, InfinitySolutionException {


        double[] roots = eq.solveST();
        double maxRoot = roots[0];

        if (roots.length<2){
            return maxRoot;
        }


        if (maxRoot < roots[1]) {
            maxRoot = roots[1];
        }

        else{
            maxRoot = roots[2];
        }


        return maxRoot;
    }
}
