package lecture7.task2ListExtendIterable;


import java.util.Iterator;

public class ArrayList implements List, Stack, Queue {
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
    public void add(Object obj) {
        if (++number == maxSize) {
            int oldSize = maxSize;
            maxSize *= 1.5;
            Object[] newarray = new Object[maxSize];
            number = -1;
            for (int i = 0; i < oldSize; i++) {
                if (!array[i].equals("NullPointer")) {
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
    public Object poll() {
        if (count >= 0) {
            int i = 0;
            while (i < number) {
                if (array[i].equals("NullPointer"))
                    i++;
                else {
                    Object temp = array[i];
                    array[i] = "NullPointer";
                    count--;
                    return temp;
                }
            }
        }
        return "NullPointer";
    }

    @Override
    public Object get(int num) {
        if (num <= count) {
            int j = 0;
            int i = 0;
            while (j < num) {
                if (!array[i++].equals("NullPointer")) j++;
            }
            return array[i];
        }
        return "NullPointer";
    }

    @Override
    public Object remove(int num) {
        if (num <= count && count >= 0) {
            int j = -1;
            int i = 0;
            for (; i < number; i++) {
                if (!array[i].equals("NullPointer"))
                    if (++j == num) break;
            }
            Object temp = array[i];
            array[i] = "NullPointer";
            count--;
            return temp;
        }
        return "NullPointer";
    }

    @Override
    public int getsize() {
        return count;
    }

    @Override
    public void push(Object obj) {
        add(obj);
    }

    @Override
    public Object pop() {
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
                    while (array[num].equals("NullPointer"))
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
