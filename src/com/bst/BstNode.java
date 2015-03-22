package com.bst;

import java.util.List;

/**
 * Binary Search Tree implementation.
 *
 * @author Patricio Córdova
 */
class BstNode {

    Object value;
    BstNode left;
    BstNode right;

    BstNode(Object value) {
        this.value = value;
    }

   /**********************************************************************
    * BST content comparison
    **********************************************************************/
    /**
     * Compares if current and roots BST have exactly the same content. It does
     * by iterating in-order over both trees and creating an stack of nodes.
     * Once an element is popped from the stack of the first tree -the tree that
     * invoked the method-, we proceed to iterate and generate the stack of the
     * second tree until the second element is popped. To verify our premise
     * that both trees are BST and have the same content we compare the two
     * elements obtained. If both elements are equals this means that at least
     * until that point the trees have the same content and are in order so we
     * can continue; otherwise we return false. We iterate both trees until we
     * have completely traversed them.
     *
     * @param root BST root node to compare against this node
     * @return true if both trees have the same content, false otherwise
     */
    public boolean hasSameContents(BstNode root) {
        if (this.value == null && root.value == null) {
            return true;
        }
        StackState ss1 = new StackState(this); // 1 refers to the current node
        StackState ss2 = new StackState(root); // 2 refers to the node that we are comparing against
        while ((!ss1.stack.empty() || ss1.node != null) || (!ss2.stack.empty() || ss2.node != null)) {
            ss1 = stackAndPop(ss1);
            ss2 = stackAndPop(ss2);
            //System.out.println(ss1.popValue + " " + ss2.popValue); // Uncomment to see every comparison
            if (ss1.popValue == null || ss2.popValue == null || ss1.popValue.compareTo(ss2.popValue) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stacks nodes that are not in-order and returns when the next node in
     * order is popped. As the method used to traverse a BST in-order in this
     * exercise is an iterative method -instead of recursion-, it depends on a
     * stack that keeps the nodes visited. To be able to use this method to
     * traverse both trees simultaneously we need to keep track of the state of
     * every stack, that is why we use the StackState structure.
     *
     * @param StackState current tree stack state
     * @return modified state of current tree stack state
     */
    private StackState stackAndPop(StackState current) {
        current.popValue = null;
        while (!current.stack.empty() || current.node != null) {
            if (current.node != null) {
                current.stack.push(current.node);
                current.node = current.node.left;
            } else {
                BstNode pop = current.stack.pop();
                current.popValue = pop.value;
                current.node = pop.right;
                break;
            }
        }
        return current;
    }

   /**********************************************************************
    * Add value to BST node.
    **********************************************************************/
    public static BstNode add(BstNode node, Object value) {
        if (node == null) {
            return new BstNode(value);
        }
        if (node.value.compareTo(value) > 0) {
            node.left = add(node.left, value);
        } else {
            node.right = add(node.right, value);
        }
        return node;
    }

   /*********************************************************************
    * Traverse and print in-order.
    *********************************************************************/
    public static void print(BstNode node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.println(node.value);
        print(node.right);
    }

   /*********************************************************************
    * Create BST from int[] and List<Integer>
    *********************************************************************/
    public static BstNode createBst(int[] array) {
        if (array.length == 0) {
            return new BstNode(null);
        }
        BstNode tree = null;
        for (int i = 0; i < array.length; i++) {
            tree = BstNode.add(tree, new Object(array[i]));
        }
        return tree;
    }

    public static BstNode createBst(List<Integer> array) {
        if (array.isEmpty()) {
            return new BstNode(null);
        }
        BstNode tree = null;
        for (Integer element : array) {
            tree = BstNode.add(tree, new Object(element));
        }
        return tree;
    }
}
