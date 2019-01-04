package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
========================================================================

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/

  
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if( nums == null || nums.length == 0 )
            return null;
        
        return helper( nums, 0, nums.length-1 );
    }
    
    private TreeNode helper(int[] nums, int low, int high)
    {
        if( low > high )
            return null;
        int mid = ( low + high ) / 2;
        TreeNode root = new TreeNode( nums[mid] );
        if( low == high )
            return root;
        root.left = helper( nums, low, mid-1 );
        root.right = helper( nums, mid+1, high );
        return root;
        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}