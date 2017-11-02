package lecture7.task6LibriaryHash;

public interface List extends Iterable{
    void add(Object obj, int value);
    Item get(int num);
    Item remove(int num);
    int getsize();
    Item getRefer(Book book);

    void clear();
}

