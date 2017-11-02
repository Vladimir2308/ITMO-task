package lecture10.task2Generics;

public interface Queue<E> {
    void add(E obj);
    Object poll();
    Object clone() throws CloneNotSupportedException;
}
