package lecture7.task5LazyAccumulator;


public class Accumulator {
    private int value;
    private Operation oper;
    private Stack stack;

    Accumulator(int value, Stack stack) {
        this.value = value;
        oper = null;
        this.stack = stack;

    }


    int calculate() {
        Stack tempStack = new LinkedList();
        Item temp = stack.pop();

        while (temp != null) {

            tempStack.push(temp );

            temp = stack.pop();

        }
        tempStack.print();
        temp = tempStack.pop();
        int num;
        while (temp != null) {
            oper = (Operation) temp.obj;
            num = temp.value;
            temp = tempStack.pop();
            value = oper.doOperation(value, num);
        }
        return value;
    }




    int getValue() {
        return value;
    }


    public void add(int i, Operation oper) {
        Item item=new Item(oper,i);
        stack.push(item);
    }
}

class Operation {
    int doOperation(int x, int y) {
        return -1;
    }
}

