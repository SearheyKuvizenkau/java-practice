package com.stormnet;

public class Main {
    
    public static void main(String[] args) {

        CheckPosition[] checkPositions = new CheckPosition[2];

        CheckPosition check1 = new CheckPosition("Beer", 1.0, 2.8);
        CheckPosition check2 = new CheckPosition("Cheeps", 1.0, 1.8);


        checkPositions[0] = check1;
        checkPositions[1] = check2;

        CheckService checkservice = new CheckService();

        System.out.print(checkservice.getCheckPrice(checkPositions));
    }
}
