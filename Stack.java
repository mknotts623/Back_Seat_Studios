
/**
 * Generic stack class, uses a singly linked list
 * 
 * @Christina Kim 
 * @9/25/17
 */
public class Stack <T>
{
    Node<T> top;
    Node<T> popped;

    /**
     * Puts value on top of the stack
     * @param x A value of the type specified in <T>
     */
    public void push(T x) {
        Node xNode = new Node(x);
        xNode.setNext(top);
        top = xNode;
    }

    
    /**
     * Getter for value on top of stack
     * @return Node<T> at the top of the stack
     */
    public Node peek() {
        return top;
    }

    /**
     * Returns top of stack, then makes Node<T> directly underneat the new Node<T> top
     * @return value of Node<T> popped off of top of stack
     */
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