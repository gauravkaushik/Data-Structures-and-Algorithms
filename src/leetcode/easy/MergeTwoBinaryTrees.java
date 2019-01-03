package leetcode.easy;

import java.util.Stack;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/merge-two-binary-trees/
========================================================================

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.
*/


public class MergeTwoBinaryTrees {
    public TreeNode mergeTreesRecursion(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null)
            return null;
        if(t1==null || t2==null)
            return (t1!=null?t1:t2);
        t1.val += t2.val;
        
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    
    //iterative approach
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        Stack< TreeNode[] > stk = new Stack<>();
        
        stk.push(new TreeNode[] {t1,t2});
        
        while(!stk.isEmpty())
        {
            TreeNode[] tNodes = stk.pop();
            TreeNode tree1 = tNodes[0];
            TreeNode tree2 = tNodes[1];
            
            if(tree1==null)
                return tree2;
            if(tree2==null)
                continue;
            tree1.val += tree2.val;
            if(tree1.left == null)
                tree1.left = tree2.left;
            else
                stk.push(new TreeNode[]{tree1.left, tree2.left});
            if(tree1.right == null)
                tree1.right = tree2.right;
            else
                stk.push(new TreeNode[]{tree1.right, tree2.right});            
        }
        
        return t1;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}