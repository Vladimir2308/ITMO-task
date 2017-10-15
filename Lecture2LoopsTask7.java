import java.util.Scanner;

public class Lecture2LoopsTask7 {
    public static void main(String[] args) {
        System.out.println("Введите число, и нажмите Enter ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean simple = true;
        System.out.print("Число " + num + " - ");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                simple = false;
                break;
            }
        }
        if (simple) System.out.print("простое");
        else System.out.print("не простое");
    }
}

