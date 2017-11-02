package lecture10.task2Generics;

public interface Stack<E> {
    void push(E obj);
    Object pop();
    Object clone() throws CloneNotSupportedException;
}
