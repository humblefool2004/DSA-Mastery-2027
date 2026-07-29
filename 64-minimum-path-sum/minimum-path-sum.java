class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int[][] dp= new int[m][n];
        dp[0][0]= grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]= dp[i-1][0] +grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]= dp[0][j-1] + grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}

//recursion + memo
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n= grid[0].length;
//         Integer[][] dp= new Integer[m][n];
//         return findMin(grid,m-1,n-1,dp);
//     }

//     private int findMin(int[][] grid, int i, int j,Integer[][] dp){

//         if(i==0 && j==0) return grid[0][0];
//         if(dp[i][j]!=null) return dp[i][j];
//         int a= Integer.MAX_VALUE;
//         int b= Integer.MAX_VALUE;
//         if(i!=0) a=findMin(grid,i-1,j,dp); 
//         if(j!=0) b=findMin(grid,i,j-1,dp);
//         return dp[i][j] =grid[i][j] + Math.min(a,b);
//     }
// }