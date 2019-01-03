package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
========================================================================

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/


public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        compute(ans, root, 0, true);
        
        return ans;
    }
    
    void compute(List<List<Integer>> ans, TreeNode root, int level, boolean flag)
    {
        if(root == null)
            return;
        
        if(ans.size() == level)
            ans.add( new LinkedList<>() );
        
        if(flag)
            ((LinkedList)ans.get(level)).addLast(root.val);
        else
            ((LinkedList)ans.get(level)).addFirst(root.val);
        
        compute(ans, root.left, level+1, !flag);
        compute(ans, root.right, level+1, !flag);
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}