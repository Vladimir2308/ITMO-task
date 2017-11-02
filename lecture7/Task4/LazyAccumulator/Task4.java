package lecture7.Task4.LazyAccumulator;

public class Task4 {
    public static void main(String[] args) {
        List list = new LinkedList();
        Accumulator lazyAcc = new Accumulator(40, list);
        lazyAcc.add(10, new Operation() {
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
        System.out.print(lazyAcc.calculate());

    }
}
