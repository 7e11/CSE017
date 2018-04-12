import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.12
 *
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<Integer> tree;
    private BinaryTree<Integer> left;
    private BinaryTree<Integer> right;
    private BinaryTree<Integer> unbalanced;
    /**
     * 
     */
    @Before
    public void setUp() throws Exception {
        left = new BinaryTree<Integer>(2);
        right = new BinaryTree<Integer>(3);
        tree = new BinaryTree<Integer>(1, left, right);
        unbalanced = new BinaryTree<Integer>(1, left, null);
    }

    /**
     * Test method for {@link BinaryTree#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(3, tree.size());
        assertEquals(1, left.size());
        assertEquals(1, right.size());
        assertEquals(2, unbalanced.size());
        tree.setLeft(null);
        tree.setRight(null);
        tree.setElement(0);
        assertEquals(1, tree.size());
    }

    /**
     * Test method for {@link BinaryTree#height()}.
     */
    @Test
    public void testHeight() {
        assertEquals(2, tree.height());
        assertEquals(1, left.height());
        assertEquals(2, unbalanced.height());
    }

    /**
     * Test method for {@link BinaryTree#clone()}.
     */
    @Test
    public void testClone() {
        BinaryTree<Integer> clone = tree.clone();
        assertNotNull(clone.getElement());
        assertNotNull(clone.getLeft().getElement());
        assertNotNull(clone.getRight().getElement());
    }

    /**
     * Test method for {@link BinaryTree#toPreOrderString()}.
     */
    @Test
    public void testToPreOrderString() {
        assertEquals("(1 (2) (3))", tree.toPreOrderString());
        assertEquals("(2)", left.toPreOrderString());
    }

    /**
     * Test method for {@link BinaryTree#toInOrderString()}.
     */
    @Test
    public void testToInOrderString() {
        assertEquals("((2) 1 (3))", tree.toInOrderString());
        assertEquals("(2)", left.toInOrderString());
    }

    /**
     * Test method for {@link BinaryTree#toPostOrderString()}.
     */
    @Test
    public void testToPostOrderString() {
        assertEquals("((2) (3) 1)", tree.toPostOrderString());
        assertEquals("(2)", left.toPostOrderString());
    }
}
