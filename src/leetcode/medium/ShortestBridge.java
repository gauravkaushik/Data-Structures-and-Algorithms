package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShortestBridge {

    public int shortestBridge(int[][] A) {
        //create a set A that stores coordinates of all points in island 1
        //create a set B that stores coordinates of all points in island 2
        //for each point 'a' in set A, find its closest point 'b' in set B using Manhattan Distance metric
        //return the distance of the closest pair (a,b)
        
        if(A == null || A.length==0)
            return 0;
        
        int shortestBridge = Integer.MAX_VALUE;
        int rows = A.length;
        int cols = A[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<HashSet<Coordinate>> list = new ArrayList<>();
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(!visited[i][j] && A[i][j]==1)
                {
                    HashSet<Coordinate> coordinates = new HashSet<>();
                    findCoordinatesOfIsland(i,j,A,visited,rows,cols,coordinates);
                    list.add(coordinates);
                }
            }
        }
        
        HashSet<Coordinate> setA = list.get(0);
        HashSet<Coordinate> setB = list.get(1);
        
        for(Coordinate a : setA)
            for(Coordinate b : setB)
                shortestBridge = Math.min(shortestBridge, manhattanDistance(a,b));
            
        
        return shortestBridge;
        
        
    }
    
    void findCoordinatesOfIsland(int i, int j, int[][] A, boolean[][] visited, int rows, int cols, HashSet<Coordinate> coordinates)
    {
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || A[i][j]==0)
            return;
        
        visited[i][j] = true;
        coordinates.add(new Coordinate(i,j));
        findCoordinatesOfIsland(i-1,j,A,visited,rows,cols,coordinates);
        findCoordinatesOfIsland(i+1,j,A,visited,rows,cols,coordinates);
        findCoordinatesOfIsland(i,j-1,A,visited,rows,cols,coordinates);
        findCoordinatesOfIsland(i,j+1,A,visited,rows,cols,coordinates);
    }
    
    int manhattanDistance(Coordinate a, Coordinate b)
    {
        return (int)(Math.abs(a.i-b.i) + Math.abs(a.j-b.j));
    }
}
class Coordinate
{
    int i,j;
    Coordinate(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}