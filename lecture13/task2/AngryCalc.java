package lecture13.task2;

import java.util.Scanner;

public class AngryCalc {
    static int x;
    static int y;


    public static void value(String line, String value) {
        String[] splitLine = line.split(" ");
        if (splitLine[0].equals(value))
            if (splitLine[1].equals("="))
                if (splitLine.length == 3)
                    if (value.equals("x"))
                        x = Integer.parseInt(splitLine[2]);
                    else y = Integer.parseInt(splitLine[2]);
                else try {
                    throw new Exception("value is not introduced");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            else throw new RuntimeException("wrong form introducing value");
        else throw new RuntimeException("wrong order introducing value");
    }

    public static int action(String line) {
        String[] splitLine = line.split(" ");
        if (splitLine.length != 3) {
            throw new ArithmeticException("ups");
        } else {
            int val1 = 0;
            int val2 = 0;
            if (isNumber(splitLine[0]))
                val1 = Integer.parseInt(splitLine[0]);

            else if ("x".equals(splitLine[0]))
                val1 = x;
            else if ("y".equals(splitLine[0]))
                val1 = y;
            else throw new ArithmeticException("ups");
            if (isNumber(splitLine[2]))
                val2 = Integer.parseInt(splitLine[2]);

            else if ("x".equals(splitLine[2]))
                val2 = x;
            else if ("y".equals(splitLine[2]))
                val2 = y;
            else throw new ArithmeticException("ups");
            switch (splitLine[1]) {
                case "+":
                    return (val1 + val2);
                case "-":
                    return (val1 - val2);
                case "*":
                    return (val1 * val2);
                case "/":
                    return (val1 / val2);
                default:
                    throw new ArithmeticException("ups");

            }
        }
    }

    private static boolean isNumber(String str) {
        int size = str.length();

        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return size > 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        value(line, "x");
        line = scanner.nextLine();
        value(line, "y");
        while (true) {
            line = scanner.nextLine();
            System.out.println(action(line));
        }
    }
}

