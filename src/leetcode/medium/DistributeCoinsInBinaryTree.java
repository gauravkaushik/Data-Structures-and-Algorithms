package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/distribute-coins-in-binary-tree/
========================================================================

Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

 

Example 1:
Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.


Example 2:
Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.


Example 3:
Input: [1,0,2]
Output: 2


Example 4:
Input: [1,0,0,null,3]
Output: 4
 

Note:
1<= N <= 100
0 <= node.val <= N


*/

public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        
        Integer[] result = new Integer[1];
        result[0] = 0;
        
        helper(root, null, result);
        
        return result[0];
        
    }
    
    private void helper(TreeNode node, TreeNode parent, Integer[] result)
    {
        if(node == null)
            return;
        
        helper(node.right, node, result);
        helper(node.left, node, result);
        
        int diff = Math.abs(node.val - 1);
        
        if(node.val > 1)
        {            
            parent.val += diff;                        
        }
        else if(node.val < 1)
        {            
            parent.val -= diff;            
        }   
        result[0] += diff;
    }   
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

/*
A much concise solution from https://leetcode.com/problems/distribute-coins-in-binary-tree/solution/: 

class Solution {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R); //add number of moves to balance current node and its two subtrees
        return node.val + L + R - 1;
    }
}
*/