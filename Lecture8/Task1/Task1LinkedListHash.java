package Lecture8.Task1;


public class Task1LinkedListHash {
    public static void main(String[] args) {

        List list1 = new LinkedList();
        List list2 = new LinkedList();
        List list3 = new LinkedList();
        List list4 = new LinkedList();
        list1.add("qwerty");
        list2.add("qwerty");
        list3.add("qwerty");
        list4.add("Noqwerty");
        list1.add(11);
        list2.add(11);
        list3.add(22);
        list4.add(new Boolean(false));
        list1.add(22);
        list2.add(22);
        list3.add(11);
        list4.add(new Boolean(true));
        System.out.print("list1 : ");
        list1.print();
        System.out.println(" list1.hashCode() : "+ list1.hashCode());
        System.out.print("list2 : ");
        list2.print();
        System.out.println(" list2.hashCode() : "+ list2.hashCode());
        System.out.print("list3 : ");
        list3.print();
        System.out.println(" list3.hashCode() : "+ list3.hashCode());
        System.out.print("list4 : ");
        list4.print();
        System.out.println(" list4.hashCode() : "+ list4.hashCode());
        System.out.println("list1.equals(list2) =  "+ list1.equals(list2));
        System.out.println("list1.equals(list3) =  "+ list1.equals(list3));
        System.out.println("list1.equals(list4) =  "+ list1.equals(list4));
        System.out.println("list2.equals(list1) =  "+ list2.equals(list1));
        System.out.println("list1.equals(list1) =  "+ list1.equals(list1));
    }

}
