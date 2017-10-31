package Lecture9.Task1;

import java.util.Iterator;


import static Lecture9.Task1.Utils.view;
import static Lecture9.Task1.Utils.viewIterator;

public class Task1Util {
    public static void main(String[] args) {
        List list1 = new LinkedList();
        List list2 = new LinkedList();
        List list3 = new LinkedList();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list2.add(40);
        list2.add(50);
        list2.add(60);

        list3.add(77);
        list3.add(88);
        list3.add(99);

        Iterator view = viewIterator(list1, list1, list2, list3);

        while (view.hasNext())
            System.out.println(view.next());

        System.out.println("== Iterable ==");

        // Iterable
        for (Object o : view(list1, list2, list3)) {
            System.out.println(o);
        }
        System.out.println("== Filter ==");

        Iterable iterable = Utils.filterView(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                if ((Integer) obj % 2 == 0)
                    return true;
                return false;

            }
        }, list1);
        for (Object o : iterable)
            System.out.println(o);

        System.out.println("______________== Filter + Iterable ==______________");

        Iterator view1 = viewIterator(list1, list1, list2, list3);
        Iterable iterable2 = Utils.filterView(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                if ((Integer) obj % 2 == 0)
                    return true;
                return false;

            }
        }, view1);
        for (Object o : iterable2)
            System.out.println(o);
    }
}
