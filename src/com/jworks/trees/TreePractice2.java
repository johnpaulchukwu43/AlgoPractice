package com.jworks.trees;

import java.util.HashMap;

public class TreePractice2 {

/*    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
      and inorder is the inorder traversal of the same tree, construct and return the binary tree.

      Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
      Output: [3,9,20,null,null,15,7]
 */
    private HashMap<Integer,Integer> inOrderMap;

    private int preOrderIndex = 0;
    private int[] preOrderArray;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preOrderArray = preorder;

        inOrderMap =  new HashMap<>();

        for (int i = 0; i<inorder.length;i++){
            inOrderMap.put(i,inorder[i]);
        }

        return helper(0,inorder.length);
    }


    private TreeNode helper(int leftPos,int rightPos){

        if(leftPos == rightPos ) return null;

        //get root value from preorder array.
        int rootValue = preOrderArray[preOrderIndex];
        //initialize our node with root value
        TreeNode treeNode = new TreeNode(rootValue);

        //To find left and right sub trees for root node created.
        // check the inOrderMap for the index
        int rootIndex = inOrderMap.get(rootValue);

        preOrderIndex++;

        //with Index found, recursively split array into left and right sub trees.
        treeNode.left = helper(leftPos,rootIndex);
        treeNode.right = helper(rootIndex+1,rightPos);

        return treeNode;
    }

}
