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
https://leetcode.com/problems/binary-tree-preorder-traversal/
=========================================================================
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    
    //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stk = new Stack<>();
        
        stk.push(root);
        
        while(!stk.isEmpty())
        {
            root = stk.pop();
            result.add(root.val);
            if(root.right!=null)
                stk.push(root.right);
            if(root.left!=null)
                stk.push(root.left);            
        }
        
        return result;
    }
    
    public List<Integer> preorderTraversalRecursiveSolution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }
    
    void preorder(TreeNode root, List<Integer> result)
    {
        if(root!=null)
        {
            result.add(root.val);
            preorder(root.left,result);
            preorder(root.right,result);
        }
    }
}