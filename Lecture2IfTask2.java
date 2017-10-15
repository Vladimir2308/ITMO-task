public class Lecture2IfTask2 {
    public static void main(String[] args) {
        float m = 8.5f;
        float n = 11.45f;
        float p, q;
        if (m < 10)
            p = 10 - m;
        else p = m - 10;
        if (n < 10)
            q = 10 - n;
        else q = n - 10;
        if (p < q) System.out.println("m closer to 10 then n");
        else System.out.println("n closer to 10 then m");
    }
}
