package com.stormnet;

public final class Circle extends Shape {

    private final double r;

    public Circle(double r) {

        if (r <= 0) {
            throw new IllegalArgumentException("Параметры должны быть положительные");
        }

        this.r = r;
    }

    @Override
    public double square() {
        return Math.PI * r * r;
    }

    @Override
    public double perimetr() {
        return 2.0 * Math.PI * r;
    }
}

