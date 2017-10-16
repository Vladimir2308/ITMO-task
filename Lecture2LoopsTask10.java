public class Lecture2LoopsTask10 {
    private static int amountNumber(int num) {
        int answer = 0;
        while (num > 0) {
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            if (amountNumber(i / 1000) == amountNumber(i % 1000)) {
//                System.out.print(i + " ");
//                System.out.print(amountNumber(i / 1000) + " ");
//                System.out.println(amountNumber(i % 1000));
                count++;
            }
        }
        System.out.println("счастливых билетов : " + count);
    }
}
