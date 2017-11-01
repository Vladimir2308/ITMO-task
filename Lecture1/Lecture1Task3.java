package Lecture1;

public class Lecture1Task3 {
    public static void main(String[] args) {
        double n = 4.29;
        System.out.println("До округления: n = " + n);
        n = n % 1 >= 0.5 ? (int)n  + 1 : (int)n  ;
        System.out.println("После округления n=" + n);
    }
}
