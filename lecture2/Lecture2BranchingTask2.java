package lecture2;

public class Lecture2BranchingTask2 {
    public static void main(String[] args) {
        int a = (int)( Math.random() * 1000);
        int max = 0;
        System.out.println("Число = " + a);
        while (a > 0) {
            if (a % 10 > max)
                max = a % 10 ;
                a /= 10;
        }
        System.out.println(" Наибольшее число " + max);
    }
}
