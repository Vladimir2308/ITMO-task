package lecture2;

public class Lecture2BranchingTask1 {
    public static void main(String[] args) {
        int a = 5 + (int) (Math.random() * 155);
        if (a > 25 && a < 100)
            System.out.println("Число " + a + " содержится в интервале (25,100)");
else System.out.println("Число " + a + " не содержится в интервале (25,100)");
    }
}
