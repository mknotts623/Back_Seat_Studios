
/**
 * Uses a linked list to keep track of a generic Stack of generic Nodes
 * 
 * @Christina Kim 
 * @9/25/17
 */
public class Stack <T>
{
    Node<T> top;
    Node<T> popped;

    public void push(T x) {
        Node xNode = new Node(x);
        xNode.setNext(top);
        top = xNode;
    }

    public Node peek() {
        return top;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        popped = top;
        top = top.getNext();
        popped.setNext(null);
        return popped.get();
    }
}