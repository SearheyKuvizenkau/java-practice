package com.stormnet;

public class ArrayDouble {
    public static void main(String[] args) {
        int[][] array = {{3, 6, 9},
                         {5, 11, 12},
                         {13, 22, 15}};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i ==j ){
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println();
        System.out.println("-------------------------------");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i+j==array.length-1){
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}



