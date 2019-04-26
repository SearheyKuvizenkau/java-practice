package com.stormnet;

public final class Rectangle extends Shape {

    private final double a;
    private final double b;


    public Rectangle(double a, double b) {

        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Значение аргументов  a и b  должно быть строго положительное");
        }

        this.a = a;
        this.b = b;
    }

    @Override
    public double square() {
        return a * b;
    }

    @Override
    public double perimetr() {
        return 2.0 * (a + b);
    }
}

