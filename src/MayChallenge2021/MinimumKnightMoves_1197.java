package MayChallenge2021;

import java.util.*;

/**
 @author :
 Gaurav Kaushik
 https://leetcode.com/kaushikgaurav08/
 https://www.linkedin.com/in/gvk28/
 https://github.com/gauravkaushik

 https://leetcode.com/problems/minimum-knight-moves/

*/
class MinimumKnightMoves_1197 {

    public int minKnightMoves(int x, int y) {
        // to find shortest path, we can use BFS
        // to find the 8 directions, we can have a directions array
        // to avoid revisiting same square, we can keep a visited set
        x = Math.abs(x);
        y = Math.abs(y);

        int moves = 0;
        Set<String> visited = new HashSet<>();
        Queue<Square> q = new LinkedList<>();
        q.offer(new Square(0, 0));
        visited.add("0,0");


        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Square square = q.poll();

                if(square.x == x && square.y == y) {
                    return moves;
                }

                for(Square nextSquare : getNextSquares(square, visited)) {
                    if(!visited.contains(nextSquare.toString())) {
                        q.offer(nextSquare);
                        visited.add(nextSquare.toString());
                    }
                }
            }

            moves++;
        }

        return -1; //we can throw an exception if reached here
    }

    List<Square> getNextSquares(Square curSquare, Set<String> visited) {
        List<Square> nextSquares = new ArrayList<>();

        int[][] directions = {
                {1,2},  //1
                {1,-2},  //2
                {2,1},  //3
                {2,-1},  //4
                {-1,2},  //5
                {-1,-2},  //6
                {-2,1},  //7
                {-2,-1}  //8
        };

        for(int[] dir : directions) {
            int nextX = curSquare.x + dir[0];
            int nextY = curSquare.y + dir[1];
            if(!visited.contains(nextX + "," + nextY) && (Math.abs(nextX) + Math.abs(nextY) <= 300) && nextX >= -1 && nextY >= -1) {
                nextSquares.add(new Square(nextX, nextY));
            }
        }

        return nextSquares;
    }

    class Square {
        int x, y;
        Square(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

    }
}

//Notes:
//was getting TLE since I was traversing all 4 quadrants. but the problem is symmetric.
//got idea of traversing only one quadrant from https://leetcode.com/problems/minimum-knight-moves/discuss/401580/Clean-Java-BFS-solution


/*
Question:
1197. Minimum Knight Moves
Medium

708

249

Add to List

Share
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.



Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


Constraints:

|x| + |y| <= 300
 */