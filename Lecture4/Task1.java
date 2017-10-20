package Lecture4;

public class Task1 {
    public static void main(String[] args) {
        Adder adder= new Adder(10);
        System.out.println(adder.getValue());
        adder.add();
        adder.add();
        adder.add();
        System.out.println(adder.getValue());

    }
}
