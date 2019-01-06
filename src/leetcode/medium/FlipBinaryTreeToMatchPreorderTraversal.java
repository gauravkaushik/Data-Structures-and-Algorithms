package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
========================================================================

Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

A node in this binary tree can be flipped by swapping the left child and the right child of that node.

Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

If we cannot do so, then return the list [-1].

 

Example 1:



Input: root = [1,2], voyage = [2,1]
Output: [-1]
Example 2:



Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]
Example 3:



Input: root = [1,2,3], voyage = [1,2,3]
Output: []
 

Note:

1 <= N <= 100


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlipBinaryTreeToMatchPreorderTraversal {

	int idx = 0;

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

		Set<Integer> res = new HashSet<Integer>();

		helper(root, voyage, res);

		List<Integer> result = new ArrayList<>();
		for (Integer i : res) {
			result.add(i);
		}

		return result;
	}

	void helper(TreeNode root, int[] voyage, Set<Integer> res) {
		if (root == null)
			return;
		if (root.val != voyage[idx]) {
			res.clear();
			res.add(-1);
			return;
		}
		idx++;
		if (root.left == null && root.right == null)
			return;
		if (root.left == null) {
			helper(root.right, voyage, res);
			return;
		} else if (root.right == null) {
			helper(root.left, voyage, res);
			return;
		}else
		{
			if(root.right.val == voyage[idx])
			{
				res.add(root.val);
				helper(root.right, voyage, res);
				helper(root.left, voyage, res);
				return;
			}
			else
			{
				helper(root.left, voyage, res);
				helper(root.right, voyage, res);
				return;
			}
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);

		int[] voyage = { 1,5,2,6,4,3 };
		FlipBinaryTreeToMatchPreorderTraversal ob = new FlipBinaryTreeToMatchPreorderTraversal();

		List<Integer> res = ob.flipMatchVoyage(root, voyage);
		for (Integer i : res)
			System.out.print(i + ", ");
	}	
	
	
}

