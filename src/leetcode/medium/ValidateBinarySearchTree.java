package leetcode.medium;
/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/validate-binary-search-tree/
=========================================================================
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    boolean isValid(TreeNode root, int low, int high)
    {
        if(root == null)
            return true;
        if(root.val<low || root.val>high)
            return false;
        
        //handle special cases directly to avoid integer overflow
        if(root.left!=null && root.val==Integer.MIN_VALUE)
            return false;
        if(root.right!=null && root.val==Integer.MAX_VALUE)
            return false;
        
        
        return isValid(root.left, low, root.val-1) && isValid(root.right, root.val+1, high);
    }
}