package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/minimum-index-sum-of-two-lists/
========================================================================
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]

Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
 */

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> restaurantsInList1 = new HashMap<>();
        
        int index = 0;
        for(String restaurant : list1)
            restaurantsInList1.put(restaurant,index++);
        
        ArrayList<String> result = new ArrayList<>();
        int minIndex = list1.length + list2.length;
        for(int i=0; i<list2.length; i++)
        {
            if(restaurantsInList1.containsKey(list2[i]))
            {
                index = i + restaurantsInList1.get(list2[i]);
                if(index < minIndex)
                {
                    result.clear();
                    result.add(list2[i]);
                    minIndex = index;
                }else if(index == minIndex)
                    result.add(list2[i]);
            }            
        }       
                
        return result.toArray(new String[result.size()]);
        
    }
}