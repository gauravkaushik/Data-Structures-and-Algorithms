package leetcode.easy.reverselinkedlist;

import java.util.Stack;

public class Solution {

	// iterative
	public ListNode reverseListIterative(ListNode head) {

		ListNode prev = null, cur = head;
		while (cur != null) {
			ListNode nextTemp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextTemp;
		}

		return prev;

	}

	// Using extra stack
	public ListNode reverseListStack(ListNode head) {
		Stack<Integer> stk = new Stack<>();
		ListNode cur = head;

		while (cur != null) {
			stk.push(cur.val);
			cur = cur.next;
		}

		cur = head;
		while (cur != null && !stk.isEmpty()) {
			cur.val = stk.pop();
			cur = cur.next;
		}

		return head;
	}

	// recursive
	public ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) // empty or just one list
			return head;

		ListNode node = head.next;
		ListNode newHead = reverseList(head.next);

		node.next = head;
		head.next = null;

		return newHead;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}