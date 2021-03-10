package com.jworks.trees;

import java.util.Stack;

public class TreePractice3 {

/*    Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

    Approach Taken (flattenTreeUsingStack):

    1. We initialize, and push root node in.
    2. Go through the stack while not empty:
        i. Set the currentNode = to the top of the stack
        ii. push the right child of current , as far as it is not null
        iii. push the left child,  as far as it is not null
        iv. if the stack is not empty -> right child of current node = top of the stack
        v. set the left child to null;

      Time complex: O(n) and Space Complex: 0(n)
    */


    public void flattenTreeUsingStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        while (!treeNodeStack.isEmpty()){

            TreeNode currentNode = treeNodeStack.pop();

            if(currentNode.right != null) treeNodeStack.push(currentNode.right);

            if(currentNode.left != null) treeNodeStack.push(currentNode.left);

            if(!treeNodeStack.isEmpty()) currentNode.right = treeNodeStack.peek();

            currentNode.left = null;
        }

    }

}
