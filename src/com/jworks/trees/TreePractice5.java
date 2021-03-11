package com.jworks.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Johnpaul Chukwu.
 * @since 11/03/2021
 */

public class TreePractice5 {

/*

   Given the root of a binary tree, imagine yourself standing on the right side of it,
   return the values of the nodes you can see ordered from top to bottom.

   Input: root = [1,2,3,null,5,null,4]
    Output: [1,3,4]

    Approach Taken:
    So in order to get the right most node at every level, we would traverse the tree in a BFS manner.
    By so doing at each level we would get the right most child.

    1. Initialize our Queue QU with root element
    2. Initialize empty result array RESULT
    3. While QU is not empty:
       i. get the size of QU as SIZE_QU
       ii.initialize COUNTER to 0
       iii. COUNTER < DO SIZE_QU:
        a. Dequeue QU and get node as CURRENT
        b. if SIZE_QU - 1 == COUNTER  then add value of CURRENT to RESULT
        c. if left node of CURRENT LNC is not null then add LNC to QU
        d. if right node of CURRENT RNC is not null then add RNC to QU
        e. increment COUNTER by 1
     4. Return RESULT
*
* */

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if(i == 0) result.add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right!= null) queue.offer(current.right);
            }
        }

        return result;
    }
}
