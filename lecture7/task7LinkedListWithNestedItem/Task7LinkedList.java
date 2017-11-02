package lecture7.task7LinkedListWithNestedItem;

import lecture6.linkedList.List;
import lecture6.linkedList.Queue;
import lecture6.linkedList.Stack;

public class Task7LinkedList {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("qqwwe");
        list.add(134);
        list.add(new int[5]);
        list.add("33");
        ((LinkedList) list).print();
        System.out.println(list.get(6));

        System.out.println(" Remove " + list.remove(1));
        ((LinkedList) list).print();
        Stack stack = (Stack) list;
        stack.push("qqqqqq");
        stack.push(134);
        stack.push(new int[445]);
        stack.push("333");
        ((LinkedList) list).print();
        System.out.println(" Stack " + stack.pop() + " " + stack.pop() + " " + stack.pop() + " " + stack.pop());
        ((LinkedList) list).print();
        Queue queue = (Queue) stack;
        queue.add("ZzzZ");
        queue.add(138);
        ((LinkedList) list).print();
        System.out.println(" Poll " + queue.poll());
        ((LinkedList) list).print();
        System.out.println(" Poll " + queue.poll());
        System.out.println(" Poll " + queue.poll());
        System.out.println(" Poll " + queue.poll());
        System.out.println(" Poll " + queue.poll());
        System.out.println(" Poll " + queue.poll());


    }
}
