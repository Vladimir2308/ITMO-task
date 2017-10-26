package Lecture2;

import java.util.Scanner;

public class Lecture2LoopsTask9 {
    public static void main(String[] args) {
        System.out.println("Введите число, и нажмите Enter ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int answer = 0;
        System.out.println("Число = " + num);
        while (num > 0) {
            answer += num % 10;
            num /= 10;
        }
        System.out.println(" Сумма цифр числа = " + answer);
    }
}
