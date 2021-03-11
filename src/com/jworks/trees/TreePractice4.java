package com.jworks.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreePractice4 {

    /*
        Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
    */

    public int kthSmallest(TreeNode root, int k) {

        return findKthSmallestIterativeApproach(root,k);
    }


    private int findKthSmallestRecursiveApproach(TreeNode root, int k){
        /*
        * In this approach, we traverse the tree in an inorder manner .i.e. that is visit left , root, and then right node.
        * For any node we visit, we add to our array list.
        * After visiting all nodes, we would have the array list sorted in ascending order, so we just find the k-1 index in the array.
        * */
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k-1);
    }


    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return arr;

        inorder(root.left,arr);

        arr.add(root.val);

        inorder(root.right,arr);

        return arr;
    }

    private int findKthSmallestIterativeApproach(TreeNode root, int k){
        /*
         * In this approach, we traverse the tree in an inorder manner too .i.e. that is visit left , root, and then right node.
         * But here we make use of a stack, that way we can stop traversing after kth element.
         * 1. We initialize our stack
         * 2. while the root node is not null:
         *      i. we add the element to stack
         *      ii. get the left child of the root element
         *
         * 3. So at this point we have traversed to the left most root. so time to go back up. we do that by popping the node from stack
         * 4. We check if K-1 equal to 0 then return return value of current node
         * 5. Else, we get the right child of the node
         *
         * TimeComplex -> O(logN+k) for the balanced tree and O(N + k) for completely unbalanced tree with all the nodes in the left subtree.
         *
         * Space complexity: O(H) to keep the stack, where HH is a tree height. That makes O(N) in the worst case of the skewed tree, and O(logN) in the average case of the balanced tree
         * */

        Stack<TreeNode> stack = new Stack<>();

        while (true){
            while (root !=null){
                stack.push(root);
                root = root.left;
            }

            TreeNode currentNode = stack.pop();

            if(--k == 0) return currentNode.val;

            root = currentNode.right;
        }

    }


}
