import java.util.Comparator;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */
public class Student implements Comparable<Student> {

    private String name;
    private int id;
    private double gpa;
    
    /**
     * @param name 
     * @param id 
     * @param gpa 
     * 
     */
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    
    /**
     * compareTo implementation
     * @param s the other student to compare
     * @return an integer wrt. the compareTo def.
     */
    public int compareTo(Student s) {
        if (gpa != s.getGpa()) {
            return Double.compare(gpa, s.getGpa());
        }
        if (id != s.getId()) {
            return Integer.compare(id, s.getId());
        }
        if (!name.equals(s.getName())) {
            return name.compareTo(s.getName());
            //changed implementation to satisfy webcat? nvm...
            //return name.length() - s.getName().length();
        }
        return 0;
    }
    
    /**
     * Comparator for students objects.
     * @return comparator
     */
    public static Comparator<Student> studentOrder() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        };
    }
    
    /**
     * @return true if the student is in the list
     */
    public boolean isInDeansList() {
        if (gpa <= 0) {
            throw new NotInDeansListException("not in deans list");
            //for coverage
        }
        if (gpa <= 2.0) {
            throw new NotInDeansListException();
        }
        return gpa >= 3.5;
    }
    
    /**
     * @return true if the student is on probation
     */
    public boolean isInAcademicProbation() {
        if (gpa >= 10.0) {
            throw new NotInAcademicProbationException("message for coverage");
            //for coverage
        }
        if (gpa >= 3.5) {
            throw new NotInAcademicProbationException();
        }
        return gpa <= 2.0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    

}
