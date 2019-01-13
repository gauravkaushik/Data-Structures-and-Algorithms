package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/k-closest-points-to-origin/
========================================================================

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.) 

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

*/

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {

		if (points == null || points.length <= K)
			return points;

		PriorityQueue<int[]> pq = new PriorityQueue<>(K, new SortByDist());

		for (int i = 0; i < points.length; i++)
			pq.offer(points[i]);

		int[][] result = new int[K][2];
		for (int i = 0; i < K; i++)
			result[i] = pq.poll();

		return result;

	}

	private class SortByDist implements Comparator<int[]> {

		@Override
		public int compare(int[] point1, int[] point2) {		
			double dist1 = Math.sqrt(Math.pow(point1[0], 2) + Math.pow(point1[1], 2));
			double dist2 = Math.sqrt(Math.pow(point2[0], 2) + Math.pow(point2[1], 2));
			if (dist1 == dist2)
				return 0;
			else if (dist1 < dist2)
				return -1;
			else
				return 1;
		}

	}
    
    /* Concise solution from https://leetcode.com/problems/k-closest-points-to-origin/discuss/217999/JavaC%2B%2BPython-O(NlogK) :
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }*/
    
   
   /*Concise and efficient solution :  https://leetcode.com/problems/k-closest-points-to-origin/discuss/217969/Java-8-liner-using-PriorityQueue-O(nlogK).
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) { 
            pq.offer(p); 
            if (pq.size() > K) { pq.poll(); } // poll out the farthest among the K + 1 points.
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) { ans[i] = pq.poll(); }
        return ans;
    }
    */
    
    /* Notes : Different ways of passing a comparator to PriorityQueue:              
    
    Custom comparator:
    PriorityQueue<String> pq= new PriorityQueue<String>(5, new SortByXYZ());
    class SortByXYZ implements Comparator<String>
    {
        @Override
        public int compare(String s1, String s2)
        {
            return s1.compareTo(s2);
        }
    }
    
    Inline comparator:
    PriorityQueue<String> pq= new PriorityQueue<String>(5, new Comparator<String>() {
        
        public int compare(String s1, String s2)
        {
            return s1.compareTo(s2);
        }
        
    });
    
    Using Lambda Expression:
    PriorityQueue<String> pq=
                    new PriorityQueue<String>(5,(a,b) -> a.length() - b.length());
                    
    Using Method reference:
    PriorityQueue<String> pq=
                new PriorityQueue<String>(5, Comparator.comparing(String::length));
    
    
    */
}