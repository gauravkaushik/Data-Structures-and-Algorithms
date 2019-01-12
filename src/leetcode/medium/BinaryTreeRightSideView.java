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
https://leetcode.com/problems/binary-tree-right-side-view/
========================================================================

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int size;
        boolean flag;
        TreeNode temp;
        while(!q.isEmpty())
        {
            size = q.size();
            flag = true;
            while(size-- > 0)
            {
                temp = q.poll();
                if(flag) //insert right most node of current level into the result
                {
                    result.add(temp.val);
                    flag = false;
                }
                if(temp.right != null)
                    q.offer(temp.right);
                if(temp.left != null)
                    q.offer(temp.left);
                
            }
        }
        return result; 
        
        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
}