package Lecture5;

class ObjList {
    private Item head;
    private int count;


    ObjList() {
        head = null;
        count = -1;
    }

    void add(Object obj) {
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




    Object get(int index) {
        if (index > count) return -1;
        Item item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.obj;
    }

    Object remove(int index) {
        if (index > count) return -1;
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
}