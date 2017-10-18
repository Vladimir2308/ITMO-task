import java.util.Arrays;
import java.util.Scanner;

public class Lecture3AllTask {
    private static void arraysTask1() {
        System.out.println("arraysTask 1");
        int[] array = new int[10];
        int x = 2;
        for (int i = 0; x < 21; i++) {
            array[i] = x;
            x = x + 2;
        }
        for (int k : array) {
            System.out.print(k + " ");
        }
        for (int k : array) {
            System.out.println(k);
        }
    }

    private static void arraysTask2() {
        System.out.println("arraysTask 2");
        int[] array = new int[50];
        int x = 1;
        for (int i = 0; x < 100; i++) {
            array[i] = x;
            x = x + 2;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 49; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void arraysTask3() {
        System.out.println("arraysTask 3");
        int[] array = new int[15];
        int count = 0;
        for (int i = 0; i < 15; i++) {
            array[i] = (int) (Math.random() * 10);
            if (array[i] % 2 == 0) count += 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(" Количество чётных элементов: " + count);
    }

    private static void arraysTask4() {
        System.out.println("arraysTask 4");
        int[] array = new int[8];
        for (int i = 0; i < 8; i++) {
            array[i] = (1 + (int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < 8; i++) {
            if ((array[i] + 1) % 2 == 0) array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void arraysTask5() {
        System.out.println("arraysTask 5");
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        float average1 = 0;
        float average2 = 0;
        for (int i = 0; i < 5; i++) {
            array1[i] = (int) (Math.random() * 6);
            array2[i] = (int) (Math.random() * 6);
            average1 += array1[i];
            average2 += array2[i];
        }
        average1 = average1 / array1.length;
        average2 = average2 / array2.length;
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("average1 = " + average1);
        System.out.println("average2 = " + average2);
        if (average1 > average2) System.out.println(" average array1 bigger then average array2 ");
        else if (average1 < average2) System.out.println(" average array2 bigger then average array1 ");
        else System.out.println(" average array1 equal average array2 ");

    }

    private static void arraysTask6() {
        System.out.println("arraysTask 6");
        int[] array = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = (10 + (int) (Math.random() * 90));
        }
        System.out.println("Array: " + Arrays.toString(array));
        boolean increase = true;
        for (int i = 0; i < 3; i++) {
            if (array[i] > array[i + 1])
                increase = false;
        }
        if (increase) System.out.println("последоваетльность возрастающая ");
        else System.out.println("Последовательность не возрастающая ");

    }

    private static void arraysTask7() {
        System.out.println("arraysTask 7");
        int[] array = new int[20];
        int x = 0;
        int y = 1;
        for (int i = 0; i < 20; i++) {

            array[i] = y;
            int temp = x;
            x = y;
            y = y + temp;

        }
        System.out.println(Arrays.toString(array));
    }

    private static void arraysTask8() {
        System.out.println("arraysTask 8");
        int[] array = new int[12];

        for (int i = 0; i < 12; i++) {
            array[i] = (-15 + (int) (Math.random() * 31));
        }
        int max = array[0];
        int index = 0;
        for (int i = 0; i < 12; i++) {
            if (array[i] >= max) {
                max = array[i];
                index = i;
            }
        }
        System.out.println(Arrays.toString(array) + " максимальный элемент " + max + " array[" + index + "]");
    }

    private static void arraysTask9() {
        System.out.println("arraysTask 9");
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        float[] array3 = new float[10];
        int num = 0;
        for (int i = 0; i < 10; i++) {
            array1[i] = (1 + (int) (Math.random() * 9));
            array2[i] = (1 + (int) (Math.random() * 9));
            array3[i] = (float) array1[i] / array2[i];
            if (array3[i] % 1 == 0)
                num += 1;
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println("Количество целых элементов в array3= " + num);
    }

    private static void arraysTask10() {
        System.out.println("arraysTask 10");
        int[] array = new int[11];
        for (int i = 0; i < 11; i++) {
            array[i] = (-1 + (int) (Math.random() * 3));
        }
        System.out.println(Arrays.toString(array));
        int[] count = new int[11];
        Arrays.fill(count, 1);
        for (int i = 0; i < 10; i++) {
            for (int y = i + 1; y < 10; y++) {
                if (array[i] == array[y])
                    count[i] += 1;
            }

        }
        System.out.println(Arrays.toString(count));
        int maxCount = count[0];
        int max = array[0];
        for (int i = 0; i < 10; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                max = array[i];
            }
        }
        boolean equalCount = false;
        for (int i = 0; i < 10; i++) {
            if (count[i] == maxCount && array[i] != max) equalCount = true;
        }
        if (!equalCount)
            System.out.println("Чаще всего в массиве встречается " + max + " , встречается раз: " + maxCount);


    }

    private static void arraysTask11() {
        System.out.println("arraysTask 11");
        Scanner scanner = new Scanner(System.in);
        boolean right = false;
        int count = 0;
        while (!right) {
            System.out.println(" Введите положительное чётное число, и нажмиет Enter");
            count = scanner.nextInt();
            if (count % 2 == 0 && count > 0)
                right = true;
        }
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = (-5 + (int) (Math.random() * 11));
        }
        System.out.println(Arrays.toString(array));
        int amountLeft = 0;
        int amountRight = 0;
        for (int i = 0; i < count / 2; i++) {
            amountLeft += Math.abs(array[i]);
        }
        for (int i = count - 1; i >= count / 2; i--) {
            amountRight += Math.abs(array[i]);
        }
        if (amountLeft > amountRight)
            System.out.println("Сумма модулей левой половины массива больше суммы модулей правой половины");
        else if (amountLeft < amountRight)
            System.out.println("Сумма модулей правой половины массива больше суммы модулей левой половины");
        else System.out.println("Сумма модулей правой половины массива равна сумме модулей левой половины");
    }

    private static void arraysTask12() {
        System.out.println("arraysTask 12");
        int[] array = new int[12];
        boolean right = false;
        while (!right) {
            right = true;
            int positive = 0;
            int negative = 0;
            for (int i = 0; i < 12; i++) {
                array[i] = (-10 + (int) (Math.random() * 21));
                if (array[i] > 0) positive++;
                else if (array[i] < 0) negative++;
                else right = false;
                if (positive > 6 || negative > 6) right = false;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void arraysTask13() {
        System.out.println("arraysTask 13");
        Scanner scanner = new Scanner(System.in);
        boolean right = false;
        String str;

        double number = 0;
        int count;
        while (!right) {
            System.out.println(" Введите натуральное число больше 3, и нажмите Enter");
            str = scanner.next();
            if (str.contains(",")) {
                str = str.replace(",", ".");
            }
            number = Double.parseDouble(str);

            if (number % 1 == 0 && number > 3)
                right = true;
        }
        count = (int) number;
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = (int) (Math.random() * (count + 1));
        }
        System.out.println(Arrays.toString(array));


        int countEven = 0;
        for (int i :
                array) {
            if (i % 2 == 0) countEven++;
        }
        int[] array2 = new int[countEven];
        int y = 0;
        for (int i :
                array) {
            if (i % 2 == 0) array2[y++] = i;
        }
        System.out.println(Arrays.toString(array2));
    }

    private static void multiArraysTask1() {
        System.out.println("multiArraysTask1");
        int[][] array = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (10 + (int) (Math.random() * 90));

            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");

            }
            System.out.println();
        }

    }

    private static void multiArraysTask2() {
        System.out.println("multiArraysTask2");
        int[][] array = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (-99 + (int) (Math.random() * 199));

            }
        }
        int max = array[0][0];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + " ");
                if (array[i][j] > max) max = array[i][j];

            }
            System.out.println();
        }
        System.out.println("max= " + max);
    }

    private static void multiArraysTask3() {
        System.out.println("multiArraysTask3");
        int[][] array = new int[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = (-5 + (int) (Math.random() * 11));
            }
        }
        int indexMaxMulti = 0;
        int maxMulti = 1;

        for (int j = 0; j < 4; j++) {
            maxMulti *= array[0][j];
        }
        for (int i = 0; i < 7; i++) {
            int tempMulti = 1;
            for (int j = 0; j < 4; j++) {
                tempMulti *= array[i][j];
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
            if (Math.abs(tempMulti) > Math.abs(maxMulti)) {
                maxMulti = tempMulti;
                indexMaxMulti = i;

            }
        }
        System.out.println("Index: " + indexMaxMulti);
    }

    private static void multiArraysTask4() {
        System.out.println("multiArraysTask4");
        int[][] array = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = (+(int) (Math.random() * 10));
            }
        }

        for (int i = 0; i < 6; i++) {
            int temp;
            for (int j = 0; j < 7; j++) {
                System.out.print(array[i][j] + " ");
                if (array[i][j] > array[i][0]) {
                    temp = array[i][0];
                    array[i][0] = array[i][j];
                    array[i][j] = temp;
                }
            }
            System.out.println();
        }
        System.out.println(" После преобразовавниея: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void multiArraysTask5() {
        System.out.println("multiArraysTask5");
        boolean[][] array = new boolean[10][10];
        boolean right = false;
        for (int i = 2; i < 10; i++) {
            Arrays.fill(array[i], false);
        }
        int i, j, num;
        num = 1;

        while (!right) {

            i = (2 + (int) (Math.random() * 8));
            j = (2 + (int) (Math.random() * 8));
            if (!array[i][j]) {
                System.out.println(num + ". " + i + " * " + j);
                array[i][j] = true;
                array[j][i] = true;
                num++;
                if (num > 15) right = true;
            }
        }
    }

    public static void main(String[] args) {
        arraysTask1();
        arraysTask2();
        arraysTask3();
        arraysTask4();
        arraysTask5();
        arraysTask6();
        arraysTask7();
        arraysTask8();
        arraysTask9();
        arraysTask10();
        arraysTask11();
        arraysTask12();
        arraysTask13();
        multiArraysTask1();
        multiArraysTask2();
        multiArraysTask3();
        multiArraysTask4();
        multiArraysTask5();
    }
}
