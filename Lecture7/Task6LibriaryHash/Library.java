package Lecture7.Task6LibriaryHash;

public class Library {
    List[] array = new List[6];
    int count = 0;

    void put(Book book, int quantity) {
        int index = book.hashCode() % 6;
        System.out.println("Index of array " + index);
        List list;
        if (array[index]==null) {
            list = new LinkedList();
            array[index] = list;
            list.add(book, quantity);
        } else {
            list = array[index];
            if (list.getRefer(book) == null) {
                list.add(book, quantity);
            } else {
                Item item = list.getRefer(book);
                if (item.obj.equals(book))
                    item.value += quantity;
                else
                    list.add(book, quantity);
            }
        }

    }


    int get(Book book, int quantity) {
        int index = book.hashCode() % 6;
        List list;
        if (array[index].equals(null)) {
            return -1;
        } else {
            list = array[index];
            if (list.getRefer(book) == null) {
                return -1;
            } else {
                Item item = list.getRefer(book);
                if (item.obj.equals(book)) {
                    item.value -= quantity;
                    return quantity;
                } else
                    return -1;
            }
        }

    }


    int getQuantity(Book book) {
        int index = book.hashCode() % 6;
        List list;
        if (array[index].equals(null)) {
            return -1;
        } else {
            list = array[index];
            if (list.getRefer(book) == null) {
                return -1;
            } else {
                Item item = list.getRefer(book);
                if (item.obj.equals(book)) {

                    return item.value;
                } else
                    return -1;
            }
        }
    }
}