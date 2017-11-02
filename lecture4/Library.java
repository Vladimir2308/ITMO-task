package lecture4;

public class Library {
    Object[][] array = new Object[1000][2];
    int count = 0;

    void put(Book book, int quantity) {
        if (arrayIndex(book) < 0) {
            array[count][0] = book;
            array[count++][1] = quantity;
        } else
            array[arrayIndex(book)][1] = (Integer) array[arrayIndex(book)][1] + quantity;
    }

    int get(Book book, int quantity) {
        if (arrayIndex(book) < 0)
            return -1;
        else {
            int num = arrayIndex(book);
            if ((Integer) array[num][1] > quantity)
                array[num][1] = (Integer) array[num][1] - quantity;
            return (Integer) array[num][1];
        }

    }

    int arrayIndex(Book book) {
        for (int i = 0; i < count; i++) {
            if (array[i][0].equals(book)) return i;
        }
        return -1;
    }

    int getQuantity(Book book) {
        int num = arrayIndex(book);
        if (num >= 0)
            return (Integer) array[num][1];
        return -1;

    }
}