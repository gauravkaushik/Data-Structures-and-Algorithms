package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/minimum-cost-for-tickets/
========================================================================

In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.


Example 1:
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:
Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
 

Note:

1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000
*/

public class MinimumCostForTickets {
    
    int[] memo;
    Set<Integer> daySet;
    public int mincostTickets(int[] days, int[] costs) {
        
        memo = new int[366];
        daySet = new HashSet<>();
        for(int i=0; i<days.length; i++)
            daySet.add(days[i]);
        
        return dp(1, costs);
    }
    
    //based on sample solution shared in leetcode
    int dp(int day, int[] costs)
    {
        if(day > 365)
            return 0;
        if(memo[day]!=0)
            return memo[day];
        if(daySet.contains(day))
        {
            memo[day] = Math.min( dp(day+1,costs)+costs[0], dp(day+7,costs)+costs[1]);
            memo[day] = Math.min(memo[day], dp(day+30, costs) + costs[2]);
        }else
            memo[day] = dp(day+1, costs);
        
        //memo[day] = dp[day];
        return memo[day];
    }
    
    int helperDp(int[] days, int[] costs)
    {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=days.length-1; i>=0; i--)
        {            
            int j = getExpiredDay(days,i,1);
            int temp=0;
            if(j<days.length)
                temp = dp[j];
            dp[i] = Math.min(dp[i],temp+costs[0]);
            
            temp = 0;
            j = getExpiredDay(days,i,7);
            if(j<days.length)
                temp = dp[j];
            dp[i] = Math.min(dp[i],temp+costs[1]);
            
            temp = 0;
            j = getExpiredDay(days,i,30);
            if(j<days.length)
                temp = dp[j];
            dp[i] = Math.min(dp[i],temp+costs[2]);
        }
        
        return dp[0];
    }
    
    int getExpiredDay(int[] days, int startDay, int daysCount)
    {        
        int i=startDay+1;        
        while(i<days.length && days[i]<days[startDay]+daysCount)
            i++;
        return i;        
    }
    
    int helper(int[] days, int[] costs, int low, Map<Integer, Integer> mp)
    {
        if(mp.containsKey(low))
            return mp.get(low);
        
        if(low>=days.length)
            return 0;
        
        int minCost = Integer.MAX_VALUE;
        //purchase 1-day pass on low
        int choice1Cost = costs[0] + helper(days, costs,low+1, mp);
        minCost = Math.min(minCost, choice1Cost);
        
        //purchase 7-day pass on low
        int high=low+1;
        while(high<days.length && days[high] <= days[low]+6)
            high++;
        int choice2Cost = costs[1] + helper(days, costs, high, mp);
        minCost = Math.min(minCost, choice2Cost);
        
        //purchase 30-day pass on low
        high=low+1;
        while(high<days.length && days[high] <= days[low]+29)
            high++;
        int choice3Cost = costs[2] + helper(days, costs, high, mp);
        minCost = Math.min(minCost, choice3Cost);
        
        mp.put(low, minCost);
        
        return minCost;
    }
}