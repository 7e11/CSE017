/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.12
 *
 */
public class Expressions {

    private static BinaryTree<String> expression;

    /**
     * @param args we're not passing args don't worry.
     */
    public static void main(String[] args) {
        expression = new BinaryTree<String>("*");
        BinaryTree<String> left = new BinaryTree<String>("-");
        left.setLeft(new BinaryTree<String>("a"));
        left.setRight(new BinaryTree<String>("b"));
        BinaryTree<String> right = new BinaryTree<String>("/");
        right.setRight(new BinaryTree<String>("e"));
        BinaryTree<String> cd = new BinaryTree<String>("+");
        cd.setLeft(new BinaryTree<String>("c"));
        cd.setRight(new BinaryTree<String>("d"));
        right.setLeft(cd);
        expression.setLeft(left);
        expression.setRight(right);
        
        System.out.println(expression.toPreOrderString());
        System.out.println(expression.toInOrderString());
        System.out.println(expression.toPostOrderString());
        
    }

}
