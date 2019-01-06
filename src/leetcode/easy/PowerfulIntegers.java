package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/powerful-integers/
========================================================================

Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.

Return a list of all powerful integers that have value less than or equal to bound.

You may return the answer in any order.  In your answer, each value should occur at most once.

 

Example 1:

Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation: 
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2
Example 2:

Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
 

Note:

1 <= x <= 100
1 <= y <= 100
0 <= bound <= 10^6
A
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
	
	public static void main(String[] args) {
		PowerfulIntegers obj = new PowerfulIntegers();
		List<Integer> powerfulIntegers = obj.powerfulIntegers(3, 5, 1000000);
		for(Integer i : powerfulIntegers)
			System.out.print(i+", ");
	}
	
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        //generate powers of x till the value is less than or equal to bound
        //generate powers of y till the value is less than or equal to bound
        //for each power X of x, 
            //for each power Y of y
                //if X+Y<=bound, add it to result set
        
        Set<Integer> hs = new HashSet<Integer>();
        
        List<Integer> powersOfX = new ArrayList<>();
        List<Integer> powersOfY = new ArrayList<>();        
        
        if(x==0 || x==1)
        {
        	powersOfX.add(x);
        }
        else
        {
        	int X = 1;
            while(X<=bound)
            {
                powersOfX.add(X);
                X = X * x;
            }
        }
        	
        
        if(y==0 || y==1)
        {
        	powersOfY.add(y);
        }
        else
        {
        	int Y = 1;
            while(Y<=bound)
            {
                powersOfY.add(Y);
                Y = Y * y;
            }
        }
        
        
        int sum;
        for(int i=0; i<powersOfX.size(); i++)
        {
            for(int j=0; j<powersOfY.size(); j++)
            {
                sum = powersOfX.get(i) + powersOfY.get(j);
                if(sum <= bound)
                    hs.add(sum);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(Integer i : hs)
            result.add(i);
        
        return result;
        
    }
}