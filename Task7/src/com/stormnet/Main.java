package com.stormnet;


public class Main {

    public static void main(String[] args) {

        try {

            if (args[0].equals("-c") && args.length == 2) {

                try {
                    Shape shape = new Circle(Double.parseDouble(args[1]));
                    System.out.println(args[0] + " " + shape.perimetr());
                    System.out.println(args[0] + " " + shape.square());
                } catch (IllegalArgumentException e) {
                    System.out.print("Вы ввели отрицательное значение, либо равное нулю:" + " " + e);
                }
            }

            if (args[0].equals("-r") && args.length == 3) {

                try {
                    Shape shape = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    System.out.println(args[0] + " " + shape.perimetr());
                    System.out.println(args[0] + " " + shape.square());
                } catch (IllegalArgumentException e) {
                    System.out.print("Вы ввели отрицательные значения, либо равные нулю:" + " " + e);
                }
            }
            
            if (args[0].equals("-h") && args.length == 1) {

                System.out.print("Помощь: Программа должна принимать следующие аргуметны:" +
                        " -с r, где r - радиус круга;" +
                        " -r a b, где а и b стороны прямоугольника");

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Не были заданы аргументы" + e);
        }
    }
}

