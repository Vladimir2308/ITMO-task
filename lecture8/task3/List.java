package lecture8.task3;
public interface List extends Iterable, Cloneable{
    void add(Object obj);
    Object get(int num);
    Object remove(int num);
    int getsize();
    void print();



}

