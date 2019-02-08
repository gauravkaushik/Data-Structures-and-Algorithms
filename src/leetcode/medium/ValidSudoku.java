package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/valid-sudoku/
========================================================================

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true


Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] digit = new boolean[10];
        
        char D;
        int I;
        //validate 9 rows
        for(int row=0; row<9; row++)
        {
            Arrays.fill(digit, false);
            for(int col=0; col<9; col++)
            {
                D = board[row][col];
                if(D != '.')
                {
                    I = D - '0';
                    if(digit[I])
                        return false;
                    digit[I] = true;
                }
            }
        }
        
        //validate 9 cols
        for(int col=0; col<9; col++)
        {
            Arrays.fill(digit, false);
            for(int row=0; row<9; row++)
            {
                D = board[row][col];
                if(D != '.')
                {
                    I = D - '0';
                    if(digit[I])
                        return false;
                    digit[I] = true;
                }
            }
        }
        
        //validate 9 sub-boxes
        List<int[]> list = new ArrayList<>();
        
        list.add(new int[]{0,1,2});
        list.add(new int[]{3,4,5});
        list.add(new int[]{6,7,8});
        
        int row,col;
        
        for(int i=0; i<=2; i++)
        {                        
            for(int j=0; j<=2; j++)
            {
                Arrays.fill(digit, false);
                //System.out.println();
                for(int k=0; k<=2; k++)
                {
                    for(int m=0; m<=2; m++)
                    {
                        row = list.get(i)[k];
                        col = list.get(j)[m];
                        //System.out.println(row+","+col);
                        D = board[row][col];
                        if(D != '.')
                        {
                            I = D - '0';
                            if(digit[I])
                                return false;
                            digit[I] = true;
                        }
                        
                    }
                }
            }
        }
        
        return true;
    }
}

/*
A concise solution from :https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings

public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}
*/