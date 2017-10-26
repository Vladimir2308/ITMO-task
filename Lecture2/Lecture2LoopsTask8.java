package Lecture2;

public class Lecture2LoopsTask8 {
    public static void main(String[] args) {
        System.out.print("Числа Фибоначчи: ");
        int num=1;
        int temp1=0;
        int temp2;
        for(int i=1;i<12;i++){
            System.out.print(num+" ");
            temp2=num;
            num=num+temp1;
            temp1=temp2;
        }
    }
}
