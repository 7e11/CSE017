/**
 * 
 */
package test2;

/**
 * @author Evan Hruskar
 * @version 2018.04.09
 *
 */

public class SingleLinkedList<E> {
    private Node<E> head;
    private int size = 0;
    
    public SingleLinkedList() {
        //everything gets set to null
    }
    //added a constructor for this.
    public SingleLinkedList(E[] data) {
        head = new Node<E>(null, null);
        size = data.length;
        Node<E> currentNode = head;
        for (int i = 0; i < data.length; i++) {
            currentNode.next = new Node<E>(data[i], null);
            currentNode = currentNode.next;
        }
    }
    
    public String toString() {
        return toString(head.next);
    }
    public String toString(Node<E> node) {
        if (node == null) {
            return "";
        }
        return node.data.toString() + toString(node.next);
    }

    //---------------------------------------------------------------------------
    public SingleLinkedList<E> divideInHalf() {
        Node<E> roam = head;
        return divideInHalf(0, roam);
    }



    public SingleLinkedList<E> divideInHalf(int index, Node<E> roam) {
        if (index <= size/2) {
            return divideInHalf(index + 1, roam.next);
        }
        SingleLinkedList<E> bottomHalf = new SingleLinkedList<E>();
        bottomHalf.head = new Node<E>(null, roam.next);
        //created a head node which links up to the rest of the nodes
        //this assumes the head has no data
        roam.next = null;
        //completes the first list
        return bottomHalf;
    }
    //---------------------------------------------------------------------------
    
    private static class Node<E> {
      private E data;
      private Node<E> next;

      /** Creates a new node with a null next field
          @param dataItem  The data stored
      */
      private Node(E data) {
        //data = dataItem;
        this.data = data;
        next = null;
      }

     /** Creates a new node that references another node
          @param dataItem  The data stored
          @param nodeRef  The node referenced by new node
      */
      private Node(E dataItem, Node<E> nodeRef) {
        data = dataItem;
        next = nodeRef;
      }
   }
   
 }
