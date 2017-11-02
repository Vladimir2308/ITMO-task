package lecture7.Task4.LazyAccumulator;


import java.util.Iterator;

class LinkedList implements List {
    private Item head;
    private int count;

    LinkedList() {
        head = null;
        count = -1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Item item = head;
            int i = 0;

            @Override
            public boolean hasNext() {
                return item != null;
            }

            @Override
            public Item next() {
                Item temp = item;
                item = item.next;
                return temp;

            }

            @Override
            public void remove() {
            }
        };
    }

    static class Item {
        Object obj;
        int value;
        Item next;

        Item(Object obj, int value) {
            this.obj = obj;
            this.value = value;
        }
    }

    public void add(Object obj, int value) {
        Item item = new Item(obj, value);

        if (count < 0) {
            head = item;
        } else {
            Item temp = head;
            for (int i = 0; i < count; i++) {
                temp = temp.next;
            }
            temp.next = item;
        }
        count++;
    }


    public Item poll() {
        if (count < 0) return null;
        Item temp = head;
        head = head.next;
        count--;
        return temp;
    }


    public Item get(int index) {
        if (index > count) return null;
        Item item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item;
    }

    public Item remove(int index) {
        if (index > count || index < 0) return null;
        Item temp;
        Item item = head;
        if (index == 0) {
            temp = item;
            head = item.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                item = item.next;
            }
            temp = item.next;
            item.next = item.next.next;
        }
        count--;

        return temp;

    }

    @Override
    public int getsize() {
        return count;
    }


    public void push(Object obj,int value) {
        add(obj,value);
    }
    public void clear() {

        head = null;
        count = -1;
    }

    public Object pop() {
        return remove(count);
    }

    public void print() {
        if (count < 0) {
            System.out.println(" List is Empty");
            return;
        }
        Item temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("[" + i++ + "] " + temp.obj);
            temp = temp.next;
        }
    }
}