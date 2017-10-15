public class Lecture2BranchingTask3 {
    public static void main(String[] args) {
        int a, b, c, d;
        a = 2;
        b = -5;
        c = -10;
        if (a > b) {
            d = a;
            a = b;
            b = d;
        }
        if (a > c) {
            d = a;

            a = c;
            c = d;
        }
        if (b > c) {
            d = b;
            b = c;
            c = d;
        }
        System.out.println(a+", "+b+", "+c);
    }
}
