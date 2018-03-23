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
@SuppressWarnings("serial")
public class NotInAcademicProbationException extends RuntimeException {

    /**
     * 
     */
    public NotInAcademicProbationException() {
        super();
    }

    /**
     * @param message for the user
     */
    public NotInAcademicProbationException(String message) {
        super(message);
    }
}
