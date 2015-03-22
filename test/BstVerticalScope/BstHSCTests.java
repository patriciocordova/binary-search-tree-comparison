package BstVerticalScope;

import com.bst.BstNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for "hasSameContents" method. Includes test to stress the algorithm
 * comparing two trees of 1'000,000 random numbers each.
 * @author Patricio Córdova
 */
public class BstHSCTests {
    int[] arr1;
    int[] arr2;
    List<Integer> arrL1;
    List<Integer> arrL2;
    BstNode tree1;
    BstNode tree2;
    boolean expected;
    boolean actual;
    
    public BstHSCTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEmptyArray() {
        arr1 = new int[]{};
        arr2 = new int[]{};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testOneArrayIsEmpty() {
        arr1 = new int[]{};
        arr2 = new int[]{12};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{};
        arr2 = new int[]{18,24,0,2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{18,24,0,2};
        arr2 = new int[]{};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testOneElementArrays() {
        arr1 = new int[]{12};
        arr2 = new int[]{12};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{12};
        arr2 = new int[]{18};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testInterchangedValues() {
        arr1 = new int[]{2,7,89,7,76,5,10,1,7};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{7,7,7,7,7};
        arr2 = new int[]{7,7,7,7,7};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{1,2,3,4,5,6,7};
        arr2 = new int[]{1,2,3,4,5,6,7};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{7,6,5,4,3,2,1};
        arr2 = new int[]{7,6,5,4,3,2,1};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{1,2,3,4,5,6,7};
        arr2 = new int[]{7,6,5,4,3,2,1};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{1,2,3,4,5,6,7};
        arr2 = new int[]{7,2,5,4,3,6,1};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMoreValues() {
        arr1 = new int[]{2,7,89,7,76,5,10,1,7};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2,91};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{2,7,89,7,76,5,10,1,7};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2,1};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{2,7,89,7,76,5,10,1,7,1};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{2,7,89,7,76,5,10,1,7,1,7,8,8};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{2,7,89,7,76,5,10,1,7};
        arr2 = new int[]{7,7,7,76,89,5,10,1,2,1,7,8,8};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNegatives() {
        arr1 = new int[]{-2,-7,-89,-7,-76,-5,-10,-1,-7};
        arr2 = new int[]{-7,-7,-7,-76,-89,-5,-10,-1,-2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{-7,-7,-7,-7,-7,-7,-7};
        arr2 = new int[]{-7,-7,-7,-7,-7,-7,-7};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{-1,-2,-3,-4,-5,-6,-7};
        arr2 = new int[]{-1,-2,-3,-4,-5,-6,-7};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{-1,-2,-3,-4,-5,-6,-7};
        arr2 = new int[]{-7,-6,-5,-4,-3,-2,-1};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{-2,7,89,-7,76,-5,10,1,-7,1,-7,8,8};
        arr2 = new int[]{-7,-7,-7,76,89,-5,10,1,-2};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
        
        arr1 = new int[]{-2,-7,-89,-7,-76,-5,-10,-1,-7};
        arr2 = new int[]{-7,-7,-7,-76,-89,-5,-10,-1,-2,-1,-7,-8,-8};
        tree1 = BstNode.createBst(arr1);
        tree2 = BstNode.createBst(arr2);
        expected = false;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testStress() {
        arrL1 = createBigArrayList(1000000);
        arrL2 = reverseList(arrL1);
        tree1 = BstNode.createBst(arrL1);
        tree2 = BstNode.createBst(arrL2);
        expected = true;
        actual = tree1.hasSameContents(tree2);
        assertEquals(expected, actual);
    }
    
    public static ArrayList<Integer> createBigArrayList(int size) {
        Random rand = new Random();
        ArrayList<Integer> randomElements = new ArrayList<>();
        for(int i=0;i<size;i++){
            randomElements.add(rand.nextInt());
        }
        return randomElements;
    }
    
    public static ArrayList<Integer> reverseList(List<Integer> list) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            int temp = list.get(i);
            reverse.add(temp);
        }
        return reverse;
    }
}
