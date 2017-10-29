package Lecture7.Task3.Utils;

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


    static List filter(Predicate p, List list) {
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
    static void print( List list) {
        int i=0;
        for (Object o : list) {
            System.out.println("[" + i++ + "] " +o);
        }

    }

}
