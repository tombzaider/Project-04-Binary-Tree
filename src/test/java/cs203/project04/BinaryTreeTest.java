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
import java.util.NoSuchElementException;
import cs203.battlearena.objectmon.Objectmon;
import cs203.battlearena.Named;
import cs203.battlearena.ObjectmonNameGenerator;





public class BinaryTreeTest {
    private Tree<Integer> emptyTree;
    private Tree<Integer> testTree;
    private Integer test1;
    private Integer test2;
    private Integer test3;
    private Integer test4;
    private Integer test5;
    private Integer test6;
    private Integer test7;
    private Integer test8;
    private Integer test9;
    private Integer test10;
    private Random r;
    private Comparator<Integer> comptest=new IntegerComparator();
    private TreeSet<Integer> realTree;
    private Objectmon o1;
    private Objectmon o2;
    private Objectmon o3;
    private Objectmon o4;

    @Before public void init(){
        emptyTree=new BinaryTree<>(comptest);
        testTree=new BinaryTree<>(comptest);
        realTree=new TreeSet<>(comptest);
        test1=new Integer(13);
        test2=new Integer(65);
        test3=new Integer(95);
        test4= new Integer(-11);
        test5 = new Integer(33);
        test6=new Integer(65);
        test7=new Integer(10);
        test8=new Integer(9);
        test9=new Integer(999);
        test10=new Integer(-100);
        o1=new Objectmon(ObjectmonNameGenerator.nextName());
        o2=new Objectmon(ObjectmonNameGenerator.nextName());
        o3=new Objectmon(ObjectmonNameGenerator.nextName());
        o4=new Objectmon(ObjectmonNameGenerator.nextName());


        r=new Random();
        
        testTree.insert(test1);
        testTree.insert(test2);
        testTree.insert(test7);
        testTree.insert(test4);
        testTree.insert(test3);
        
        realTree.add(test1);
        realTree.add(test2);
        realTree.add(test7);
        realTree.add(test4);
        realTree.add(test3);
         
        
    }

    @Test public void clearTest() {
        testTree.clear();
        assert(testTree.isEmpty());
    }




    @Test public void isEmptyTest() {
        assertTrue(emptyTree.isEmpty());
        assertTrue(testTree.isEmpty()==false);
        testTree.clear();
        assertTrue(testTree.isEmpty());
    }

    @Test public void insertTest() {
        assert(testTree.insert(test5));
        assert(testTree.insert(test9));
        assert(testTree.insert(test8));
        assert(testTree.insert(test10));
        assert(testTree.insert(test3));
        
    }

    @Test public void containsTest() {
        assertTrue(emptyTree.contains(test1)==false);
        assertTrue(testTree.contains(test1));
        assertTrue(testTree.contains(test2));
        assertTrue(testTree.contains(test10)==false);


    }

    @Test public void sizeTester() {
        assertEquals(5, testTree.size());
        testTree.insert(test3);
        assert(testTree.size()!=5);
        assertEquals(6, testTree.size());
        testTree.clear();
        assertEquals(emptyTree.size(),0);
        assertEquals(testTree.size(),0);        
    }

    @Test(expected=NoSuchElementException.class) 
     public void firstTester() {
        assertEquals(test4, testTree.first());
        testTree.insert(test10);
        assertEquals(test10,testTree.first());
        emptyTree.first();
    }

    @Test(expected=NoSuchElementException.class) 
     public void lastTester() {
        assertEquals(test3, testTree.last());
        testTree.insert(test9);
        assertEquals(test9,testTree.last());
        emptyTree.last();
    }

    @Test public void higherTester() {
        assertEquals(realTree.higher(new Integer(54)),testTree.higher(new Integer(54)));
        testTree.insert(test9); realTree.add(test9);
        assertEquals(realTree.higher(new Integer(1000)),testTree.higher(new Integer(1000)));
        for (int i=0;i<70;i++) {
            Integer p= new Integer(r.nextInt());
            testTree.insert(p); realTree.add(p);

        }

        assertEquals(realTree.higher(new Integer(111)),testTree.higher(new Integer(111)));


    }
    @Test public void lowerTester() {
        assertEquals(realTree.lower(new Integer(54)),testTree.lower(new Integer(54)));
        testTree.insert(test9); realTree.add(test9);
        assertEquals(realTree.lower(new Integer(1000)),testTree.lower(new Integer(1000)));
        assertNull(testTree.lower(-1000000));

        for (int i=0;i<70;i++) {
            Integer p= new Integer(r.nextInt());
            testTree.insert(p); realTree.add(p);

        }


        assertEquals(realTree.lower(new Integer(213)),testTree.lower(new Integer(213)));


    }

    @Test public void namedTester() {
        BinaryTree<Named> p= new BinaryTree<>(new NamedComparator<>());
        assert(p.insert(o1)); assert(p.insert(o2)); assert(p.insert(o3)); assert(p.insert(o4));

    }

    @Test public void HPTester()
 {
        BinaryTree<Objectmon> p= new BinaryTree<>(new ObjectmonHPComparator<>());
        assert(p.insert(o1)); assert(p.insert(o2)); assert(p.insert(o3)); assert(p.insert(o4));

    
 }

    @Test public void StaminaTester()
 {
        BinaryTree<Objectmon> p= new BinaryTree<>(new ObjectmonStaminaComparator<>());
        assert(p.insert(o1)); assert(p.insert(o2)); assert(p.insert(o3)); assert(p.insert(o4));

    
 }  
}
