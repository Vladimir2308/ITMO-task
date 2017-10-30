package Lecture8.Task3;

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
            Item item=head;
            int i=0;

            @Override
            public boolean hasNext() {
                return item!=null;
            }

            @Override
            public Object next() {
              Item temp=item;
                item=item.next;
                    return temp.obj;

            }
            @Override
            public void remove() {
            }
        };
    }

    static class Item {
        Object obj;
        Item next;
        Item(Object obj){
            this.obj=obj;
        }
    }
    @Override
    public void add(Object obj) {
        Item item = new Item(obj);

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




    public Object get(int index) {
        if (index > count) return "NullPointerObject";
        Item item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.obj;
    }

    public Object remove(int index) {
        if (index > count || index < 0) return "NullPointerObject";
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

        return temp.obj;

    }

    @Override
    public int getsize() {
        return count;
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