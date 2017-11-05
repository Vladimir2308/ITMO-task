package lecture10.task2Generics;

import java.util.Iterator;

class LinkedList<E> implements List<E>,Stack<E>,Queue<E>, Cloneable {
    private Item<E> head;
    private int count;

    public LinkedList() {
        head = null;
        count = -1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Item<E> item = head;


            @Override
            public boolean hasNext() {
                return item != null;
            }

            @Override
            public E next() {
                Item<E> temp = item;
                item = item.next;
                return temp.obj;

            }

            @Override
            public void remove() {
            }
        };
    }

    static class Item<E> {
        E obj;
        Item<E> next;

        Item(E obj) {
            this.obj = obj;
        }
    }

    @Override
    public void add(E obj) {
        Item<E> item = new Item<>(obj);

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
    @Override
    public void push(E obj) {
        add(obj);
    }

    @Override
    public E pop() {
        return remove(count);
    }
    @Override
    public E poll() {
        if (count < 0) return null;
        Item<E> temp = head;
        head = head.next;
        count--;
        return temp.obj;
    }


    public E get(int index) {
        if (index > count) return null;
        Item<E> item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.obj;
    }

    public E remove(int index) {
        if (index > count || index < 0) return null;
        Item<E> temp;
        Item<E> item = head;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public void print() {
        if (count < 0) {
            System.out.println(" List is Empty");
            return;
        }
        Item<E> temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("[" + i++ + "] " + temp.obj);
            temp = temp.next;
        }
    }
}