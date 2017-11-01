package Lecture2;

public class Lecture2LoopsTask13 {
    private static boolean contain2or13(int num) {
        while (num > 0) {
            if ((num % 10 == 4) || (num % 100 == 13))
                return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 100000; i++) {
            if (contain2or13(i)) {
                count++;
//                   System.out.println(i + " ");
            }
        }
        System.out.println(" Исключить: " + count);
    }
}
