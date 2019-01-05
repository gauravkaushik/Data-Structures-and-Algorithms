package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/odd-even-linked-list/
========================================================================

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
*/


  
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if( head==null || head.next==null )
            return head;
        
        ListNode l1, l2, odd, even;
        l1 = head;
        odd = head;
        l2 = head.next;
        even = head.next;
        
        while(even!=null && odd!=null)
        {
            odd.next = even.next;
            if(odd.next == null)
            {
                odd.next = l2;
                return l1;
            }
            else
                odd = odd.next;
            even.next = odd.next;
            even = even.next;
            if( even == null )
            {
                odd.next = l2;
                return l1;
            }            
        }
        
        return l1;
    }
    
    /*
    //Cleaner Code
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    */
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}