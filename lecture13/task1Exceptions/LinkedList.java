package lecture13.task1Exceptions;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedList implements List {
    private Item head;
    private int count;
    private long version=0;
    public LinkedList() {
        head = null;
        count = -1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Item item=head;
            int i=0;
            private long version=LinkedList.this.version;

            @Override
            public boolean hasNext() {

                if (version == LinkedList.this.version)
                    return item != null;
                else throw new ConcurrentModificationException("List has been changing during iteration");
            }

            @Override
            public Object next() {
                if (version == LinkedList.this.version){
                Object temp=item.obj;
                item=item.next;
                    return temp;}
                else throw new ConcurrentModificationException("List has been changing during iteration");
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
        version++;
    }


    public Object get(int index) {
        if (index > count){
            try {
                throw new NullPointerException("ArrayList don't contain value of this num, get another num");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        Item item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.obj;
    }

    public Object remove(int index) {
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
version++;
        return temp.obj;

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
        Item temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("[" + i++ + "] " + temp.obj);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("qqwwe");
        list.add(134);
        list.add(new int[5]);
        list.add("33");
        ((LinkedList) list).print();
        System.out.println(list.get(6));



    }

}