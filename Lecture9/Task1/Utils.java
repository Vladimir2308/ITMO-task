package Lecture9.Task1;

import Lecture8.Task3.Predicate2;


import java.util.Iterator;

public final class Utils {

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
            newList.add(trans.transform(o));
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

    static List toList(int[] arr) {
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
            Boolean isContain = false;
            for (Object obj2 : list2) {
                if (pred != null) {
                    if (pred.apply(obj1, obj2))
                        isContain = true;
                } else {
                    if (obj1.equals(obj2))
                        isContain = true;
                }
            }
            if (!isContain)
                list.add(obj1);
        }
        return list;
    }

    static void print(String str, List list) {
        int i = 0;
        System.out.println(str);
        for (Object o : list) {
            System.out.println("[" + i++ + "] " + o);
        }

    }

    static Iterator viewIterator(Iterable it1, Iterable... it2) {
        Iterator[] iters = new Iterator[it2.length + 1];

        iters[0] = it1.iterator();

        for (int i = 0; i < it2.length; i++)
            iters[i + 1] = it2[i].iterator();

        return new ViewIterator(iters);
    }

    public static Iterable view(final Iterable it1, final Iterable... it2) {
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return viewIterator(it1, it2);
            }
        };
    }

    static class ViewIterator implements Iterator {
        private Iterator[] iters;
        private int idx;

        public ViewIterator(Iterator... iters) {
            this.iters = iters;

        }

        @Override
        public boolean hasNext() {
            if (idx == iters.length)
                return false;

            if (iters[idx].hasNext())
                return true;

            idx++;

            return hasNext();
        }

        @Override
        public Object next() {
            return iters[idx].next();
        }


    }

    //Predicate
    static Iterator viewIterator(Predicate p, Iterable it1, Iterable... it2) {
        Iterator[] iters = new Iterator[it2.length + 1];

        iters[0] = it1.iterator();

        for (int i = 0; i < it2.length; i++)
            iters[i + 1] = it2[i].iterator();

        return new ViewIteratorFilter(p, iters);
    }

    public static Iterable view(Predicate p, final Iterable it1, final Iterable... it2) {
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return viewIterator(p, it1, it2);
            }
        };
    }

    static class ViewIteratorFilter implements Iterator {
        private Iterator[] iters;
        private Predicate p;
        private int idx;
        Object obj;


        public ViewIteratorFilter(Predicate p, Iterator... iters) {
            this.iters = iters;
            this.p = p;
        }

        @Override
        public boolean hasNext() {
            if (idx == iters.length)
                return false;

            while (iters[idx].hasNext()) {
                obj = iters[idx].next();
                if (p.apply(obj))
                    return true;
            }
            idx++;

            return hasNext();
        }

        @Override
        public Object next() {
            return obj;
        }
    }

    //Transformer
    static Iterator viewIterator(Transformer t, Iterable it1, Iterable... it2) {
        Iterator[] iters = new Iterator[it2.length + 1];

        iters[0] = it1.iterator();

        for (int i = 0; i < it2.length; i++)
            iters[i + 1] = it2[i].iterator();

        return new ViewIteratorTransformer(t, iters);
    }

    public static Iterable view(Transformer t, final Iterable it1, final Iterable... it2) {
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return viewIterator(t, it1, it2);
            }
        };
    }

    static class ViewIteratorTransformer implements Iterator {
        private Iterator[] iters;
        private Transformer t;
        private int idx;
        Object obj;


        public ViewIteratorTransformer(Transformer t, Iterator... iters) {
            this.iters = iters;
            this.t = t;

        }

        @Override
        public boolean hasNext() {
            if (idx == iters.length)
                return false;

            if (iters[idx].hasNext())
                return true;

            idx++;

            return hasNext();
        }

        @Override
        public Object next() {
            return t.transform(iters[idx].next());
        }
    }
}