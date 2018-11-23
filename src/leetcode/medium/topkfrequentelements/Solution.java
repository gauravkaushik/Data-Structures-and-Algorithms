package leetcode.medium.topkfrequentelements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
========================================================================
https://leetcode.com/problems/top-k-frequent-elements/
=========================================================================
Description : 
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class Solution {
    
    //using bucket sort; where buckets are frequency
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> mp = new HashMap<Integer,Integer>();
        
        for(int num : nums)
            mp.put(num, mp.getOrDefault(num,0)+1);
        
        //List<Integer> buckets = new ArrayList<>(nums.length+1);
        List[] buckets = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            int freq = entry.getValue();
            if(buckets[freq]==null)
                buckets[freq] = new ArrayList<Integer>();
            buckets[freq].add(entry.getKey());
            //System.out.println(entry.getKey() + " -> "+ entry.getValue());
            //System.out.println(entry.getValue() + " -> "+ entry.getKey());
        }
        
        List<Integer> result = new ArrayList<>();
        
        l1:
        for(int i=0,j=0;i<nums.length && j<k;i++)
        {
            if(buckets[nums.length-i]!=null)
            {
                
                result.addAll(buckets[nums.length-i]);
                j = j+buckets[nums.length-i].size();
                                    
                
            }
                
            //System.out.println((nums.length-i));
        }
        
        return result;
    }
    
    public List<Integer> topKFrequentUsingMinHeap(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer,Integer>();
        
        for(int num : nums)
            mp.put(num, mp.getOrDefault(num,0)+1);
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new SortByCount());        
        
        
        int i=0;    
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            if(i<k)
                pq.add(entry);
            else
            {
                Map.Entry<Integer,Integer> min = pq.peek();
                if(min.getValue()<entry.getValue())
                {
                    pq.poll();
                    pq.add(entry);
                }
            }
            i++;
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty())
        {
            Map.Entry<Integer,Integer> item = pq.poll();
            result.add(item.getKey());
        }
            
        
        return result;
    }
}

class SortByCount implements Comparator<Map.Entry<Integer,Integer>>
{
    @Override
    public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2)
    {
        return e1.getValue() - e2.getValue();
    }
}
