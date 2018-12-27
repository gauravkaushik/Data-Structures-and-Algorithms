package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/binary-tree-postorder-traversal/
=========================================================================
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        
        if(root==null)
            return result;
        
        stk.push(root);
        
        while(!stk.isEmpty())
        {
            root = stk.pop();
            result.add(root.val);
            
            if(root.left!=null)
                stk.push(root.left);            
            
            if(root.right!=null)
                stk.push(root.right);
        }
        
        Collections.reverse(result);
        
        return result;
    }
    
    //recursive
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        postorder(root, result);
        
        return result;
    }
    
    void postorder(TreeNode root, List<Integer> result)
    {
        if(root!=null)
        {
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }
    }
}