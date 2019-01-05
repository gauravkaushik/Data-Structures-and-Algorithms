package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/sort-list/
========================================================================

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

public class SortList {
    
    private class ListNode
    {
        int val;
        ListNode next;
    }
  
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null )
            return head;
        //find the middle point and cut the list into two halves at this point
        //sort both halves
        //merge the sorted lists
        
        ListNode prev = null, slow = head, fast = head;
        
        while( fast!=null && fast.next!=null )
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null; //end node of first half point to null
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return mergeTwoSortedLists(l1, l2);

    }
    
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }       
    }

}