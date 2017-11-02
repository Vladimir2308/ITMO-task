package lecture8.task1;



public interface List extends Iterable{
    void add(Object obj);
    Item get(int num);
    Item remove(int num);
    int getsize();
    void clear();
    void print();
}

