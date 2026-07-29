//dp
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                break;
            }
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1)
                dp[0] = 0;
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else
                    dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

//recursion+memorization
// class Solution {

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;

//         Integer[][] dp = new Integer[m][n];

//         return findPath(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid, dp);
//     }

//     private int findPath(int i, int j, int[][] grid, Integer[][] dp) {
//         if (grid[i][j] == 1)
//             return 0;
//         if (i == 0 && j == 0) {
//             return 1;
//         }
//         if (dp[i][j] != null)
//             return dp[i][j];
//         int paths = 0;
//         if (i != 0)
//             paths += findPath(i - 1, j, grid, dp);
//         if (j != 0)
//             paths += findPath(i, j - 1, grid, dp);
//         return dp[i][j] = paths;
//     }
// }