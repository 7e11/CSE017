//-------------------------------------------------------------------------
/**
 * Represents one event in a historical timeline.
 *
 * @author  Stephen Edwards
 * @version 2010.11.10
 */
public class HistoricEvent implements Comparable<HistoricEvent>
{
    //~ Instance/static variables .............................................

    private int year;
    private String title;
    private String description;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new HistoricEvent without a description.
     * @param year The year the event occurred (A.D.)
     * @param title The title of the event
     */
    public HistoricEvent(int year, String title)
    {
        this(year, title, null);
    }


    // ----------------------------------------------------------
    /**
     * Create a new HistoricEvent.
     * @param year The year the event occurred (A.D.)
     * @param title The title of the event
     * @param description The description for the event
     */
    public HistoricEvent(int year, String title, String description)
    {
        //having an assertion here is bad style.
        //should be an exception instead.
        //assert title != null : "The title cannot be null";
        if (title == null)
        {
            throw new IllegalArgumentException(
                "The title cannot be null");
        }

        this.year        = year;
        this.title       = title;
        this.description = description;
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Get this event's year.
     * @return This event's year.
     */
    public int getYear()
    {
        return year;
    }


    // ----------------------------------------------------------
    /**
     * Get this event's title.
     * @return This event's title, which may be null.
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Get this event's description.
     * @return This event's description, which may be null.
     */
    public String getDescription()
    {
        return description;
    }


    // ----------------------------------------------------------
    /**
     * Generate a human-readable representation of this event.
     * @return This event in string form.
     */
    public String toString()
    {
        // When concatenating many strings to produce a result, it is more
        // efficient to use a string builder, rather than using '+' on strings.
        StringBuilder result = new StringBuilder();

        result.append('[');
        result.append(year);
        result.append("] ");
        result.append(title);
        if (description != null)
        {
            result.append(": ");
            result.append(description);
        }
        return result.toString();
    }

    /**
     * Compares this object with the specified other object for order
     * 
     * @return a negative integer, zero, or a positive integer to 
     * indicate that this object is less than, equal to, or greater
     * than the specified object, respectively.
     * @param e another historic event to compare to.
     */
    public int compareTo(HistoricEvent e) {
        if (year != e.getYear()) {
            return year - e.getYear();
        }
        return title.compareTo(e.getTitle());
    }
    
}
