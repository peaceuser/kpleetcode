public class L62_UniquePaths {

    /*
    62. Unique Paths
Medium

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
     */
    public static void main(String args[]) {

    }
}

class L62_Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        //last row can only go horizontal right
        for(int i=0;i<n;i++){  // all cols of last row
            matrix[m-1][i] = 1;
        }
        /*     02
        01[1 2 3 4]03
        11[1 2 3 4]13
        20[1 2 3 4]23
               22
         */

        //last col can only go vetically down
        for(int i=0;i<m;i++){ // one colums all cell from each row
            matrix[i][n-1] = 1;
        }

        //start from last cell and move towards first cell
        for(int row = m-2;row>=0;row--){ // since last row has only 1 way we start with second last row
            for(int col= n-2;col>=0;col--){ // since last col can only go down we start with second last col
                // for each cell we have an option of going right cell and down cell
                // this next row cell + next col cell total is current cell option
                matrix[row][col] = matrix[row+1][col] + matrix[row][col+1];
            }
        }
        // return what we get from begining of cell
        return matrix[0][0];
    }
}
