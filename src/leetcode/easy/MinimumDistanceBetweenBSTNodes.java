package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/minimum-distance-between-bst-nodes/
========================================================================

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

Note:
The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
*/

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        
        //result[0] -> min difference till now
        //result[1] -> inorder predecessor
        Integer[] result = {Integer.MAX_VALUE, null};  
        
        helper(root, result);
        return result[0];        
    }
    
    private void helper(TreeNode root, Integer[] result)
    {        
        if(root == null)
            return;
        
        helper(root.left, result);        
        
        if(result[1]!=null)
        {
            result[0] = Math.min(result[0], Math.abs(result[1] - root.val));               
        }
        result[1] = root.val;
        
        helper(root.right, result);
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}