package com.stormnet;


import java.util.ArrayList;
import java.util.LinkedList;


public class Method {

    public static void main(String[] args) {

        compare2Lists();

    }

    public static void compare2Lists() {
        ArrayList<Integer> aList = new ArrayList<>();
        LinkedList<Integer> lList = new LinkedList<>();
        final int N = 1000000;
        final int M = 10000;
        for (int i = 0; i < N; i++) {
            aList.add((int) Math.random());
            lList.add((int) Math.random());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            aList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            lList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

