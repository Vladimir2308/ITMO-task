package lecture13.task1Exceptions;


import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ArrayList implements List {
    private int count;
    private int maxSize;
    private Object[] array;
    private long version = 0;

    ArrayList() {
        maxSize = 100;
        count = -1;
        array = new Object[maxSize];
    }


    @Override
    public void add(Object obj) {
        if (++count == maxSize) {
            int oldSize = maxSize;
            maxSize *= 1.5;
            Object[] newarray = new Object[maxSize];
            for (int i = 0; i < oldSize; i++) {

                newarray[++count] = array[i];

            }
            array = newarray;
            ++count;
        }
        array[count] = obj;

        version++;
    }


    @Override
    public Object get(int num) {
        if (num <= count) {
            return array[num];
        }
        try {
            throw new NullPointerException("ArrayList don't contain value of this num, get another num");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object remove(int num) {
        if (num <= count && count >= 0) {
            Object temp = array[num];
            for (int i = num; i < count; i++) {

                array[i] = array[i + 1];

            }

            count--;
            version++;
            return temp;
        }
        version++;
        return null;
    }

    @Override
    public int getsize() {
        return count;
    }
    public int size() {
        return count;
    }

    public void print() {
        if (count < 0) {
            System.out.println(" List is Empty");
            return;
        }
        System.out.println(" count " + count);

        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = ArrayList.this.count;
            private int index = -1;
            private int num = 0;
            private long version = ArrayList.this.version;

            @Override
            public boolean hasNext() {

                if (version == ArrayList.this.version)
                    return index < count;
                else throw new ConcurrentModificationException("List has been changing during iteration");
            }

            @Override
            public Object next() {
                if (version == ArrayList.this.version) {


                    if (index < count) {
                        ++index;
                        return array[num++];
                    }
                    return -1;
                } else throw new ConcurrentModificationException("List has been changing during iteration");
            }

            @Override
            public void remove() {
            }
        };
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("yqqwwe");
        list.add(134);
        list.add(new int[5]);
        list.add("33");
//        System.out.println(" Remove " + list.remove(1));
        ((ArrayList) list).print();
        System.out.println(" get(1) " + list.get(1));
//       System.out.println(list.get(6));

        for (Object o :
                list) {
            list.remove(0);
            System.out.println(o);
        }

    }
}
