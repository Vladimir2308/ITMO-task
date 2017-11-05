package lecture10.task2Generics;

import java.util.Iterator;

public class ArrayList<E> implements List<E>, Stack<E>, Queue<E> {
    private int count;
    private int maxSize;
    private Object[] array;
    private int number;

    ArrayList() {
        maxSize = 100;
        count = -1;
        number = -1;
        array = new Object[maxSize];
    }


    @Override
    public void add(E obj) {
        if (++number == maxSize) {
            int oldSize = maxSize;
            maxSize *= 1.5;
            Object[] newarray = new Object[maxSize];
            number = -1;
            for (int i = 0; i < oldSize; i++) {
                if (!array[i].equals(null)) {
                    newarray[++number] = array[i];
                }
            }
            array = newarray;
            number++;
        }
        array[number] = obj;
        count++;
    }

    @Override
    public E poll() {
        if (count >= 0) {
            int i = 0;
            while (i < number) {
                if (array[i].equals(null))
                    i++;
                else {
                   E temp = (E)array[i];
                    array[i] = null;
                    count--;
                    return temp;
                }
            }
        }
        return null;
    }

    @Override
    public E get(int num) {
        if (num <= count) {
            int j = 0;
            int i = 0;
            while (j < num) {
                if (!array[i++].equals(null)) j++;
            }
            return (E)array[i];
        }
        return null;
    }

    @Override
    public E remove(int num) {
        if (num <= count && count >= 0) {
            int j = -1;
            int i = 0;
            for (; i < number; i++) {
                if (array[i]!=null)
                    if (++j == num) break;
            }
            E temp = (E)array[i];
            array[i] = null;
            count--;
            return temp;
        }
        return null;
    }

    @Override
    public int getsize() {
        return count;
    }

    @Override
    public void push(E obj) {
        add(obj);
    }

    @Override
    public E pop() {
        return remove(count);

    }

    public void print() {
        if (count < 0) {
            System.out.println(" List is Empty");
            return;
        }
        System.out.println(" count " + count);
        int j = 0;
        int i = -1;
        while (j <= count) {
            if (!array[++i].equals("NullPointer"))

                System.out.println("[" + j++ + "] " + array[i]);
        }

        Object temp = array[i];
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = ArrayList.this.count;
            private int index = -1;
            private int num = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Object next() {
                if (index <= count) {
                    while (array[num].equals(null))
                        num++;
                    index++;
                    return array[num++];
                }
                return -1;
            }

            @Override
            public void remove() {
            }
        };
    }
}
