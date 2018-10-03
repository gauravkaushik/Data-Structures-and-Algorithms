package leetcode.easy.removeduplicatefromsortedlist2;

import java.util.HashMap;

public /**
		 * Definition for singly-linked list. public class ListNode { int val;
		 * ListNode next; ListNode(int x) { val = x; } }
		 */
class Solution {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = cur.next;
		while (next != null) {
			if (cur.val != next.val) {
				prev = cur;
				cur = next;
				next = next.next;
			} else {
				next = next.next;
				while (next != null) {
					if (next.val == cur.val)
						next = next.next;
					else
						break;
				}
				if (next == null) {
					if (prev == null)
						return null;
					else {
						prev.next = next;
						return head;
					}
				} else {
					if (prev != null) {
						prev.next = next;
						cur = next;
						next = next.next;
					} else {
						head = next;
						cur = next;
						next = next.next;
					}
				}
			}

		}

		return head;

	}

	public ListNode deleteDuplicatesOld(ListNode head) {
		if (head == null)
			return null;
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		ListNode cur = head;
		int value;
		while (cur != null) {
			value = cur.val;
			if (!frequency.containsKey(value))
				frequency.put(value, 1);
			else
				frequency.put(value, frequency.get(value) + 1);
			cur = cur.next;
		}

		ListNode prev = null;
		cur = head;
		while (cur != null) {
			value = cur.val;
			// System.out.println("Current Node is : " + value+" and it has
			// freq: "+frequency.get(value));
			if (frequency.get(value) > 1) {
				if (prev == null) {
					head = head.next;
					cur = cur.next;
				} else {
					prev.next = cur.next;
					cur = cur.next;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}

		}

		return head;
	}

	// ideal solution sample from leetcode
	public ListNode deleteDuplicatesIdeal(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(head.val - 1); // record the head
		dummy.next = head;
		ListNode pre = dummy, cur = head;
		while (cur != null) {
			while (cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}