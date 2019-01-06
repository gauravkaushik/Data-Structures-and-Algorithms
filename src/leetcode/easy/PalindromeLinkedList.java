package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/palindrome-linked-list/
========================================================================

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false


Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

*/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null)
            return true;
        
        ListNode slow = head, fast = head, firstHalf = head, prev = null;        
        ListNode secondHalf;
        
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }        
        
        if(fast == null)        
            secondHalf = reverse( prev.next ); //even number of nodes in original list
        else        
            secondHalf = reverse( slow.next ); //odd number of nodes in original list        
        
        prev.next = null;
        
        while(firstHalf!=null && secondHalf!=null)
        {
            if(firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        if(firstHalf!=null || secondHalf!=null)
            return false;
        return true;
    }
    
    //recursion O(n) space
    ListNode reverseRecursion(ListNode head)
    {
        if( head==null || head.next==null ) return head;
        ListNode res = reverse( head.next );
        head.next.next = head;
        head.next = null;
        return res;
    }
    
    //Using 3 pointers in O(1) space
    ListNode reverse( ListNode head )
    {
        if( head==null || head.next==null ) return head;
        ListNode cur, next, temp;
        cur = head;
        next = cur.next;
        temp = next.next;
        
        while( next != null )
        {
            next.next = cur;
            cur = next;
            next = temp;
            if( temp != null )
                temp = temp.next;            
        }
        
        head.next = null;
        return cur;
    }
    
    private class ListNode {
        int val;
        ListNode next;
    }
}