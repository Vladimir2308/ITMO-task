package lecture8.task4;
public interface List extends Iterable{
    void add(Object obj);
    Object get(int num);
    Object remove(int num);
    int getsize();
    void print();
    Object clone() throws CloneNotSupportedException;


}

