package lecture2;

public class Lecture2LoopsTask12 {
    private static int reflectNum(int num) {
        int x = num % 10;
        int y = num / 10;
        return x * 10 + y;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int y = 0; y < 60; y++) {
                if (i == reflectNum(y)) {
//                    System.out.println(i + " " + y);
                    count++;
                }
            }
        }
        System.out.println("Часы показывают симметричную комбинацию" + count + " раз");
    }
}
