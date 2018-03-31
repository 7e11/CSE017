import java.util.ArrayList;
import java.util.EmptyStackException;

//-------------------------------------------------------------------------
/**
 * An implementation of the stack data type that adapts an ArrayList to
 * store its contents.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T> the type of elements stored in the stack
 *
 * @author Tony Allevato (authored class skeleton)
 * @author Evan Hruskar
 * @version 2018.03.30
 */
public class ArrayListStack<T> implements SimpleStack<T>
{
    //~ Instance/static variables ............................................
    /**
     * 
     */
    private ArrayList<T> array;

    //~ Constructors .........................................................

    // ----------------------------------------------------------
    /**
     * 
     */
    public ArrayListStack()
    {
        array = new ArrayList<T>();
    }


    //~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * Pushes the specified item onto the top of the stack.
     *
     * @param item the item to push onto the stack
     */
    public void push(T item)
    {
        array.add(item);
    }


    // ----------------------------------------------------------
    /**
     * Pops an item off the top of the stack.
     *
     * @throws EmptyStackException if the stack is empty
     */
    public void pop()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        array.remove(array.size() - 1);
    }


    // ----------------------------------------------------------
    /**
     * Gets the item at the top of the stack.
     *
     * @return the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T top()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.get(array.size() - 1);
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    public int size()
    {
        return array.size();
    }


    // ----------------------------------------------------------
    /**
     * Gets a value indicating whether the stack is empty.
     *
     * @return true if the stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        return array.size() == 0;
    }
}
