package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
========================================================================

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:

We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]
 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/




public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        compute(ans, root, 0);
        
        return ans;
    }
    
    void compute(List<List<Integer>> ans, Node root, int level)
    {
        if(root==null)
            return;
        
        if(ans.size() == level)
            ans.add(new ArrayList<>());
        
        ans.get(level).add(root.val);
        
        if(root.children!=null)
        {
            for(Node child : root.children)
                compute(ans, child, level+1);
        }
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