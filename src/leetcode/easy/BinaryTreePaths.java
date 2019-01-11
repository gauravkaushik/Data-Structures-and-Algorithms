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
https://leetcode.com/problems/binary-tree-paths/
========================================================================

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

*/

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        if(root == null)
            return result;
        
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        
        helper(root, curPath, allPaths);
        
        result = getListOfString(allPaths);
        
        return result;
        
    }
    
    List<String> getListOfString(List<List<Integer>> allPaths)
    {
        List<String> result = new ArrayList<>();
        for(List<Integer> path : allPaths)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0));
            
            for(int i=1; i<path.size(); i++)
            {
                sb.append("->");
                sb.append(path.get(i));
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }
    
    void helper(TreeNode root, List<Integer> curPath, List<List<Integer>> allPaths)
    {
        if(root == null)
            return;
        
        curPath.add(root.val);        
        
        //leaf node
        if(root.left == null && root.right == null)
        {
            allPaths.add(new ArrayList<>(curPath));            
        }
        else
        {
            helper(root.left, curPath, allPaths);
            helper(root.right, curPath, allPaths);
        }
               
        curPath.remove(curPath.size()-1);
    }
    
    
    /* Concise Solution from https://leetcode.com/problems/binary-tree-paths/discuss/68258/Accepted-Java-simple-solution-in-8-lines : 
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
    */
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}