package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/unique-binary-search-trees-ii/
========================================================================

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {     
        if(n==0)
            return new ArrayList<TreeNode>();
        return helper(1,n);        
    }    
    
    List<TreeNode> helper(int low, int high)
    {
        List<TreeNode> allTrees = new ArrayList<>();
        
        if(low > high)
        {
            allTrees.add(null); //Trick : Null will be counted as one element in the for each loop
        }        
        else if(low == high)                    
            allTrees.add(new TreeNode(low));                    
        else
        {
           for(int j=low; j<=high; j++)
            {  
                List<TreeNode> leftTrees = helper(low,j-1);
                List<TreeNode> rightTrees = helper(j+1,high);
                for(TreeNode l : leftTrees)
                {
                    for(TreeNode r : rightTrees)
                    {
                        TreeNode root = new TreeNode(j);
                        root.left = l;
                        root.right = r;
                        allTrees.add(root);
                    }
                }         
            } 
        }
        return allTrees;        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}