package Lecture7.Task4.LazyAccumulator;


public class Accumulator {
    private int value;
    private Operation oper;
    private List list;

    Accumulator(int value, List list) {
        this.value = value;
        oper = null;
        this.list = list;

    }


    int calculate() {
        if (list.getsize() > 0) {
            int num;
            for (Object i :
                    list) {
                oper = (Operation) ((LinkedList.Item) i).obj;
                num = ((LinkedList.Item) i).value;
                value = oper.doOperation(value, num);
            }

        }
        list.clear();
        return value;
    }

    int getValue() {
        return value;
    }


    public void add(int i, Operation oper) {
        list.add(oper, i);
    }
}

class Operation {
    int doOperation(int x, int y) {
        return -1;
    }
}

