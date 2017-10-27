package Lecture7.Task3.Utils;


public class Task3Utils {
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
        ((LinkedList) list).print();
//        System.out.println(" Poll " + queue.poll());
//        ((LinkedList) list).print();
        int i=0;
        for(Object item : list) {
            System.out.println(i++ + " " + ((LinkedList.Item)item).obj);
        }
    }
}
