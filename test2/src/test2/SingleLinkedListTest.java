/**
 * 
 */
package test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Evan Hruskar
 * @version 2018.04.09
 *
 */
class SingleLinkedListTest {

    SingleLinkedList<String> list;
    SingleLinkedList<String> list2;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        String[] data = {"A", "B", "C", "D", "E"};
        String[] data2 = {"A", "B", "C", "D"};
        list = new SingleLinkedList<String>(data2);
        //System.out.println(list.toString());
    }

    /**
     * Test method for {@link test2.SingleLinkedList#divideInHalf()}.
     */
    @Test
    void testDivideInHalf() {
        list2 = list.divideInHalf();
        System.out.println(list); //AB
        System.out.println(list2); //CDE
        //Okay, so I screwed up the center split,
        //but otherwise the code functions just fine...
        
        //however, the middle split is really screwed up...
        //It will either cut correctly, or overcut.
        //This is fixed via 
        //if (size % 2 != 0) {half = half + 1;}
        //assuming a variable half is devined which is equal to size/2
    }

}
