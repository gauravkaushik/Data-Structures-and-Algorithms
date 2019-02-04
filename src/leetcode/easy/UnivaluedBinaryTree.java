package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/univalued-binary-tree/
========================================================================

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:
Input: [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: [2,2,2,5,2]
Output: false
 

Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].


*/
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        int result = helper(root);
        return result==-1 ? false : true;
    }
    
    private int helper(TreeNode root)
    {
        if(root == null)
            return -2;
        
        if(root.left == null && root.right==null)
            return root.val;  
        
        int left = helper(root.left);
        int right = helper(root.right);      
        
        //either subtree is not univalued
        if(left==-1 || right==-1)
            return -1;
        
        if(left==-2 || right==-2)
        {
            //do nothing
        }        
        else if(left!=right) ////both subtree have same value
            return -1;        
        
        //root value is same as both subtree
        if(left!=-2 && left!=root.val)
            return -1;
        else if(right!=-2 && right!=root.val)
            return -1;
        
        return left!=-2?left:right;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

/*
A much cleaner version from https://leetcode.com/problems/univalued-binary-tree/solution/ :
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
*/
