package com.stormnet;

import java.util.Scanner;

public class ArrayTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        System.out.println(a);
        
        int [] array = new int[a];
        int sum = 0;
        float average;

         Scanner scanne = new Scanner(System.in);
         System.out.println("Введите числа");

         for(int i=0; i<array.length; i++){

            array[i] = scanne.nextInt();

            System.out.println(array[i]);

        }
        
        for(int i=0; i<array.length; i++){

            sum+=array[i];
        }

        average = (float) sum/array.length;



        System.out.println(sum);
        System.out.println(average);

    }
}

