package Lecture7.Task5LazyAccumulator;


import java.util.Iterator;

class LinkedList implements Stack {
    private Item head;
    private int count;

    LinkedList() {
        head = null;
        count = -1;
    }


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



    public void push(Item item ) {


        if (count < 0) {
            head = item;
        } else {
            Item temp = head;
            for (int i = 0; i < count; i++) {
                temp = temp.next;
            }
            temp.next = item;
            item.next=null;
        }
        count++;
    }

    @Override
    public int getsize() {
        return count;
    }


    public void clear() {

        head = null;
        count = -1;
    }




    public Item pop() {
        if (count<0 ) return null;
        Item item = head;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                item = item.next;
            }
        }
        Item temp=item;
        item = null;
        if (count==0)
            head=null;

        count--;
        return temp;
    }

    public void print() {
        if (count < 0) {
            System.out.println(" List is Empty");
            return;
        }
        Item temp = head;
        int i = 0;
        while (temp != null) {
            System.out.println("[" + i++ + "] " + temp.obj+" "+ temp.value);
            temp = temp.next;
        }
    }
}