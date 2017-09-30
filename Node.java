/**
 * Generic node class
 * 
 * @author  Somebody idk
 * @version 0.0.0
 */
public class Node <T>
{
    T value;
    Node next;
    
    /**
     * A default node constructor
     * @param val a value to be stored in the node
     */
    public Node(T val) {
        value = val;
    }
    
    /**
     * A node getter
     * @return the value stored by the node
     */
    public T get() {
        return value;
    }
    
    /**
     * A setter for the node's value
     * @param v a value for the node to hold
     */
    public void set(T v) {
        value = v;
    }
    
    /**
     * Getter for the next node
     * @return the next node
     */
    public Node getNext() {
        return next;
    }
    
    /**
     * Setter for the next node
     * @param n the next node to be set
     */
    public void setNext(Node n) {
        next = n;
    }
}
