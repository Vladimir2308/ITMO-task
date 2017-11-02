package lecture7.task2ListExtendIterable;
public interface List extends Iterable{
    void add(Object obj);
    Object get(int num);
    Object remove(int num);
    int getsize();
}

