package lecture7.Task4.LazyAccumulator;
public interface List extends Iterable{
    void add(Object obj,int value);
    LinkedList.Item get(int num);
    LinkedList.Item remove(int num);
    int getsize();

    void clear();
}

