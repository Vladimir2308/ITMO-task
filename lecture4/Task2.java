package lecture4;

public class Task2 {
    public static void main(String[] args) {
        IntList list=new IntList();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(" Remove "+  list.remove(1));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(6));
    }
}
