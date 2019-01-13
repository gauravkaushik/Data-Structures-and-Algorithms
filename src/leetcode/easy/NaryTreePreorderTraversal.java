package leetcode.easy;

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
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
========================================================================

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree: 

Return its preorder traversal as: [1,3,5,6,2,4].

Note:
Recursive solution is trivial, could you do it iteratively?
*/

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        
        Stack<Node> stk = new Stack<>();
        
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Node temp = null;
        List<Node> children = null;
        
        stk.push(root);
        while(!stk.isEmpty())
        {
            temp = stk.pop();
            res.add(temp.val);
            
            children = temp.children;
            if(children!=null)
            {
                for(int i=children.size()-1; i>=0; i--)
                    stk.push(children.get(i));
            }            
        }
        
        return res;            
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }    
}