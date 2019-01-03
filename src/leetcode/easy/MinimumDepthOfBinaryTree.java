package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/minimum-depth-of-binary-tree/
========================================================================

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
*/

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        //leaf node
        if(root.left==null && root.right==null)
            return 1;
        
        //has only one child
        if(root.left==null || root.right==null)
            return 1 + ( root.left!=null ? minDepth(root.left) : minDepth(root.right) );
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}