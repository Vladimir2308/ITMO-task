package lecture7.task5LazyAccumulator;

public interface Stack extends Iterable {
    void push(Item item);
    Item pop();

    int getsize();
    void print();
    void clear();
}
