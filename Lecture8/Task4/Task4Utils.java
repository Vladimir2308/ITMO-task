package Lecture8.Task4;

public class Task4Utils {
    public static void main(String[] args) {
        List list=new LinkedList();
        LinkedList list2=(LinkedList)list;
        list.add("qqwwe");
        list.add(134);
        Boolean thatTrue = new Boolean(true);
        list.add(thatTrue);
        list.add(new int[5]);
        list.add(33);
        List list1=null;
        try {
            list1= (LinkedList) list.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Utils.print("list1 " , list1);
        list.remove(0);
        Utils.print("List ", list);
        Utils.print("List clone ", list1);



    }
}
