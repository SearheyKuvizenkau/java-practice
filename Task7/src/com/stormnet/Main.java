package com.stormnet;

public class Main {

    public static void main(String[] args) {

        try {

            if (args[0].equals("-c") && args.length == 2) {

                try {
                    Shape shape = new Circle(Double.parseDouble(args[1]));
                    System.out.println("Площадь круга равна:" + " " + shape.perimetr());
                    System.out.println("Периметр круга равен:" + " " + shape.square());
                } catch (IllegalArgumentException e) {
                    System.out.print("Вы ввели несоотвествующее значение:" + " " + e);
                }
            }

            if (args[0].equals("-r") && args.length == 3) {

                try {
                    Shape shape = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    System.out.println("Площадь прямоугольника равна:" + " " + shape.perimetr());
                    System.out.println("Периметр прямоугольника равен:" + " " + shape.square());
                } catch (IllegalArgumentException e) {
                    System.out.print("Вы ввели несоотвествующее значения:" + " " + e);
                }
            }

            if (args[0].equals("-h") && args.length == 1) {

                System.out.print("Помощь: Программа должна принимать следующие аргуметны:" +
                        " -с r, где r - радиус круга;" +
                        " -r a b, где а и b стороны прямоугольника");

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Не были заданы аргументы");
        }
    }
}
