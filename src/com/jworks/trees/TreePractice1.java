package com.jworks.trees;

/**
 * @author Johnpaul Chukwu.
 * @since 06/03/2021
 */

/*
        Given the root of a binary tree, determine if it is a valid binary search tree (BST).

        A valid BST is defined as follows:
        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
*/

public class TreePractice1 {

    Integer prevValue = null;

    public boolean BFSApproachForIsValidBST(TreeNode node, Integer low, Integer high) {

        if(node == null) return true;

        if ((low != null && node.val <= low) || (high!= null && node.val >= high)){
            return false;
        }

        return BFSApproachForIsValidBST(node.left,low,node.val) && BFSApproachForIsValidBST(node.right,node.val,high);
    }


    public boolean InorderDFSApproachForIsValidBST(TreeNode currentRoot){

        if(currentRoot == null) return true;

        if(!InorderDFSApproachForIsValidBST(currentRoot.left)){
            return false;
        }

        if(prevValue != null && currentRoot.val <= prevValue) return false;

        return InorderDFSApproachForIsValidBST(currentRoot.right);

    }}
