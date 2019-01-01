package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/intersection-of-two-linked-lists/
========================================================================
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfTwoLinkedLists {
	
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //one or both the lists are empty
        if(headA==null || headB==null)
            return null;
        
        ListNode curA = headA;
        ListNode curB = headB;   
        
        //first node itself is the intersection point
        if(curA == curB)
            return curA;
        
        int skipA = 0, skipB = 0;
        
        while(curA!=null && curB!=null)
        {
            curA = curA.next;
            curB = curB.next;
        }
                
        if(curA!=null && curB==null)
        {
            while(curA!=null)
            {
                curA = curA.next;
                skipA++;
            }
        }else if(curA==null && curB!=null)
        {
            while(curB!=null)
            {
                curB = curB.next;
                skipB++;
            }
        }
        
        //System.out.println("skipA : "+skipA + ", skipB : "+ skipB);
        
        curA = headA;
        curB = headB;
        
        for(int i=0; i<skipA; i++)
            curA = curA.next;
        
        for(int i=0; i<skipB; i++)
            curB = curB.next;
        
        // System.out.println("curA : "+curA.val);
        // System.out.println("curB : "+curB.val);
        
        //one list's head is the intersection point
        if(curA == curB)
            return curA;
        
        while(curA!=null && curB!=null)
        {
            curA = curA.next;
            curB = curB.next;
            if(curA == curB)
                return curA;            
        }
        
        return null;       
    
    }
}



