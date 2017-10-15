import java.util.Scanner;

public class Lecture2LoopsTask5 {
    public static void main(String[] args) {
        System.out.println("Введите число, и нажмите Enter ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long count = 1;
        for (int i = 1; i < num + 1; i++) {
            count *= i;
        }
        System.out.println(" Факториал числа " + num + " = " + count);
    }
}
