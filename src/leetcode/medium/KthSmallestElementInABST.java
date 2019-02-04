package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
========================================================================

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 <= k <= BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = {0,0};
        helper(root, k, temp);
        return temp[1];
    }
    
    private void helper(TreeNode root, int k, int[] temp)
    {
        if(root==null)
            return;
        helper(root.left, k, temp);
        temp[0]++;
        if(temp[0] == k)
        {
            temp[1] = root.val;
            return;
        }
        helper(root.right, k, temp);        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}