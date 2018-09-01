package leetcode.easy.linkedlistcycle;

public class Solution {

	// 20:02
	// 20:25
	public boolean hasCycle(ListNode head) {
		// use 2 pointer technique
		if (head == null)
			return false;
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while (true) {
			if (slowPtr == null || fastPtr == null)
				return false;
			if (fastPtr.next == null) // we have reached last node
				return false;

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr)
				return true;

		}

	}

}

// * Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
