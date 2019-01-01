package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/path-sum-iii/
========================================================================
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

public class PathSumIII {   
    
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
    public int pathSum(TreeNode root, int sum) {
        return inorder(root, sum);
    }
    
    public int inorder(TreeNode root, int target)
    {
        if(root == null)
            return 0;
        
        return pathSum(root, 0, target) + inorder(root.left, target) + inorder(root.right, target);
    }
    
    public int pathSum(TreeNode root, int cur_sum, int target) {
        
        if(root == null)
            return 0;
        
        int count = 0;
        if(root.val + cur_sum == target)
            count++;
        
        //assume root is present in path
        count += pathSum(root.left, cur_sum + root.val, target);
        count += pathSum(root.right, cur_sum + root.val, target);
        
        return count;        
    }
    
}