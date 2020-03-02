package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/rotting-oranges/
========================================================================
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/

// high level approach:
// level order traversal 
// put all rotten cells in a queue
// deque each cell and put its adjacent fresh cells in queue 
// if any fresh cell left, return -1 else return levels 

class Solution {
    public int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] visited = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == 2){ //rotten cell
					q.offer(new int[]{i,j});
				}
			}
		}
		
		// [(0,0]]
		int minute = -1;
        if(q.isEmpty())
			minute = 0;
		while(!q.isEmpty()) {
			int size = q.size(); // 1 |= 2
			
			while(size-- > 0) {
				int[] cell = q.poll(); // (0,0) |= (1,0)
				int i = cell[0]; 
				int j = cell[1];
				if(visited[i][j])
					continue;
				visited[i][j] = true;
				if(grid[i][j] == 2) {
					//check 4 neighbors
					if(i > 0 && grid[i-1][j] == 1 && !visited[i-1][j]) { 
						grid[i-1][j] = 2;
						q.offer(new int[]{i-1,j});
					}
					if(j > 0 && grid[i][j-1] == 1 && !visited[i][j-1]) {
						grid[i][j-1] = 2;
						q.offer(new int[]{i,j-1});
					}
					if(i < r-1 && grid[i+1][j] == 1 && !visited[i+1][j]) { //(1,0)
						grid[i+1][j] = 2;
						q.offer(new int[]{i+1,j});
					}
					if(j < c-1 && grid[i][j+1] == 1 && !visited[i][j+1]) { //(0,1)
						grid[i][j+1] = 2;
						q.offer(new int[]{i,j+1});
					}
				}
				
			}
			minute++; //1
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == 1){ //fresh cell
					return -1;
				}
			}
		}
		return minute;
		
		
    }
	
}
