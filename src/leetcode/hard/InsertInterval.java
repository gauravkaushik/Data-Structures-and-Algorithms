package leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/insert-interval/
========================================================================

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]


Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

*/


public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        //find position where newInterval can be inserted into the intervals using binary search
        //insert newInterval in intervals
        //merge all overlapping intervals 
        //return final list
        
        if(intervals==null)
            return null;
        if(newInterval==null)
            return intervals;        
        
        int N = intervals.size();
        
        //we will find lower bound index of intervals where can insert the newInterval
        int low = 0;
        int high = N-1;
        int mid;
        
        
        l1:
        while(low < high)
        {
            mid = ( low + high ) / 2;            
            if(newInterval.start <= intervals.get(mid).start)
                high = mid;
            else
                low = mid+1;
        }
        
        if(N == 0)
            intervals.add(newInterval);
        else if(N == 1)        
            low = ( (newInterval.start <= intervals.get(0).start) ? 0 : 1);
        else if(low==N-1 && newInterval.start>intervals.get(low).start)
            low++;
        
        intervals.add(low, newInterval);
        
        LinkedList<Interval> result = new LinkedList<>();
        //Now our problem is same as merging a list of overlapping intervals
        for(Interval interval : intervals)
        {
            if(result.size()==0 || interval.start>result.getLast().end)
                result.add(interval);
            else
                result.getLast().end = Math.max(result.getLast().end, interval.end);
        }
        
        return result;    
        
    }
    
    // Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    //alternate and concise solution
    /*
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;

        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
            Math.min(newInterval.start, intervals.get(i).start),
            Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }

        result.add(newInterval); // add the union of intervals we got

        // add all the rest
        while (i < intervals.size()) 
            result.add(intervals.get(i++)); 
        return result;
    }
    
    */
    

}