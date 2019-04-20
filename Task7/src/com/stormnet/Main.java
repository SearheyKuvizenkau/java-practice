package com.stormnet;


public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        String Str1 = "-c";
        String Str2 = args[0];

        boolean cirVal;

        cirVal = Str1.equals(Str2);


        if (cirVal == true && args.length == 2) {

            Shape shape = new Circle(Integer.parseInt(args[1]));

            if (Integer.parseInt(args[1]) <= 0) throw new IllegalArgumentException("Вы ввели отрицательные значения," +
                    " либо равные нулю");

            System.out.println(args[0] + " " + shape.perimetr());
            System.out.println(args[0] + " " + shape.square());
        }

        String Str3 = "-r";
        String Str4 = args[0];

        boolean rectVal;

        rectVal = Str3.equals(Str4);

        if (rectVal == true && args.length == 3) {

            Shape shape = new Rectangle(Integer.parseInt(args[1]), Integer.parseInt(args[2]));

            if (Integer.parseInt(args[1]) <= 0 || Integer.parseInt(args[2]) <= 0)
                throw new IllegalArgumentException("Вы ввели отрицательные значения, либо равные нулю.");

            System.out.println(args[0] + " " + shape.perimetr());
            System.out.println(args[0] + " " + shape.square());
        }

        String Str5 = "-h";
        String Str6 = args[0];

        boolean helpVal;

        helpVal = Str5.equals(Str6);

        if (helpVal == true && args.length == 1) {

            System.out.print("Помощь: Введите положительные числа для соответствующей фигуры.");

        }

    }

}


