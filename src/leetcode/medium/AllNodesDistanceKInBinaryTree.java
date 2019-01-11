package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
========================================================================

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.


Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:
The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
*/

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {     
        
        Set<Integer> set = new HashSet<>();
        helper(root, target, K, set);  
        if (K!=0)
            set.remove(target.val);
        List<Integer> result = new ArrayList<>();
        for(Integer i : set)
            result.add(i);
        return result;
        
    }
    
    int helper(TreeNode root, TreeNode target, int K, Set<Integer> set)
    {
        if(root == null)
            return -1;
        if(root == target)
        {
            descendantAtDistanceK(root, K, set);
            return K-1;
        }
        boolean isLeft = true;
        int i = helper(root.left, target, K, set);        
        if(i==-1)
        {
            isLeft = false;
            i = helper(root.right, target, K, set);
        }
        if(i==-1)
            return -1;
        
        if(i==0)
        {
            set.add(root.val);
            return -1;
        }
        
        if(isLeft)
            descendantAtDistanceK(root.right, i-1, set);
        else
            descendantAtDistanceK(root.left, i-1, set);
        return i-1;
    }
    
    void descendantAtDistanceK(TreeNode source, int K, Set<Integer> result)
    {
        if(source==null)
            return;
        if(K==0)
        {            
            result.add(source.val);
        }
            
        descendantAtDistanceK(source.left, K-1, result);
        descendantAtDistanceK(source.right, K-1, result);
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
}