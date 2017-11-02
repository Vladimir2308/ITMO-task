package lecture5;

import java.util.Arrays;

public class Task2ObjectList {
    public static void main(String[] args) {
        ObjList list=new ObjList();
        list.add("qqwwe");
        list.add(new Integer(134));
        list.add(new int[5]);
        list.add("33");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(Arrays.toString((int []) list.get(2)));
        System.out.println(" Remove "+  list.remove(1));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(6));
    }
}
