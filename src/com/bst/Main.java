package com.bst;

/**
 * @author Patricio Córdova
 */
public class Main {

    public static void main(String[] args) {
        int[] arr1 = new int[]{-2,7,-89,7,76,5,10,1,7,89};
        int[] arr2 = new int[]{7,7,7,76,-89,5,10,1,-2,89};
        BstNode tree1 = BstNode.createBst(arr1);
        BstNode tree2 = BstNode.createBst(arr2);
        System.out.println("Result: "+tree1.hasSameContents(tree2));
    }
    
}
