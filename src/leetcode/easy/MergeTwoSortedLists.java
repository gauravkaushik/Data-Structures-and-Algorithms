package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/merge-two-sorted-lists/
========================================================================

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

 
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;       
        ListNode cur3 = null;
        ListNode result = null;
        
        int val=0;
        
        while(cur1!=null && cur2!=null)
        {            
            if(cur1.val<=cur2.val)
            {   
                val = cur1.val;
                cur1 = cur1.next;
            }else 
            {
                val = cur2.val;
                cur2 = cur2.next;
            }
            
            if(cur3==null)
            {
                cur3 = new ListNode(val);
                result = cur3;
            }
            else
            {
                cur3.next = new ListNode(val);
                cur3 = cur3.next;
            }
        }
        
        if(cur1!=null || cur2!=null)
        {
            cur3.next = ( cur1!=null ? cur1 : cur2 );
        }
        
        
        return result;
        
    }
    
    /*Concise Version:
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}       
    }
    */
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}