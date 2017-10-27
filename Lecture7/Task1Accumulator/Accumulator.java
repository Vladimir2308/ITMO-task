package Lecture7.Task1Accumulator;


public class Accumulator {
    private int value;
    private Operation oper;

    Accumulator(int value, Operation oper) {
        this.value = value;
        this.oper = oper;
    }


    void accumalate(int num) {
        value = oper.doOperation(value, num);

    }

    int getValue() {
        return value;
    }


}

class Operation {
    int doOperation(int x, int y) {
        return -1;
    }
}

class Multiply extends Operation {
    int doOperation(int x, int y) {
        return x * y;
    }
}



class Divide extends Operation {
    int doOperation(int x, int y) {
        return x / y;
    }
}

class Power extends Operation {
    int doOperation(int x, int y) {
        return (int) Math.pow(x, y);
    }

}