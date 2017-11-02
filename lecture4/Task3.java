package lecture4;

public class Task3 {
    public static void main(String[] args) {
        IntList list=new IntList();
        list.addWithSort(5);
        list.addWithSort(4);
        list.addWithSort(6);
        list.addWithSort(8);
        list.addWithSort(1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(" Remove "+  list.remove(1));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(6));
    }
}
