import java.util.EmptyStackException;

//-------------------------------------------------------------------------
/**
 * An implementation of the stack data type that uses a linked chain of
 * {@code Node<E>} objects to store its contents.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <E> the type of elements stored in the stack
 *
 * @author Tony Allevato (authored class skeleton)
 * @author  Evan Hruskar
 * @version 2018.04.04
 */
public class LinkedStack<E> implements StackInterface<E>
{
    //~ Fields ...............................................................
    private Node<E> head;
    //head doesn't contain data
    private Node<E> tail;
    //tail doesn't contain data
    //tail is included to make push O(1)

    //~ Constructors .........................................................

    // ----------------------------------------------------------
    /**
     * default constructor
     */
    public LinkedStack()
    {
        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.join(tail);
    }


    //~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * @param item the item to push
     * 
     */
    public void push(E item)
    {
        //include a tail makes it O(1)
        //rather than O(n)
        Node<E> last = tail.previous();
        last.split();
        Node<E> newPush = new Node<E>(item);
        last.join(newPush);
        newPush.join(tail);
    }

    
    // ----------------------------------------------------------
    /**
     * pop the last item off
     */
    public void pop()
    {
        //without a tail this would also be O(n)
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<E> nearLast = tail.previous().previous();
        Node<E> last = tail.previous();
        nearLast.split();
        last.split();
        nearLast.join(tail);
    }


    // ----------------------------------------------------------
    /**
     * @return the top value
     */
    public E peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return tail.previous().data();
    }


    // ----------------------------------------------------------
    /**
     * easy check for empty.
     * @return whether it's empty or not
     */
    public boolean isEmpty()
    {
        return head.next() == tail;
    }
}
