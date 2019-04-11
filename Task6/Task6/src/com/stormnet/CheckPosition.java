package com.stormnet;

public class CheckPosition {

    private String name;
    private double price;
    private double count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public CheckPosition(String name, double price, double count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void setCount(double count) {
        this.count = count;
    }

}

