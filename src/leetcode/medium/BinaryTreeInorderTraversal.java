package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/binary-tree-inorder-traversal/
=========================================================================
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    
    //iterative approach
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        
        while(root != null || !stk.isEmpty())
        {
            while(root != null)
            {
                stk.push(root);
                root = root.left;                
            }
            
            root = stk.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result;            
        
    }
    
    //recursive solution
    public List<Integer> inorderTraversalRecursiveApproach(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        inorder(root, result);
        
        return result;
    }
    
    void inorder(TreeNode root, List<Integer> result)
    {
        if(root==null)
            return;        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);        
    }
}

