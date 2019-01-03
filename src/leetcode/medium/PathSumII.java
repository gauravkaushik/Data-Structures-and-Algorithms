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
https://leetcode.com/problems/path-sum-ii/
========================================================================

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null)
            return paths;
        
        if(root.left==null && root.right==null)
        {
            if(root.val != sum)
                return paths;
            else
            {
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                paths.add(path);
                return paths;
            }
        }
        else
        {
            List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val);
            List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val);
            if(leftPaths!=null && leftPaths.size()!=0)
            {
                for(List<Integer> path : leftPaths)
                    paths.add(path);
            }
            if(rightPaths!=null && rightPaths.size()!=0)
            {
                for(List<Integer> path : rightPaths)
                    paths.add(path);
            }
            for(int i=0; i<paths.size(); i++)
            {
                ((LinkedList)paths.get(i)).addFirst(root.val);
            }
            return paths;
        }
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}