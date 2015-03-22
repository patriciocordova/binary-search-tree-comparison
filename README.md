# BST Comparison

## Problem:

Assume we have the following small class, representing a node in an *ordered* binary tree:
```
class BstNode {
  Object value;
  BstNode left;
  BstNode right;
}
```
(By "ordered" binary tree, I mean they have the Binary Search Tree property, where the value/contents of the left child is smaller than the value of the current node, which is smaller than the value of the right child.  We can assume that someone else is creating/assembling these binary trees in such a manner.)

We'd like to you please add a method with a signature like the following:
```
boolean hasSameContents(BstNode root)
```
This method should return true iff the tree rooted at "root" has the same contents as the tree rooted at the BstNode on which this method is called.  Two two trees need to have the same contents/values, but don't necessarily have to have the same structure.

## Solution:

We compare if two Binary Search Trees have exactly the same content by iterating in-order over both trees and creating an stack of nodes. Once an element is popped from the stack of the first tree -the tree that invoked the method-, we proceed to iterate and generate the stack of the  second tree until the second element is popped.

To verify our premise that both trees are BST and have the same content we compare each two elements popped. If both elements are equals this means that at least until that point, the trees have the same content and are in order so we can continue; otherwise we return false. We iterate both trees until we have completely traversed them.
