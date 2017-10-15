import java.util.Scanner;

public class Lecture2LoopsTask6 {
    public static void main(String[] args) {
        System.out.println("Введите число, и нажмите Enter ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Число " + num + ", делители числа : ");
        int i = 1;
        while (i < num) {
            if (num % i == 0)
                System.out.print(  i + " ");
            i++;
        }
    }
}
