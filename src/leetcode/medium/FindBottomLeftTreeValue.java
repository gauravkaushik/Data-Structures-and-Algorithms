package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/find-bottom-left-tree-value/
========================================================================

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1


Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

*/

public class FindBottomLeftTreeValue {
    
    private class Result
    {
        
        int val;
        int level;
        
        Result()
        {
            val=0;
            level=0;
        }        
    }
    
    public int findBottomLeftValue(TreeNode root) {        
        
        Result res = new Result();
        helper(root, 1, res);
        return res.val;
    }
    
    private void helper(TreeNode root, int curLevel, Result res)
    {
        if(root == null)
            return;
        
        if(curLevel > res.level)
        {
            res.level = curLevel;
            res.val = root.val;
        }
        
        helper(root.left, curLevel + 1, res);
        helper(root.right, curLevel + 1, res);
        
    }
    
    /*
    https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98802/Simple-Java-Solution-beats-100.0! : Uses array of size 2 instead of creating a Result object to pass by value
       
    public class Solution {
        public int findBottomLeftValue(TreeNode root) {
            return findBottomLeftValue(root, 1, new int[]{0,0});
        }
        public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
            if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
            if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
            if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
            return res[0];
        }
    }
       
    */
}