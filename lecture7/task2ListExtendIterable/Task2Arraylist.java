package lecture7.task2ListExtendIterable;


public class Task2Arraylist {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("yqqwwe");
        list.add(134);
        list.add(new int[5]);
        list.add("33");
        ((ArrayList) list).print();
        System.out.println(list.get(6));

        System.out.println(" Remove " + list.remove(1));
        ((ArrayList) list).print();
        Stack stack = (Stack) list;
        stack.push("qqwwe");
        stack.push(137);
        stack.push("ooo--");
        stack.push("333");
        ((ArrayList) stack).print();
        System.out.println(" Stack " + stack.pop() + " " + stack.pop() + " " + stack.pop() + " " + stack.pop()+ " " + stack.pop()+ " " + stack.pop()+ " " + stack.pop()+ " " + stack.pop());
        ((ArrayList) list).print();
        Queue queue = (Queue) stack;
        queue.add("ZzzZ");
        queue.add(138);
        queue.add("yyyy");
        queue.add(222);
        ((ArrayList) list).print();
        System.out.println(" Poll " + queue.poll());
        ((ArrayList) list).print();
        int i=0;
        for(Object o : list) {
            System.out.println(i++ + " " + o);
        }
    }
}
