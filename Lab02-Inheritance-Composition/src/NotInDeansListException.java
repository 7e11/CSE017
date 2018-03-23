/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */

//We don't care about serialization for this project.
//Adding a UID would just complicate things.
@SuppressWarnings({ "serial" })
public class NotInDeansListException extends RuntimeException {
    
    /**
     * 
     */
    public NotInDeansListException() {
        super();
    }

    /**
     * @param arg0 message for the user
     */
    public NotInDeansListException(String arg0) {
        super(arg0);
    }
}
