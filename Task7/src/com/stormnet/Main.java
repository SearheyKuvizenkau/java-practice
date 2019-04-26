package com.stormnet;

public class Main {

    public static void main(String[] args) {

        Shape shape = null;

        try {

            if (args[0].equals("-c") && args.length == 2) {

                try {

                    shape = new Circle(Double.parseDouble(args[1]));
                } catch (NumberFormatException e) {
                    System.out.print("Вы ввели букву или другой символ не являющийся числом");
                } catch (IllegalArgumentException e) {
                    System.out.print("Circle:" + e.getMessage());
                }

            } else if (args[0].equals("-r") && args.length == 3) {

                try {

                    shape = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));

                } catch (NumberFormatException e) {
                    System.out.print("Вы ввели букву или другой символ не являющийся числом");
                } catch (IllegalArgumentException e) {
                    System.out.print("Rectangle:" + e.getMessage());

                }

            } else if (args[0].equals("-h") && args.length == 1) {

                System.out.print("Помощь: Программа должна принимать следующие аргуметны:" +
                        " -с r, где r - радиус круга;" +
                        " -r a b, где а и b стороны прямоугольника");

            } else {

                System.out.print("Вы ввели количество аргументов не соответствующее длине массива," +
                        " либо ваш вывод не соответствует правилам ввода");

            }

            if (shape != null) {

                System.out.println(shape.square());
                System.out.println(shape.perimetr());

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Не были заданы аргументы");

        }
    }
}
