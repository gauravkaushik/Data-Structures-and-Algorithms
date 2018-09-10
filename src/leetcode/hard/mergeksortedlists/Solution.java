package leetcode.hard.mergeksortedlists;

import java.util.Arrays;

public class Solution {
	// 23:19
	ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		int k = lists.length;
		ListNode[] current = new ListNode[k]; // store k pointers, one for each
												// list
		//int[] a = new int[k]; // to store current node val for each list
		int totalNodes = 0;// length of the longest list

		int len = 0;
		for (int i = 0; i < k; i++) {
			current[i] = lists[i]; // head pointer of each list

			len = length(lists[i]);
			totalNodes += len;
		}

		//int val;
		ListNode result = new ListNode(0); // dummy node with value 0
		ListNode tail = result;
		int listIndex = -1;
		int minVal;

		for (int i = 0; i < totalNodes; i++) {
			minVal = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if (current[j] != null && current[j].val <= minVal) {
					minVal = current[j].val;
					listIndex = j;
				}
			}
			current[listIndex] = current[listIndex].next;
			tail.next = new ListNode(minVal);
			tail = tail.next;

		}

		return result.next; // deleting the first dummy node
	}

	void sortAndAppend(int[] a, ListNode tail) {
		Arrays.sort(a);
		System.out.println("After sort : ");
		print(a);
		for (int i : a) {
			if (i != Integer.MIN_VALUE)
			// TODO what if i is a list actualy contains this special value
			{
				tail.next = new ListNode(i);
				tail = tail.next;
			}
		}
	}

	int length(ListNode head) {
		int len = 0;
		if (head == null)
			return len;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void appendEnd(int val) {
		ListNode current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new ListNode(val);
	}
}
