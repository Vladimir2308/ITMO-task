package Lecture9;

import java.util.Iterator;



import static Lecture9.Utils.view;
import static Lecture9.Utils.viewIterator;

public class TaskAllUtil {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6};
        int[] arr2={40,50,60};
        int[] arr3={77,88,99};

        List list1 = Utils.toList(arr1);
        List list2 = Utils.toList(arr2);
        List list3 = Utils.toList(arr3);

        Iterator view = viewIterator(list1, list1, list2, list3);

        while (view.hasNext())
            System.out.println(view.next());

        System.out.println("== Iterable ==");

        // Iterable
        for (Object o : view(list1, list2, list3)) {
            System.out.println(o);
        }

        System.out.println("== Filter ==");

        // Filter
        Iterable iterable = view(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                if ((Integer) obj % 2 == 0)
                    return true;
                return false;

            }
        }, list1,list2,list3);
        for (Object o : iterable)
            System.out.println(o);
        // Transformer
        Iterable iterable3 = view(new Transformer() {
            @Override
            public Object transform(Object obj) {
                return  (Integer) obj / 5 ;

            }
        }, list1,list2,list3);
        for (Object o : iterable3)
            System.out.println(o);
    }
}
