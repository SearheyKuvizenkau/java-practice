package com.stormnet;

public final class Rectangle extends Shape {

    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Rectangle(double a, double b) {

        try{
            this.a = a;
            this.b = b;
        }catch (IllegalArgumentException e) {
            throw e;
        }
    }


    @Override
    protected double square() {
        return a * b;
    }

    @Override
    protected double perimetr() {
        return 2.0 * (a + b);
    }
}

