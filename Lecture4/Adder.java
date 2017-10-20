package Lecture4;

public class Adder {
    private int num, value;

    Adder(int value) {
        this.value = value;
    }

    void add() {
        num += value;
    }

    int getValue() {
        return num;
    }

}

