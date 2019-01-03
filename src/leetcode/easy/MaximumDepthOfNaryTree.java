package leetcode.easy;

import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
========================================================================

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

 


 

We should return its max depth, which is 3.

 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/


public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;        
        
        int max = 1;
        
        List<Node> children = root.children;
        if(children!=null)
        {
            for(Node child : children)
                max = Math.max(max, 1 + maxDepth(child));
        }
        
        return max;
        
    }
    
    private class Node {
        public int val;
        public List<Node> children;
    }
}