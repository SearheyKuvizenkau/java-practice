package com.stormnet;

public class CheckService {
    public static int arrObjects(int i, int [] CheckPosition) {
        if (i == (CheckPosition.length - 1))
            return CheckPosition[i];
        return CheckPosition[i] + arrObjects(i + 1,CheckPosition);
        }
    }
