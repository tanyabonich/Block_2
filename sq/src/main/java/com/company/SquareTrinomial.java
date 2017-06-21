package com.company;

import java.util.ArrayList;

public class SquareTrinomial {

    private double a;
    private double b;
    private double c;
    private final double EPS=0.00001;

    public SquareTrinomial() {  }

    public SquareTrinomial(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {return c; }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double [] solveST()  throws IsNotEqException,InfinitySolutionException,DisIsNegException{
        if ((Math.abs(a - 0) < EPS) && (Math.abs(b - 0) < EPS)) {
            if (Math.abs(c - 0) >= EPS) {
                throw new IsNotEqException("is not equation");
            } else {
                throw new InfinitySolutionException("infinity solution");
            }
        }


        ArrayList<Double> result=new ArrayList<Double>();

        if (Math.abs(a - 0) < EPS) {
            if (Math.abs(b - 0) >= EPS) {
                double x = -c / b;
                result.add(x);
            } else {
                double x =0 ;
                result.add(x);
            }

        }
        else {
            double discr=b*b-(4*a*c);
            if(discr<0){
                throw new DisIsNegException("discrim < 0");
            }
            if (Math.abs(discr-0)<EPS){
                double x=(-b)/(2*a);
                result.add(x);
            }
            else{
                double x1=(-b - Math.sqrt(discr))/(2*a);
                double x2=(-b + Math.sqrt(discr))/(2*a);
                result.add(x1);
                result.add(x2);
            }



        }
        int i=0;
        double[] solve=new double[result.size()];
        for (Double elem:result){
            solve[i++]=elem;
        }
        return solve;
    }

}
