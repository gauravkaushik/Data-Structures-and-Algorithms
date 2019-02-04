package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
========================================================================

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).


Example 2:
Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:
The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.


*/

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<Node> nodesList = new ArrayList<>();
        
        helper(root, 0, 0, nodesList);
        
        Collections.sort(nodesList, new SortByX());
        
        List<List<Integer>> result = new ArrayList<>();
        Integer prevX = null;
        List<Integer> temp = null;
        for(int i=0; i<nodesList.size(); i++)
        {
            Node node = nodesList.get(i);
            if(prevX == null || prevX!=node.x)
            {
                temp = new ArrayList<>();
                result.add(temp);                
            }
            temp.add(node.val);                
            prevX = node.x;
        }
        
        return result;        
    }
    
    private void helper(TreeNode root, int x, int y, List<Node> nodesList)
    {
        if(root == null)
            return;
        
        Node node = new Node(x, y, root.val);
        nodesList.add(node);
        
        helper(root.left, x-1, y-1, nodesList);
        helper(root.right, x+1, y-1, nodesList);   
        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Node
    {
        Integer x,y,val;
        
        Node(Integer x, Integer y, Integer val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    private class SortByX implements Comparator<Node>
    {
        @Override
        public int compare(Node A, Node B)
        {
            if(A.x != B.x)
                return A.x.compareTo(B.x);
            else if(A.y != B.y)
                return B.y.compareTo(A.y);
            else
                return A.val.compareTo(B.val);
        }
    }
    
}






/*
A Smart Solution from : 
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231148/Java-TreeMap-Solution

We have 3 parameters X,Y,val
so 3 treemaps are used to keep them sorted
also, author has incremented Y value going down to maintain vertical order

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, TreeSet<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (TreeSet<Integer> nodes : ys.values()) {
                for (int i : nodes) {
                    list.get(list.size() - 1).add(i);
                }
            }
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new TreeSet<>());
        }
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}

*/