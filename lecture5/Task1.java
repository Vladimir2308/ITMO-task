package lecture5;

public class Task1 {
    public static void main(String[] args) {

        Accumulator acc = new Accumulator(4, new Plus());
        System.out.print(" Plus  4 " );
        acc.accumalate(3);
        System.out.print(acc.getValue()+" ");
        acc.accumalate(9);
        System.out.println(  acc.getValue());
        Accumulator acc2 = new Accumulator(100, new Minus());
        System.out.print("   Minus 100 " );
        acc2.accumalate(3);
        System.out.print( acc2.getValue()+" ");
        acc2.accumalate(44);
        System.out.println( acc2.getValue());
        Accumulator acc3 = new Accumulator(3, new Multiply());
        System.out.print("   Multiply 3 " );
        acc3.accumalate(3);
        System.out.print( acc3.getValue()+" ");
        acc3.accumalate(6);
        System.out.println( acc3.getValue());
        Accumulator acc4 = new Accumulator(1000, new Divide());
        System.out.print("   Divide 1000 " );
        acc4.accumalate(3);
        System.out.print( acc4.getValue()+" ");
        acc4.accumalate(6);
        System.out.println( acc4.getValue());
        Accumulator acc5 = new Accumulator(2, new Power());
        System.out.print("   Power 2 " );
        acc5.accumalate(3);
        System.out.print( acc5.getValue()+" ");
        acc5.accumalate(3);
        System.out.println( acc5.getValue());
    }
}
