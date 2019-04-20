package com.stormnet;

public final class Circle extends Shape {

    private double r;


    public Circle(double r) {

        try {
            this.r = r;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;

    }

    @Override
    protected double square() {
        return Math.PI * r * r;
    }

    @Override
    protected double perimetr() {
        return 2.0 * Math.PI * r;
    }
}


