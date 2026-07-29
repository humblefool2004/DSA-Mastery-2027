class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;

        Integer[][] dp= new Integer[m][n];

        return findPath(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,dp);
    }

    private int findPath(int i, int j,int[][] grid,Integer[][] dp){
        if(grid[i][j] == 1) return 0;
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int paths=0;
        if(i!=0) paths +=findPath(i-1,j,grid,dp);
        if(j!=0) paths +=findPath(i,j-1,grid,dp);
        return dp[i][j]=paths;
    }
}