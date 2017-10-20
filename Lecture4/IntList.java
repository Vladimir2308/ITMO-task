package Lecture4;

class IntList {
    private Item head;
    private int count;


    IntList() {
        head = null;
        count = -1;
    }

    void add(int value) {
        Item item = new Item(value);
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

    void addWithSort(int value) {
        Item item = new Item(value);
        if (count < 0) {
            head = item;
        } else {
            Item temp = head;
            if (temp.value > value) {
                head = item;
                item.next = temp;
            } else {
                for (int i = 0; i < count+1; i++) {
                    if (temp.next == null) {
                        temp.next = item;
                        break;
                    }
                    if (temp.next.value > value) {
                        Item temp2 = temp.next;
                        temp.next = item;
                        item.next=temp2;
                        break;
                    }
                    temp=temp.next;
                }

            }

        }
        count++;
    }


    int get(int index) {
        if (index > count) return -1;
        Item item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.value;
    }

    int remove(int index) {
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
        return temp.value;

    }
}