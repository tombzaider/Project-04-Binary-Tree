package cs203.project04;
import java.util.Comparator;
import java.lang.Integer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import java.util.*;
import cs203.battlearena.util.TreeNode;
import cs203.battlearena.util.Tree;

public class BinaryTreeNodeTest{
    Integer i= new Integer(1);
    Integer o= new Integer(2);
    BinaryTreeNode<Integer> p;
     @Before public void init() {

    i=new Integer(1);
    o=new Integer(2);
    p=new BinaryTreeNode<>(i);
    p.setRight(new BinaryTreeNode<>(o));

     }

     @Test public void setTest() {
         assert((p.getRight().getData()).equals(o));
     }
}