package leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/merge-intervals/
========================================================================

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].


Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size()<=1)
            return intervals;
        
        //sort the intervals by start time
        //pick the first interval
        //check if the overlaps with the second interval
            //if yes, merge and repeat this process until there is only one interval left
            //else, pick the next interval and repeat the process until all intervals are processed
        Collections.sort(intervals, new SortByStartTime());
        
        int i = 0;
        int j = 1;
        
        l1:
        while(i<intervals.size()-1)
        {
            j=i+1;
            
            l2:
            while(j<intervals.size())
            {
                if(overlaps(intervals,i,j))
                {
                    intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);
                    intervals.remove(j);
                    j = i+1;
                }
                else
                    break l2;
            }
            i++;
        }
        
        //for(Interval k : intervals)
            //System.out.println(k.start+", "+k.end);
        
        return intervals;
        
        
    }
    
    private boolean overlaps(List<Interval> intervals, int i, int j)
    {
        int iStart = intervals.get(i).start;
        int iEnd = intervals.get(i).end;
        
        int jStart = intervals.get(j).start;
        int jEnd = intervals.get(j).end;
        
        if(jStart==iStart || jEnd==iEnd || jStart==iEnd)
            return true;
        
        if(jStart<iEnd)
            return true;
        
        return false;
    }
    
    private class SortByStartTime implements Comparator<Interval>
    {
        public int compare(Interval i, Interval j)
        {
            return i.start - j.start;
        }
    }
    
    /** Concise Version : 
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    } */
    
    /** Definition for an interval. */
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
 
}