package com.stormnet;

public class CheckService {

    public double getCheckPrice(CheckPosition[] checkPositions) {
        return calculateSum(0, checkPositions);
    }


    private double calculateSum(int index, CheckPosition[] checkPositions) {

        if (index == checkPositions.length - 1) {

            return checkPositions[index].getCount() * checkPositions[index].getPrice();
        } else {
            return checkPositions[index].getCount() * checkPositions[index].getPrice() +
                    calculateSum(index + 1, checkPositions);
        }

    }
}
