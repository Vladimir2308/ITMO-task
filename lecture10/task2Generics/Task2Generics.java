package lecture10.task2Generics;

//import java.util.ArrayList;

public class Task2Generics {
    public static void main(String[] args) {
        List<String> strings ;
        String[] arr={"1234","ert","sdfs"};

        strings = Utils.toList(arr);
        strings.add("string");
        Utils.print("List string ", strings);
        strings.remove(2);
        Utils.print("List string ", strings);

        Stack<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(22);
        stack.push(14);
        stack.push(1110);
        Utils.print("Stack stack ", stack);
        stack.pop();
        Utils.print("Stack stack ", stack);
        Queue<Boolean> queue=new LinkedList();
        queue.add(true);
        queue.add(false);
        Utils.print("Queue queue ", queue);
        queue.poll();
        Utils.print("Queue queue ", queue);

    }
}
