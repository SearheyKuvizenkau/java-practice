package com.stormnet;


import static com.stormnet.CheckService.arrObjects;

public class Main {
    public static void main(String[] args) {
        int[] CheckPosition = {3, 6, 13, 9, 11, 18};
        int sum;
        sum = arrObjects(0, CheckPosition);

        System.out.println(sum);

    }
}
