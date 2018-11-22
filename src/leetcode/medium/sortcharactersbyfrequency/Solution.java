package leetcode.medium.sortcharactersbyfrequency;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
* 
* 
==========================================================================
https://leetcode.com/problems/sort-characters-by-frequency/
==========================================================================

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
	
*
*/

public class Solution {
    
    //keep an array of 256 characters and sort based on frequency
    public String frequencySort(String s) {
        Letter[] letters = new Letter[256];
        
        for(int i=0;i<256;i++)
            letters[i] = new Letter((char)i,0);
        
        for(char c : s.toCharArray())
        {
             letters[c].count++;
        }
        
        Arrays.sort(letters, new SortByCount());        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<256;i++)
        {
            if(letters[i].count==0)
                break;
            
            for(int j=0;j<letters[i].count;j++)
                sb.append(letters[i].c);
            
        }
        return sb.toString();
    }
    
    //using max heap
    public String frequencySortUsingMaxHeap(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars)
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        PriorityQueue< Map.Entry<Character, Integer> > pq = new PriorityQueue<>( new SortByValue());
        for(Map.Entry entry : mp.entrySet())
        {
            pq.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++)
                sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
    
    public String frequencySortUsingListSorting(String s) {
        
        Map<Character,Integer> mp = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars)
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        mp = sortByValueInDescendingOrder(mp);
        
        StringBuilder sb = new StringBuilder();
        for(Character c : mp.keySet())
        {
            for(int i=0;i<mp.get(c);i++)
                sb.append(c);
        }
        return sb.toString();
        
    }
    
    Map<Character,Integer> sortByValueInDescendingOrder(Map<Character,Integer> mp)
    {
        List< Map.Entry<Character,Integer> > list = new LinkedList<>(mp.entrySet());
        
        Collections.sort( list, new SortByValue() );
        
        Map<Character,Integer> temp = new LinkedHashMap<Character, Integer>();
        
        for(Map.Entry<Character,Integer> entry : list)
            temp.put(entry.getKey(),entry.getValue());
        
        return temp;
    }
}

class SortByValue implements Comparator< Map.Entry<Character,Integer> >
{
    @Override
    public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2)
    {
        return entry2.getValue() - entry1.getValue();
    }
}

class Letter
{
    char c;
    int count;
    Letter(char c, int count)
    {
        this.c = c;
        this.count = count;
    }
}

class SortByCount implements Comparator<Letter>
{
    @Override
    public int compare(Letter a, Letter b)
    {
        return b.count - a.count;
    }
}
