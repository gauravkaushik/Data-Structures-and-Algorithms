package leetcode.medium.courseschedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numCourses; i++)
			graph.add(i, new ArrayList<Integer>());

		int[] indegree = new int[numCourses];
		int course1, course2;
		for (int i = 0; i < prerequisites.length; i++) {
			course1 = prerequisites[i][0];
			course2 = prerequisites[i][1];

			graph.get(course1).add(course2);
			indegree[course2] = indegree[course2] + 1;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		boolean[] visited = new boolean[numCourses];

		int course = -1;
		while (!q.isEmpty()) {
			course = q.poll();
			visited[course] = true;
			// System.out.print(""+course+" ");
			for (int neighbor : graph.get(course)) {
				if (!visited[neighbor]) {
					if (indegree[neighbor] == 1)
						q.add(neighbor);
					indegree[neighbor] = Math.max(0, indegree[neighbor] - 1);
				}
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i])
				return false;
		}

		return true;

	}
}