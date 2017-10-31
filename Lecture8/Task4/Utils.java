package Lecture8.Task4;

import Lecture8.Task3.Predicate2;
import Lecture8.Task3.Transformer;

public final class Utils {
    private Utils() {
    }

    static Object find(Predicate p, List list) {
        for (Object o : list) {
            if (p.apply(o))
                return o;
        }
        return null;
    }


    static List filter(List list, Predicate p) {
        List newList = new LinkedList();
        for (Object o : list) {
            if (p.apply(o))
                newList.add(o);
        }
        return newList;
    }

    static List transform(Transformer trans, List list) {
        List newList = new LinkedList();
        for (Object o : list) {
            newList.add(trans.tramsform(o));
        }
        return newList;

    }

    static List toList(Object[] arr) {
        List list = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    static List intersect(List list1, List list2, Predicate2 pred) {
        List list = new LinkedList();

        for (Object obj1 : list1) {
            for (Object obj2 : list2) {
                if (pred != null) {
                    if (pred.apply(obj1, obj2))
                        list.add(obj1);
                } else {
                    if (obj1.equals(obj2))
                        list.add(obj1);
                }
            }
        }
        return list;
    }

    static List difference(List list1, List list2, Predicate2 pred) {
        List list = new LinkedList();

        for (Object obj1 : list1) {
            Boolean isContain=false;
            for (Object obj2 : list2) {
                if (pred != null) {
                    if (pred.apply(obj1, obj2))
                        isContain=true;
                } else {
                    if (obj1.equals(obj2))
                        isContain=true;
                }
            }
            if(!isContain)
                list.add(obj1);
        }
        return list;
    }
    static void print(String str,List list) {
        int i = 0;
        System.out.println(str);
        for (Object o : list) {
            System.out.println("[" + i++ + "] " + o);
        }

    }

}
