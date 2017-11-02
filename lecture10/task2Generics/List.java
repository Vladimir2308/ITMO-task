package lecture10.task2Generics;
public interface List<E> extends Iterable{
    void add(E obj);
    Object get(int num);
    Object remove(int num);
    int getsize();
    Object clone() throws CloneNotSupportedException;


}

