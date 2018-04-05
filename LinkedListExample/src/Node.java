/**
 * 
 */

//import java.util.*;

/**
 * @author Evan Hruskar
 * @version 2018.04.03
 *
 */
public class Node<E> {
    private E data;
    private Node<E> next;

    /**
     * 
     */
    public Node() {
        //everything will be null be default
    }
    
    public Node(E data) {
        this.data = data;
    }
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * @return the data
     */
    public E getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * @return the next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    

}
