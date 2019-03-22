package com.stormnet;

import java.util.Scanner;

public class ArrayTask {

    public static void main(String[] args) {

        int[] array = new int[8];
        int sum = 0;
        float average;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers");

        for(int i=0; i<array.length; i++){

            array[i] = scanner.nextInt();

            sum+=array[i];

        }

        average = (float) sum/array.length;



        System.out.println(sum);
        System.out.println(average);

    }
}

