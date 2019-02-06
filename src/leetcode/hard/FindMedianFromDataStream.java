package leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/find-median-from-data-stream/
========================================================================

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/
public class FindMedianFromDataStream {

    PriorityQueue<Integer> leftHeap, rightHeap;
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        leftHeap = new PriorityQueue<>(1, Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
        leftHeap.offer(1); leftHeap.poll();
        
    }
    
    public void addNum(int num) {             
        
        int sizeLeft = leftHeap.size();
        int sizeRight = rightHeap.size();
        
        if(sizeLeft==0)
            leftHeap.offer(num);
        else
        {
            if(num < leftHeap.peek())
                leftHeap.offer(num);
            else
                rightHeap.offer(num);
        }        
        
        sizeLeft = leftHeap.size();
        sizeRight = rightHeap.size();
        
        //balance both heaps
        while( Math.abs(sizeLeft - sizeRight) > 1 )
        {
            if(sizeLeft - sizeRight > 1)            
                rightHeap.offer(leftHeap.poll());                
            else
                leftHeap.offer(rightHeap.poll());
            
            sizeLeft = leftHeap.size();
            sizeRight = rightHeap.size();
        }       
    }
    
    public double findMedian() {
        
        int sizeLeft = leftHeap.size();
        int sizeRight = rightHeap.size();
        if(sizeLeft == sizeRight)
        {
            return (leftHeap.peek() + rightHeap.peek())/2.0;
        }
        else if(sizeLeft > sizeRight)
            return leftHeap.peek();
        else
            return rightHeap.peek();        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
 //Read : https://leetcode.com/problems/find-median-from-data-stream/solution/ for alternative approaches