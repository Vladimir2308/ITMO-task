package lecture10.task2Generics;
public interface List<E> extends Iterable{
    void add(E obj);
    E get(int num);
    E remove(int num);
    int getsize();
    Object clone() throws CloneNotSupportedException;


}

