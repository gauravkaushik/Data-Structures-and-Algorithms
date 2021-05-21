package MayChallenge2021;

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

 https://leetcode.com/problems/binary-tree-level-order-traversal/

 */

//  Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> temp = new ArrayList<>();
      while (size-- > 0) {
        TreeNode n = q.poll();
        temp.add(n.val);
        if (n.left != null) {
          q.offer(n.left);
        }
        if (n.right != null) {
          q.offer(n.right);
        }
      }
      result.add(temp);
    }

    return result;
  }
}
