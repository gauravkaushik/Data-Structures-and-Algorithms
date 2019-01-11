package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/all-paths-from-source-to-target/
========================================================================

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 

Output: [[0,1,3],[0,2,3]] 

Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.


Note:
The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

*/

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //do dfs from source node to target node
        //keep a list to store current path
        //if current node is target, add current path to result set of paths
        //remove current node and consider other paths
        //Note: no need to keep visited since no cycle
        
        List<Integer> curPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        
        int N = graph.length;
        
        dfs(0, N-1, graph, curPath, allPaths);
        
        return allPaths;        
    }
    
    private void dfs(int source, int destination, int[][] graph, List<Integer> curPath, List<List<Integer>> allPaths)
    {        
        curPath.add(source);
        if(source == destination)
        {            
            allPaths.add(new ArrayList<>(curPath));
            curPath.remove(new Integer(source));
            return;
        }
        for(int neighbor : graph[source])
        {
            dfs(neighbor, destination, graph, curPath, allPaths);
        }
        curPath.remove(curPath.size()-1);    
    }
}