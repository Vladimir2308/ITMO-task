package lecture1;

public class Lecture1Task4 {
    public static void main(String[] args) {
        int n = 345;
        int answer = 0;
        System.out.println("Число n = " + n);
        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }
        System.out.println("Сумма цифр числа = " + answer);
    }
}
