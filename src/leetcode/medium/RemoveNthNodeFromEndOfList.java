package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
========================================================================

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note: Given n will always be valid.

Follow up:
Could you do this in one pass?

*/


public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //keep a cur pointer at first node
        //keep a next pointer n distance away from cur
        //increment both pointers by 1 until next reaches last node
        //delete the node next to cur pointer
        
        if(head == null || head.next == null)
            return null;
        
        ListNode cur = head;
        ListNode next = cur;
        for(int i=1; i<=n; i++)
        {
            next = next.next;            
        }       
        
        if(next==null)
            head = head.next;
        else
        {
            while(next.next!=null)
            {
                cur = cur.next;
                next = next.next;
            }
            cur.next = cur.next.next;
        }
        
        return head;
    }
    
    // Definition for singly-linked list.
      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     
}