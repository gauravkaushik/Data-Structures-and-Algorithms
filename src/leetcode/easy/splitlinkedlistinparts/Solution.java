package leetcode.easy.splitlinkedlistinparts;

public class Solution {
	ListNode[] splitListToParts(ListNode root, int k) {
		// if(root==null)
		// return null;

		int len = len(root);
		// System.out.println("Len : "+len);
		if (k == len) {
			ListNode[] result = new ListNode[len];
			ListNode cur = root;
			ListNode temp = null;
			for (int i = 0; i < len; i++) {
				temp = cur.next;
				result[i] = cur;
				cur.next = null;
				cur = temp;
			}
			return result;
		} else if (k > len) {
			ListNode[] result = new ListNode[k];
			ListNode cur = root;
			ListNode temp = null;
			for (int i = 0; i < len; i++) {
				temp = cur.next;
				result[i] = cur;
				cur.next = null;
				cur = temp;
			}
			return result;
		} else {
			int eachPartitionGets = len / k;
			int elementsLeft = len % k;
			int addOneExtra = 1;
			ListNode[] result = new ListNode[k];
			ListNode cur = root;
			ListNode prev = null;

			for (int i = 0; i < k; i++) {
				if (elementsLeft > 0) {
					elementsLeft--;
				} else {
					addOneExtra = 0;
				}
				result[i] = cur;
				for (int j = 0; j < (eachPartitionGets + addOneExtra); j++) {
					prev = cur;
					cur = cur.next;
					// temp = cur;
				}
				prev.next = null;

			}
			return result;
		}

	}

	int len(ListNode head) {
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}