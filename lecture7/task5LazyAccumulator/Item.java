package lecture7.task5LazyAccumulator;

public class Item {
    Object obj;
    int value;
    Item next;

    Item(Object obj, int value) {
        this.obj = obj;
        this.value = value;
    }
}