package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/average-of-levels-in-binary-tree/
========================================================================

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7

Output: [3, 14.5, 11]

Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:
The range of node's value is in the range of 32-bit signed integer.

*/

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        //do level order traversal
        List<Double> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int size;
        int count;
        double sum;
        TreeNode temp = null;
        while(!q.isEmpty())
        {
            size = q.size();
            count = size;
            sum = 0;
            while(size-- > 0)
            {
                temp = q.poll();
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
                sum += temp.val;
            }
            result.add(sum/count);
        }
        
        return result;
        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}