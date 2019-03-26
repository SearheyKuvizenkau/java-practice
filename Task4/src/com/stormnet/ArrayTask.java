package com.stormnet;

public class ArrayTask {
    public static void main(String[] args) {
        int[] array = {1, -3, 5, -7, 4, -6};
        int quanity = 0;


        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) quanity++;
        }

        System.out.print("Количество отрицательных элементов:" + quanity);
    }
}

