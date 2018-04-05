import java.util.List;
import java.util.*;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.03
 *
 */
public class LinkedList<E> {
    private Node<E> head;
    
    public LinkedList() {
        head = new Node<E>(null, null);
    }
    public boolean add(E e) {
        Node<E> temp = head;
        //done so it is a copy of head & can traverse the array
        //thought because it's an object, it's less of a copy and more of a reference.
        return addRec(e, temp);
    }
    public boolean addRec(E e, Node<E> roam) {
        if (roam.getNext() == null) {
            //getnext because can't add another node to list if the current one is null.
            Node<E> newNode = new Node<E>(e);
            roam.setNext(newNode);
            return true;
        }
        return addRec(e, roam.getNext());
    }
    
    public boolean contains(E element) {
        return containsRec(element, head.getNext());
    }
    public boolean containsRec(E element, Node<E> node) {
        if (node == null) {
            return false;
        }
        if (node.getData().equals(element)) {
            return true;
        }
        return containsRec(element, node.getNext());
    }
    public void clean() {
        head.setNext(null);
    }
    public String toString() {
        return toString(head.getNext());
    }
    public String toString(Node<E> node) {
        if (node == null) {
            return "";
        }
        return node.getData().toString() + toString(node.getNext());
    }
}
