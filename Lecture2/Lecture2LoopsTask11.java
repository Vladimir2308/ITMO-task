package Lecture2;

public class Lecture2LoopsTask11 {
    private static boolean contain2(int num) {
        while (num > 0) {
            if (num % 10 == 2)
                return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 50001; i++) {
            if (contain2(i)) {
//                System.out.println(i + " ");
                count++;
            }
        }
        System.out.println("Бракованных табличек : " + count);
    }
}
