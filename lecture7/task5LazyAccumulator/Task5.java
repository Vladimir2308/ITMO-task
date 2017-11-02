package lecture7.task5LazyAccumulator;

public class Task5 {
    public static void main(String[] args) {
        Stack stack = new LinkedList();
        Accumulator lazyAcc = new Accumulator(4, stack);
        lazyAcc.add(40, new Operation() {
                    int doOperation(int x, int y) {
                        return x + y;
                    }
                }
        );
        lazyAcc.add(30, new Operation() {
                    int doOperation(int x, int y) {
                        return x - y;
                    }
                }
        );
        lazyAcc.add(30, new Operation() {
                    int doOperation(int x, int y) {
                        return x * y;
                    }
                }
        );
        stack.print();
        System.out.print(lazyAcc.calculate());

    }
}
