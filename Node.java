public class Node <T>
{
    T value;
    Node next;
    
    public Node(T val) {
        value = val;
    }
    
    public T get() {
        return value;
    }
    public void set(T v) {
        value = v;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
}