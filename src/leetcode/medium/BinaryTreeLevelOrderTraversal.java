package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/binary-tree-level-order-traversal/
========================================================================

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/


  
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        return bfs(root);        
        
    }
    
    List<List<Integer>> bfs(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        Queue<QNode> q = new LinkedList<>();
        q.offer(new QNode(root,1));
        
        while(!q.isEmpty())
        {
            QNode qnode = q.poll();
            if(qnode==null || qnode.node==null)
                continue;
            //System.out.println(qnode.level + " : " + qnode.node.val);
            if(qnode.level > result.size())
            {
                List<Integer> list = new ArrayList<>();
                list.add(qnode.node.val);
                result.add(list);
            }
            else
            {
                result.get(qnode.level-1).add(qnode.node.val);
            }
            q.offer(new QNode(qnode.node.left, qnode.level+1));
            q.offer(new QNode(qnode.node.right, qnode.level+1));
            
        }
        
        return result;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
  
    private class QNode
    {
        TreeNode node;
        int level;
        QNode(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
        
    }
}

