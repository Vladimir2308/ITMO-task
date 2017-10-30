package Lecture8.Task2;


public class Task2Utils {
    public static void main(String[] args) {
        Object [] arr={12,"qqq",new Boolean(true),444};
        List list=Utils.toList(arr);
        Utils.print("From array to list",list);
        List list1 = new LinkedList();
        List list2 = new LinkedList();
        list1.add("qqwwe");
        list1.add(134);
        Boolean thatTrue = new Boolean(true);
        list1.add(thatTrue);
        list1.add(new int[5]);
        list1.add(33);
        list2.add("33");
        list2.add(new int[5]);
        list2.add("333");
        list2.add("133");
        list2.add(new Boolean(true));
        Utils.print("List1",list1);
        Utils.print("List2",list2);
         list = Utils.intersect(list1, list2, new Predicate2() {
            @Override
            public boolean apply(Object obj1, Object obj2) {
                if (obj1 == obj2) return true;
                if (obj1 == null || obj2 == null ) return false;
                if (obj1.toString().equals(obj2.toString())) return true;
                return false;

            }
        });



        Utils.print("List with Predicate",list);
        list = Utils.intersect(list1, list2,null);
        Utils.print("List without Predicate ",list);
        list = Utils.difference(list1, list2, new Predicate2() {
            @Override
            public boolean apply(Object obj1, Object obj2) {
                if (obj1 == obj2) return true;
                if (obj1 == null || obj2 == null ) return false;
                if (obj1.toString().equals(obj2.toString())) return true;
                return false;

            }
        });
        Utils.print("List difference with Predicate",list);
    }
}
