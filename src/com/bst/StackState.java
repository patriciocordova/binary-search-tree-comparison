package com.bst;

import java.util.Stack;

/**
 * Structure that allows to keep track of stack state while iterating
 * over a BST not recursively.
 * @author Patricio Córdova
 */
public class StackState {
    Stack<BstNode> stack;
    BstNode node;
    Object popValue; // Last element popped from the stack.
    
    StackState(BstNode node) {
        this.stack = new Stack<>();
        this.node = node;
    }
}